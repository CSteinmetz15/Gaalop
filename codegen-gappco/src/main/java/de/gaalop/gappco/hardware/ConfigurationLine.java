package de.gaalop.gappco.hardware;

import java.util.LinkedList;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class ConfigurationLine {
    
    public String meaning;

    public ConfigurationLine(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "// "+meaning;
    }
    
    public LinkedList<ConfigurationValue> getConfigurationValues() {
        return new LinkedList<>();
    }
}
