package de.gaalop.gappco.hardware;

import java.util.LinkedList;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class ConfigurationLineWithTwinValue extends ConfigurationLineWithValue {
    
    public ConfigurationValue value2;
    public String meaning2;
    
    public ConfigurationLineWithTwinValue(ConfigurationValue value, String meaning, ConfigurationValue value2, String meaning2) {
        super(value, meaning);
        this.value2 = value2;
        this.meaning2 = meaning2;
    }
    
    @Override
    public String toString() {
        return valueToString(value)+"/"+valueToString(value2) + " // " + meaning + " / "+meaning2;
    }
    
    @Override
    public LinkedList<ConfigurationValue> getConfigurationValues() {
        LinkedList<ConfigurationValue> result = new LinkedList<>();
        result.add(value);
        result.add(value2);
        return result;
    }
}
