package de.gaalop.gappco.model;

import de.gaalop.cfg.ControlFlowGraph;
import de.gaalop.gapp.ConstantSetVectorArgument;
import de.gaalop.gapp.PairSetOfVariablesAndIndices;
import de.gaalop.gapp.PosSelector;
import de.gaalop.gapp.Selector;
import de.gaalop.gapp.Selectorset;
import de.gaalop.gapp.SetVectorArgument;
import de.gaalop.gapp.instructionSet.GAPPAssignInputsVector;
import de.gaalop.gapp.instructionSet.GAPPAssignMv;
import de.gaalop.gapp.instructionSet.GAPPCalculateMv;
import de.gaalop.gapp.instructionSet.GAPPCalculateMvCoeff;
import de.gaalop.gapp.instructionSet.GAPPDotVectors;
import de.gaalop.gapp.instructionSet.GAPPResetMv;
import de.gaalop.gapp.instructionSet.GAPPSetMv;
import de.gaalop.gapp.instructionSet.GAPPSetVector;
import de.gaalop.gapp.variables.GAPPConstant;
import de.gaalop.gapp.variables.GAPPMultivector;
import de.gaalop.gapp.variables.GAPPMultivectorComponent;
import de.gaalop.gapp.variables.GAPPScalarVariable;
import de.gaalop.gapp.variables.GAPPValueHolder;
import de.gaalop.gapp.variables.GAPPVector;
import de.gaalop.gapp.visitor.CFGGAPPVisitor;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class ModelImporter extends CFGGAPPVisitor {
    
    private GappcoProgram program = new GappcoProgram();
    
    public static final int CONST_STAGE = 0;
    
    public static GappcoProgram importGraph(ControlFlowGraph in) {
        ModelImporter importer = new ModelImporter();
        in.accept(importer);
        return importer.program;
    }
    
    public RegisterEntry getRegisterEntry(GAPPMultivectorComponent mvc) {
        return mvc.getName().equals("inputsVector")
            ? program.register.getInput(mvc.getBladeIndex())
            : program.register.getRegisterEntry(mvc);
    }
    
    @Override
    public Object visitAssignInputsVector(GAPPAssignInputsVector g, Object arg) {
        for (GAPPValueHolder v: g.getValues()) {
            if (v instanceof GAPPScalarVariable) {
                program.register.addEntry(v, RegisterEntryMeaningType.INPUT, CONST_STAGE);
            } else
                throw new IllegalStateException("assignInputsVector must consist of GAPPScalarVariable instances only!");
        }
        return null;
    }

    @Override
    public Object visitAssignMv(GAPPAssignMv g, Object arg) {
        String destName = g.getDestination().getName();
        for (int index = 0; index<g.getValues().size();index++) {
            PosSelector sel = g.getSelectors().get(index);
            GAPPConstant value = g.getValues().get(index);
            
            Integer valueIndex = program.register.getIndex(value, RegisterEntryMeaningType.CONSTANT, CONST_STAGE);
            GAPPMultivectorComponent mvc = new GAPPMultivectorComponent(destName, sel.getIndex());
            program.register.get(valueIndex).add(new RegisterEntryMeaning(mvc, RegisterEntryMeaningType.OUTPUT, CONST_STAGE));
        }
        return null;
    }
    
    @Override
    public Object visitSetMv(GAPPSetMv g, Object arg) {
        String srcName = g.getSource().getName();
        String destName = g.getDestination().getName();
        for (int index = 0; index<g.getSelectorsSrc().size();index++) {
            Selector srcSel = g.getSelectorsSrc().get(index);
            PosSelector destSel = g.getSelectorsDest().get(index);
            
            RegisterEntryLink srcLink = new RegisterEntryLink(getRegisterEntry(new GAPPMultivectorComponent(srcName, srcSel.getIndex())), srcSel.getSign());
            int srcStage = srcLink.entry.getFirst().stage;
            RegisterEntry destEntry = program.register.addEntry(new GAPPMultivectorComponent(destName, destSel.getIndex()), RegisterEntryMeaningType.OUTPUT, srcStage+1);
            program.copyInstructions.add(new CopyInstruction(srcLink, destEntry));
        }
        return null;
    }
    
    @Override
    public Object visitSetVector(GAPPSetVector g, Object arg) {
        Vector links = new Vector(g.getDestination().getName());
        for (SetVectorArgument vectorArg: g.getEntries()) {
            if (vectorArg instanceof ConstantSetVectorArgument) {
                double value = ((ConstantSetVectorArgument) vectorArg).getValue();
                links.add(program.register.getRegisterEntryLink(new GAPPConstant(value), new GAPPConstant(-value), RegisterEntryMeaningType.CONSTANT, CONST_STAGE));
            } else if (vectorArg instanceof PairSetOfVariablesAndIndices) {
                PairSetOfVariablesAndIndices pair = (PairSetOfVariablesAndIndices) vectorArg;
                String srcName = pair.getSetOfVariable().getName();
                Selectorset selectors = pair.getSelectors();
                
                if (srcName.equals("inputsVector")) {
                    for (Selector sel: selectors) 
                        links.add(new RegisterEntryLink(program.register.getInput(sel.getIndex()), sel.getSign()));
                } else {
                    if (pair.getSetOfVariable() instanceof GAPPMultivector) {
                        for (Selector sel: selectors) 
                            links.add(new RegisterEntryLink(getRegisterEntry(new GAPPMultivectorComponent(srcName, sel.getIndex())), sel.getSign()));
                    } else if (pair.getSetOfVariable() instanceof GAPPVector) {
                        for (Selector sel: selectors) {
                            RegisterEntryLink link = program.vectors.get(srcName).get(sel.getIndex());
                            links.add(new RegisterEntryLink(link.entry, (byte) (link.prefactor*sel.getSign())));
                        }
                    } else
                        throw new IllegalStateException("GAPPSetVector contains whether constants, nor multivector components, nor vector components!");
                }
            } 
        }
        program.vectors.put(g.getDestination().getName(), links);
        return null;
    }

    @Override
    public Object visitDotVectors(GAPPDotVectors g, Object arg) {
        DotVectorOperation dotOp = new DotVectorOperation();
        //Parts: LinkedList<GAPPVector>
        //DestSelector: Selector
        //Destination as GAPPMultivector
        
        // Add part vectors and compute max stage of source
        int srcStage = 0;
        for (GAPPVector part: g.getParts()) {
            Vector partVector = program.vectors.get(part.getName());
            dotOp.add(partVector);
            srcStage = Math.max(srcStage, partVector.getStage());
        }
        
        dotOp.stage = srcStage;
        
        GAPPMultivectorComponent mvc = new GAPPMultivectorComponent(g.getDestination().getName(), g.getDestSelector().getIndex());
        
        if (g.getDestSelector().getSign() == 1) {
            dotOp.destEntry = program.register.addEntry(mvc, RegisterEntryMeaningType.OUTPUT, srcStage+1);
        } else {
            dotOp.destEntry = program.register.addEntry(new GAPPScalarVariable("temp"), RegisterEntryMeaningType.DV_RESULT, srcStage+1);
            RegisterEntry destEntry = program.register.addEntry(mvc, RegisterEntryMeaningType.OUTPUT, srcStage+2);
            program.copyInstructions.add(new CopyInstruction(new RegisterEntryLink(dotOp.destEntry, (byte) -1), destEntry));
        }
        
        program.dotVectorOperations.add(dotOp);
        return null;
    }
    
    @Override
    public Object visitResetMv(GAPPResetMv g, Object arg) {
        // no operation is required here
        return null;
    }

    @Override
    public Object visitCalculateMv(GAPPCalculateMv g, Object arg) {
        throw new IllegalStateException("CalculateMv is not implemented. Try to use calculateMvCoeff, if possible!");
        //return null;
    }

    @Override
    public Object visitCalculateMvCoeff(GAPPCalculateMvCoeff g, Object arg) {
        CalculateOperation calcOp = new CalculateOperation();
        calcOp.function = g.getType();
        
        calcOp.input1 = getRegisterEntry(new GAPPMultivectorComponent(g.getOperand1().getName(), 0));
        calcOp.input2 = (g.getOperand2() != null) ? getRegisterEntry(new GAPPMultivectorComponent(g.getOperand2().getName(), 0)) : null;

        calcOp.stage = calcOp.input1.getStage();
        if (calcOp.input2 != null)
            calcOp.stage = Math.max(calcOp.stage, calcOp.input2.getStage());
        
        GAPPMultivectorComponent mvc = g.getDestination();
        
        calcOp.destEntry = program.register.addEntry(mvc, RegisterEntryMeaningType.OUTPUT, calcOp.stage+1);
        
        program.calculateOperations.add(calcOp);
        return null;
    }
}
