package de.gaalop.gappco.hardware;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class ConfigurationValue {
    
    public Integer value;
    public int bitlength;

    public ConfigurationValue(Integer value, int bitlength) {
        this.value = value;
        this.bitlength = bitlength;
    }

    @Override
    public String toString() {
        if (value == null) 
            return "-";
        String result = "";
        int mask = 1;
        for (int i=0;i<bitlength;i++) {
            result = ((mask & value) > 0 ? "1": "0") + result;
            mask *= 2;
        }
        if (value >= mask) {
            result = "Overflow of ConfigurationValue "+value +" on bitlength "+bitlength;
            System.err.println(result);
        }
        return result;
    }

}
