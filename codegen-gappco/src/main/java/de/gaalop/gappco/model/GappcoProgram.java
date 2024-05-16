package de.gaalop.gappco.model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author steinmetz
 */
public class GappcoProgram {
    
    public RegisterFile register = new RegisterFile();
    public LinkedList<CopyInstruction> copyInstructions = new LinkedList<>();
    public LinkedList<DotVectorOperation> dotVectorOperations = new LinkedList<>();
    public LinkedList<CalculateOperation> calculateOperations = new LinkedList<>();
    public HashMap<String, Vector> vectors = new HashMap<>();
    
    public int getMaxStage() {
        int maxStage = 0;
        for (DotVectorOperation op: dotVectorOperations)
            maxStage = Math.max(maxStage, op.stage);
        for (CalculateOperation op: calculateOperations)
            maxStage = Math.max(maxStage, op.stage);
        for (CopyInstruction op: copyInstructions)
            maxStage = Math.max(maxStage, op.getStage());
        return maxStage;
    }
}
