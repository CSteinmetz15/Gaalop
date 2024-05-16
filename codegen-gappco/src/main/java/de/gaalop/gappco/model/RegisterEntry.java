package de.gaalop.gappco.model;

import de.gaalop.gapp.variables.GAPPValueHolder;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author steinmetz
 */
public class RegisterEntry extends LinkedList<RegisterEntryMeaning> {

    public RegisterEntry(RegisterEntryMeaning m) {
        add(m);
    }
    
    public RegisterEntry(GAPPValueHolder value, RegisterEntryMeaningType type, int stage) {
        this(new RegisterEntryMeaning(value, type, stage));
    }
    
    public boolean hasValue(GAPPValueHolder value) {
        for (RegisterEntryMeaning m: this) 
            if (GAPPEqualTester.equals(m.value, value))
                return true;
        return false;
    }
    
    public boolean isOfType(RegisterEntryMeaningType type) {
        for (RegisterEntryMeaning m: this) 
            if (m.type == type)
                return true;
        return false;
    }

    @Override
    public String toString() {
        return getFirst().toString();
    }
    
    public String toFullString() {
        return StringUtils.join(this, ", ");
    }
    
    public int getStage() {
        int stage = Integer.MIN_VALUE;
        for (RegisterEntryMeaning m: this) 
            stage = Math.max(stage, m.stage);
        return stage;
    }
}
