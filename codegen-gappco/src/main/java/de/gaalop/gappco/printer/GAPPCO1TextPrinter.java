package de.gaalop.gappco.printer;

import de.gaalop.gappco.hardware.ConfigurationList;
import de.gaalop.gappco.hardware.ConfigurationValue;
import de.gaalop.gappco.hardware.DotVectorUnit;
import de.gaalop.gappco.hardware.HardwareAllocation;
import de.gaalop.gappco.model.CalculateOperation;
import de.gaalop.gappco.model.DotVectorOperation;
import de.gaalop.gappco.model.GappcoProgram;
import de.gaalop.gappco.model.RegisterEntry;
import de.gaalop.gappco.model.RegisterEntryLink;
import de.gaalop.gappco.model.RegisterEntryMeaningType;
import de.gaalop.gappco.model.Vector;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class GAPPCO1TextPrinter {
    
    //TODO here we must add the Calculate Units
    
    public String print(HardwareAllocation allocation, ConfigurationList configurationList, String srcName) {
        GappcoProgram p = allocation.program;
        
        StringBuilder code = new StringBuilder();
        
        code.append("// ******* generateGAPPCOI: ************************************************  \n");
        code.append("// ******* Filename: "+srcName+"\n\n");
        
        code.append("// InputsVector:");
        for (RegisterEntry entry: p.register) {
            if (entry.isOfType(RegisterEntryMeaningType.INPUT)) {
                code.append("  " + entry.getFirst().value.prettyPrint()+ "@"+entry.getFirst().stage);
            }
        }
            
        code.append("\n");
        
        code.append("\n");
        
        for (DotVectorOperation dvu: p.dotVectorOperations) {
        code.append("// Result "+dvu.destEntry+" "+dvu.getRowCount()+" X "+dvu.size()+ " @"+dvu.stage+" --> DotVector Unit "+ allocation.getUnitIndex(dvu) +"\n");
            int index = 1;
            for (Vector v: dvu) {
                code.append("// vector"+index+ " "+v.name+": " + StringUtils.join(v, " ")+"\n");
                index++;
            }
            code.append("\n");
        }
        
        code.append("\n");
        
        code.append("// ******* GAPPCO I RegisterFile: ************************************************\n");
        
        int index = 0;
        for (RegisterEntry entry: p.register) {
            code.append("// "+index+": "+entry.toFullString()+ "@"+entry.getFirst().stage+ "\n");
            index++;
        }

        code.append("\n");
        
        // Use allocation for configuration bits
        code.append("// ******* GAPPCO I DotVectors Units: ************************************************\n");
        
        //first approach only for 4x2 Dotvector Units!
        index = 1;
        for (DotVectorUnit dvu: allocation.dotVectorUnits) {
            code.append("DotVectors"+index+":\n");
            code.append("EN: "+ (dvu.operations.size() > 1 ? "1": "0")+"\n");    //Enable splitting, when more dotvector operations exist in one unit
            RegisterEntryLink[][] factors = dvu.getFactors();
            for (int factor=1;factor<=dvu.dimension.width;factor++) {
                code.append("FACTOR"+factor+":");
                for (int i=1;i <= dvu.dimension.height;i++) {
                    RegisterEntryLink link = factors[factor-1][i-1];
                    code.append(" "+(link != null ? p.register.linkToSignedIndex(link) : null));
                }
                code.append("\n");
            }
            code.append("RESULT:");
            for (DotVectorOperation op: dvu.operations)
                code.append(" "+p.register.indexOf(op.destEntry));
            code.append("\n");
            
            code.append("\n");
            index++;
        }
        
        code.append("\n");
        
        code.append("// ******* GAPPCO I Calculate Units: ************************************************\n");
        
        //first approach only for 4x2 Dotvector Units!
        index = 1;
        for (CalculateOperation calcOp: allocation.calculateUnits) {
            code.append("CalculateUnit"+index+":\n");
            code.append("FUNCTION: "+calcOp.function+"\n");
            code.append("INPUTS: "+p.register.indexOf(calcOp.input1));
            if (calcOp.input2 != null)
                code.append(" "+p.register.indexOf(calcOp.input2));
            code.append("\n");
            code.append("RESULT: "+p.register.indexOf(calcOp.destEntry)+"\n");
           
            code.append("\n");
            index++;
        }
        
        code.append("\n");
        
        // Use allocation for configuration bits
        code.append("// ******* GAPPCO I Configuration data: ************************************************\n");
        code.append(configurationList);
        
        code.append("\n");
        code.append("// ***** GAPPCO I Configuration data as hexstream (Padded with zeroes at the end): *****\n");
        ConfigurationList list = new ConfigurationList();
        list.fromHardwareAllocation(allocation);
        LinkedList<ConfigurationValue> values = list.getConfigurationValues();
        
        String bitstream = StringUtils.join(values, "");
        code.append(getHexFromBitstream(bitstream));
        
        return code.toString();
    }
    
    private String getHexFromBitstream(String bitstream) {
        while (bitstream.length() % 8 != 0)
            bitstream += "0";
        
        String hex = "";
        for (int index = 0;index<bitstream.length(); index+=4) {
            String data = bitstream.substring(index, index+4);
            hex += Integer.toHexString(Integer.parseInt(data, 2));
        }
        return hex;
    }
    
    
}
