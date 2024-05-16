package de.gaalop.gappco.model;

import de.gaalop.gapp.variables.GAPPValueHolder;

/**
 *
 * @author steinmetz
 */
public class RegisterEntryMeaning {
    
    public GAPPValueHolder value;
    public RegisterEntryMeaningType type;
    public int stage;                       //After which stage the value is in the register file

    public RegisterEntryMeaning(GAPPValueHolder value, RegisterEntryMeaningType type, int stage) {
        this.value = value;
        this.type = type;
        this.stage = stage;
    }

    @Override
    public String toString() {
        return value.prettyPrint();
    }

}
