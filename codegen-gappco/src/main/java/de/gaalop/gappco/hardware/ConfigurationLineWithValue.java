package de.gaalop.gappco.hardware;

import java.util.LinkedList;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class ConfigurationLineWithValue extends ConfigurationLine {
    
    public ConfigurationValue value;

    public ConfigurationLineWithValue(ConfigurationValue value, String meaning) {
        super(meaning);
        this.value = value;
    }
    
    protected String valueToString(ConfigurationValue value) {
        return (value == null) ? "-" : Integer.toString(value.value);
    }
    
    @Override
    public String toString() {
        return valueToString(value) + " // " + meaning;
    }

    @Override
    public LinkedList<ConfigurationValue> getConfigurationValues() {
        LinkedList<ConfigurationValue> result = new LinkedList<>();
        result.add(value);
        return result;
    }
}
