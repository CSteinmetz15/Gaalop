package de.gaalop.gappco.hardware.simulation;

import de.gaalop.gapp.variables.GAPPConstant;
import de.gaalop.gapp.variables.GAPPScalarVariable;
import de.gaalop.gappco.hardware.HardwareAllocation;
import de.gaalop.gappco.model.RegisterEntry;
import de.gaalop.gappco.model.RegisterEntryMeaning;
import de.gaalop.gappco.model.RegisterEntryMeaningType;
import de.gaalop.gappco.model.RegisterFile;
import java.util.HashMap;

/**
 *
 * @author Christian Steinmetz
 */
public class HardwareAllocationSimulation {
    
    private static void printRegisterValues(HashMap<RegisterEntry, Double> registerValues, RegisterFile register) {
        for (RegisterEntry entry: register)
            System.out.println(registerValues.getOrDefault(entry, Double.NaN));
    }
    
    public HashMap<String, Double> simulate(HashMap<String, Double> inputVars, HardwareAllocation allocation) {
        
        HashMap<RegisterEntry, Double> registerValues = new HashMap<>();
        RegisterFile registerFile = allocation.program.register;
        
        
        System.out.println("Register before input variables and constants:");
        printRegisterValues(registerValues, registerFile);
        
        // Fill input variables
        for (RegisterEntry entry: registerFile) {
            for (RegisterEntryMeaning meaning: entry) {
                switch (meaning.type) {
                    case CONSTANT:
                        registerValues.put(entry, ((GAPPConstant) meaning.value).getValue());
                        break;
                    case INPUT:
                        registerValues.put(entry, inputVars.get(((GAPPScalarVariable) meaning.value).getName()));
                        break;
                    default:
                        registerValues.put(entry, Double.NaN);
                }
            }
        }
        
        System.out.println("Register after input variables and constants:");
        printRegisterValues(registerValues, registerFile);
        
        
        HashMap<String, Double> output = null;
        return output;
    }
    
}
