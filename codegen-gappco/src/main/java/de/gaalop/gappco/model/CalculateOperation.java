package de.gaalop.gappco.model;

import de.gaalop.gapp.instructionSet.CalculationType;

/**
 *
 * @author Christian Steinmetz
 */
public class CalculateOperation {
    
    public RegisterEntry input1;
    public RegisterEntry input2; // if function is unary, then input2 is null!
    public int stage;
    public RegisterEntry destEntry;
    public CalculationType function;
    
    @Override
    public String toString() {
        return destEntry.toString() + " = "+function+"("+input1+","+input2+")";
    }
}
