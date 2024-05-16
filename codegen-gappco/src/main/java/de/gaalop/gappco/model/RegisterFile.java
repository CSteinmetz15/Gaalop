package de.gaalop.gappco.model;

import de.gaalop.gapp.variables.GAPPValueHolder;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author steinmetz
 */
public class RegisterFile extends ArrayList<RegisterEntry> {
    
    
    public RegisterEntry getRegisterEntry(GAPPValueHolder value) {
        for (RegisterEntry entry: this)
            if (entry.hasValue(value))
                return entry;
        
        return null;    
    }
    
    public RegisterEntryLink getRegisterEntryLink(GAPPValueHolder value) {
        for (RegisterEntry entry: this)
            if (entry.hasValue(value))
                return new RegisterEntryLink(entry, (byte) 1);
        
        return null;  
    }
    
    public RegisterEntryLink getRegisterEntryLink(GAPPValueHolder value, RegisterEntryMeaningType type, int stage) {
        RegisterEntryLink result = getRegisterEntryLink(value);
        if (result == null) {
            RegisterEntry entry = new RegisterEntry(value, type, stage);
            add(entry);
            result = new RegisterEntryLink(entry, (byte) 1); 
        }
        return result;    
    }
    
    public RegisterEntryLink getRegisterEntryLink(GAPPValueHolder value, GAPPValueHolder negativeValue) {
        for (RegisterEntry entry: this)
            if (entry.hasValue(value))
                return new RegisterEntryLink(entry, (byte) 1);
        
        for (RegisterEntry entry: this)
            if (entry.hasValue(negativeValue))
                return new RegisterEntryLink(entry, (byte) -1);
        
        return null;    
    }
    
    public RegisterEntryLink getRegisterEntryLink(GAPPValueHolder value, GAPPValueHolder negativeValue, RegisterEntryMeaningType type, int stage) {
        RegisterEntryLink result = getRegisterEntryLink(value, negativeValue);
        if (result == null) {
            RegisterEntry entry = new RegisterEntry(value, type, stage);
            add(entry);
            result = new RegisterEntryLink(entry, (byte) 1); 
        }
        return result;    
    }
    
    public Integer getIndex(GAPPValueHolder value) {
        int index = 0;
        for (RegisterEntry entry: this) {
            if (entry.hasValue(value))
                return index;
            index++;
        }
        return null;    
    }
    
    public Integer getIndex(GAPPValueHolder value, RegisterEntryMeaningType type, int stage) {
        Integer index = getIndex(value);
        if (index == null) {
            index = size();
            add(new RegisterEntry(value, type, stage));
        }
        return index;    
    }
    
    public boolean hasValue(GAPPValueHolder value) {
        return getIndex(value) != null;
    }

    public RegisterEntry getInput(int index) {
        int found = -1;
        for (RegisterEntry entry: this) {
            if (entry.isOfType(RegisterEntryMeaningType.INPUT)) {
                found++;
            }
            if (found == index)
                return entry;
        }
        return null;  
    }
    
    public RegisterEntry addEntry(GAPPValueHolder value, RegisterEntryMeaningType type, int stage) {
        RegisterEntry entry = new RegisterEntry(value, type, stage);
        add(entry);
        return entry;
    }

    @Override
    public String toString() {
        return "["+StringUtils.join(this, ", ")+"]";
    }
    
    public String linkToSignedIndex(RegisterEntryLink link) {
        return (link.prefactor == 1 ? "" : "-")+indexOf(link.entry);
    }
}
