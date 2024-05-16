package de.gaalop.gappco.hardware;

import de.gaalop.gapp.variables.GAPPConstant;
import de.gaalop.gappco.model.CalculateOperation;
import de.gaalop.gappco.model.DotVectorOperation;
import de.gaalop.gappco.model.GappcoProgram;
import de.gaalop.gappco.model.ModelImporter;
import de.gaalop.gappco.model.RegisterEntryLink;
import de.gaalop.gappco.model.RegisterEntryMeaningType;
import de.gaalop.gappco.model.RegisterFile;
import de.gaalop.gappco.model.Vector;
import java.awt.Dimension;
import java.util.LinkedList;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class HardwareAllocator {
    
    public HardwareAllocation allocateProgram(GappcoProgram program, HardwareDescription description) throws Exception {
        HardwareAllocation allocation = new HardwareAllocation(description, program);
        
        // We have to slice per stage!
        //int maxStage = program.getMaxStage();
        
        //LinkedList<DotVectorOperation> adaptedOperations = new LinkedList<>();
        for (DotVectorOperation op: program.dotVectorOperations) {
            Dimension dimension = op.getDimension();
            LinkedList<DotVectorUnit> notFullUnits = allocation.getNotFullUnits(dimension);
            
            DotVectorUnit unit;
            if (notFullUnits.isEmpty()) {
                unit = allocation.getNewUnit(dimension);
                if (unit == null) {
                    if (description.canCreateOwnDimensions) {
                        unit = new DotVectorUnit(dimension);
                        System.out.println("Warning: Creating DotvectorUnit with own dimension ("+dimension.width+","+dimension.height+").");
                    } else
                        throw new Exception("No more free dotvectorunits of type ("+dimension.width+","+dimension.height+") to allocate dotvectorunit!");
                }
                    
            } else {
                unit = notFullUnits.getFirst();
            }
            
            
            DotVectorOperation preparedOperation = prepareOperationForUnit(op, unit.dimension.width, program.register);
            
           // if (preparedOperation != op)
           //     System.out.println("Before: "+op.toString()+" | After: "+preparedOperation.toString());
            
            unit.operations.add(preparedOperation);  
            //adaptedOperations.add(preparedOperation);
        }
        
        //program.dotVectorOperations = adaptedOperations;
        
        //LinkedList<CalculateOperation> adaptedCalcOperations = new LinkedList<>();
        for (CalculateOperation op: program.calculateOperations) {
            if (!allocation.allocateCalculateOperation(op)) {
                throw new Exception("No more free calculateoperation (function="+op.function+") to allocate!");
            }
            
        }
        //program.calculateOperations = adaptedCalcOperations;
        
        return allocation;
    }
    
    

    private DotVectorOperation prepareOperationForUnit(DotVectorOperation op, int unitWidth, RegisterFile register) {
        // result op must be even in height and adjusted at width on unit
        Dimension opDim = op.getDimension();
        if (opDim.height % 2 == 0) {
            // height is o.k.
            if (opDim.width == unitWidth) {
                // width is o.k. -> return original dot vector operation
                return op;
            } else {
                // fill with ones in rest columns
                DotVectorOperation result = new DotVectorOperation();
                result.destEntry = op.destEntry;
                result.stage = op.stage;
                
                // vectors of original operation
                result.addAll(op);
                
                // plus rest as one's vectors
                RegisterEntryLink entryLinkValueOne = register.getRegisterEntryLink(new GAPPConstant(1), RegisterEntryMeaningType.CONSTANT, ModelImporter.CONST_STAGE);
                for (int col=op.size();col<unitWidth;col++) {
                    Vector oneVector = new Vector("ones_generated");
                    for (int row = 1;row <= opDim.height; row++)
                        oneVector.add(entryLinkValueOne);
                    result.add(oneVector);
                }
                return result;
            }
        } else {
            //filled with zeroes in next row
            DotVectorOperation result = new DotVectorOperation();
            result.destEntry = op.destEntry;
            result.stage = op.stage;
            RegisterEntryLink entryLinkValueZero = register.getRegisterEntryLink(new GAPPConstant(0), RegisterEntryMeaningType.CONSTANT, ModelImporter.CONST_STAGE);
            if (opDim.width == unitWidth) {
                // width is o.k. -> add a row with zeroes
                for (Vector v: op) {
                    Vector augm = new Vector("augmented_generated");
                    augm.addAll(v);
                    augm.add(entryLinkValueZero);
                    result.add(augm);
                }
                return result;
            } else {
                // width is n.o.k. and row with zeroes is also needed
                RegisterEntryLink entryLinkValueOne = register.getRegisterEntryLink(new GAPPConstant(1), RegisterEntryMeaningType.CONSTANT, ModelImporter.CONST_STAGE);
                for (Vector v: op) {
                    Vector augm = new Vector("augmented_generated");
                    augm.addAll(v);
                    augm.add(entryLinkValueZero);
                    result.add(augm);
                }
                for (int col=op.size();col<unitWidth;col++) {
                    Vector oneVector = new Vector("ones_generated");
                    for (int row = 1;row <= opDim.height+1; row++)
                        oneVector.add(entryLinkValueOne);
                    result.add(oneVector);
                }
                return result;
            }
        }
    }
    
}
