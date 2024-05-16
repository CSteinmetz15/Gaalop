package de.gaalop.gappco.hardware;

import de.gaalop.gappco.model.CalculateOperation;
import de.gaalop.gappco.model.DotVectorOperation;
import de.gaalop.gappco.model.RegisterEntryLink;
import de.gaalop.gappco.model.RegisterFile;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class ConfigurationList extends LinkedList<ConfigurationLine> {

    private static int computeBitlengthOfNumber(int number) {
        return (int) Math.ceil(Math.log(number+1) / Math.log(2));
    }
    
    public void fromHardwareAllocation(HardwareAllocation allocation) {
        RegisterFile reg = allocation.program.register;
        int maxStage = allocation.program.getMaxStage();
        
        int adressSize = computeBitlengthOfNumber(reg.size());
        add(new ConfigurationLine("Bitlength of adresses: "+adressSize));
        int stageSize = computeBitlengthOfNumber(maxStage);
        add(new ConfigurationLine("Bitlength of stages: "+stageSize));
        int dotVectorCountSize = computeBitlengthOfNumber(allocation.dotVectorUnits.size());
        add(new ConfigurationLine("Bitlength of DotVector Count: "+dotVectorCountSize));
        
        int calculateCountSize = computeBitlengthOfNumber(allocation.calculateUnits.size());
        add(new ConfigurationLine("Bitlength of Calculate Count: "+calculateCountSize));
        
        add(new ConfigurationLineWithValue(new ConfigurationValue(1, 4), "No. of GAPP units"));
        add(new ConfigurationLineWithValue(new ConfigurationValue(allocation.dotVectorUnits.size(), dotVectorCountSize), "No. of 4-width DotVectors units for GAPP unit 1"));

        int index = 1;
        for (DotVectorUnit dvu: allocation.dotVectorUnits) {
            add(new ConfigurationLine("Configuration bits for DotVectors"+index));
            add(new ConfigurationLineWithTwinValue(new ConfigurationValue(dvu.operations.size() > 1 ? 1 : 0, 1), "EN"+index+"1", new ConfigurationValue(dvu.operations.size() > 1 ? 1 : 0, 1), "EN"+index+"2"));
            
            //MULT
            RegisterEntryLink[][] factors = dvu.getFactors();
            for (int mult = 1;mult<=factors[0].length;mult++) 
                for (int factor = 1; factor<=factors.length; factor++) {
                    RegisterEntryLink entryLink = factors[factor-1][mult-1];
                    
                    ConfigurationValue value = (entryLink != null) ? new ConfigurationValue(reg.indexOf(entryLink.entry), adressSize): null;
                    ConfigurationValue prefactor = (entryLink != null) ? new ConfigurationValue(entryLink.prefactor==1 ? 0: 1, 1): null;
                    
                    add(new ConfigurationLineWithTwinValue(value,"MULT"+index+""+mult+"_addr", prefactor,"MULT"+index+""+mult+"_sign"));
                }
                    
            
            //RESULT
            DotVectorOperation op1 = dvu.operations.getFirst();
            add(new ConfigurationLineWithTwinValue(new ConfigurationValue(reg.indexOf(op1.destEntry), adressSize), "RESULT"+index+"1"+"_addr" , new ConfigurationValue(maxStage-op1.stage, stageSize), "RESULT"+index+"1"+"_type"));
            if (dvu.operations.size() > 1) {
                DotVectorOperation op2 = dvu.operations.get(1);
                add(new ConfigurationLineWithTwinValue(new ConfigurationValue(reg.indexOf(op2.destEntry), adressSize), "RESULT"+index+"2"+"_addr" , new ConfigurationValue(maxStage-op2.stage, stageSize), "RESULT"+index+"2_type"));
            } else
                add(new ConfigurationLineWithTwinValue(new ConfigurationValue(reg.indexOf(op1.destEntry), adressSize), "RESULT"+index+"1"+"_addr UNUSED" , new ConfigurationValue(maxStage-op1.stage, stageSize), "RESULT"+index+"1"+"_type UNUSED"));
            
            index++;
        }
        
        add(new ConfigurationLineWithValue(new ConfigurationValue(allocation.calculateUnits.size(), 16), "No. of CalculateOperations"));
        
        index = 1;
        for (CalculateOperation calcOp: allocation.calculateUnits) {
            add(new ConfigurationLine("Configuration bits for CalculateOperation"+index));
            add(new ConfigurationLineWithValue(new ConfigurationValue(calcOp.function.ordinal(), 4), "FUNCTION "+calcOp.function));
            int numInputs = (calcOp.input2 == null) ? 1: 2;
            add(new ConfigurationLineWithValue(new ConfigurationValue(numInputs, 2), "NUM_INPUTS "+numInputs));
            add(new ConfigurationLineWithValue(new ConfigurationValue(reg.indexOf(calcOp.input1), adressSize), "INPUT1 "));
            add(new ConfigurationLineWithValue(new ConfigurationValue((calcOp.input2 != null) ? reg.indexOf(calcOp.input2): 0, adressSize), "INPUT2 "));
            add(new ConfigurationLineWithValue(new ConfigurationValue(reg.indexOf(calcOp.destEntry), adressSize), "RESULT"));
            index++;
        }
        
    }
    
    @Override
    public String toString() {
        return StringUtils.join(this, "\n");
    }
    
    public LinkedList<ConfigurationValue> getConfigurationValues() {
        LinkedList<ConfigurationValue> result = new LinkedList<>();
        for (ConfigurationLine line: this)
            result.addAll(line.getConfigurationValues());
        return result;
    }
    
}
