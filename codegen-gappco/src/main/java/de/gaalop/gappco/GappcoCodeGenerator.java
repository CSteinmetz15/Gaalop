package de.gaalop.gappco;

import de.gaalop.gappco.model.ModelImporter;
import de.gaalop.gappco.model.GappcoProgram;
import de.gaalop.CodeGenerator;
import de.gaalop.CodeGeneratorException;
import de.gaalop.CompilationException;
import de.gaalop.OutputFile;
import de.gaalop.cfg.ControlFlowGraph;
import de.gaalop.gapp.visitor.PrettyPrint;
import de.gaalop.gappco.hardware.ConfigurationList;
import de.gaalop.gappco.hardware.HardwareAllocation;
import de.gaalop.gappco.hardware.HardwareAllocator;
import de.gaalop.gappco.hardware.HardwareDescription;
import de.gaalop.gappco.hardware.simulation.HardwareAllocationSimulation;
import de.gaalop.gappco.printer.GAPPCO1TextPrinter;
import java.util.Set;
import java.util.Collections;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * This class facilitates GAPPCO code generation.
 */
public class GappcoCodeGenerator implements CodeGenerator {
    
    private final Plugin plugin;
    
    GappcoCodeGenerator(Plugin plugin) {
    	this.plugin = plugin;
    }

    @Override
    public Set<OutputFile> generate(ControlFlowGraph in) throws CodeGeneratorException {
        try {
            String filename = generateFilename(in);
            
            /*
            PrettyPrint printer1 = new PrettyPrint();
            in.accept(printer1);
            System.out.println(printer1.getResultString());
            */
            
            GappcoProgram gappcoProgram = ModelImporter.importGraph(in);
            
            HardwareDescription hardwareDescription = HardwareDescription.unlimitedDesign();

            HardwareAllocator allocator = new HardwareAllocator();
            HardwareAllocation allocation = allocator.allocateProgram(gappcoProgram, hardwareDescription);
            
            /*
            HardwareAllocationSimulation simulation = new HardwareAllocationSimulation();
            HashMap<String, Double> inputVars = new HashMap<String, Double>();
            inputVars.put("a1", 1.0);
            inputVars.put("a2", 2.0);
            inputVars.put("a3", 3.0);
            inputVars.put("a4", 4.0);
            inputVars.put("m1", 1.0);
            inputVars.put("m2", 2.0);
            inputVars.put("m3", 3.0);
            inputVars.put("m4", 4.0);

            simulation.simulate(inputVars, allocation);
            */
            
            ConfigurationList configurationList = new ConfigurationList();
            configurationList.fromHardwareAllocation(allocation);
            
            GAPPCO1TextPrinter printer = new GAPPCO1TextPrinter();

            OutputFile sourceFile = new OutputFile(filename, printer.print(allocation, configurationList, in.getSource().getName()), Charset.forName("UTF-8"));
            return Collections.singleton(sourceFile);
        } catch (Exception ex) {
            throw new CodeGeneratorException(in, ex.getMessage(), ex);
        }
    }

    private String generateFilename(ControlFlowGraph in) {
        String filename = "gaalop.gappco";
        if (in.getSource() != null) {
            filename = in.getSource().getName();
            int lastDotIndex = filename.lastIndexOf('.');
            if (lastDotIndex != -1) {
                filename = filename.substring(0, lastDotIndex);
            }
            filename += ".gappco";
        }
        return filename;
    }

}
