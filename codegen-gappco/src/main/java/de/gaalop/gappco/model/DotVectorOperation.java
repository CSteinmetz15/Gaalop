package de.gaalop.gappco.model;

import java.awt.Dimension;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author steinmetz
 */
public class DotVectorOperation extends LinkedList<Vector> {
    
    public int stage;
    public RegisterEntry destEntry;

    @Override
    public String toString() {
        return destEntry.toString() + " = <"+StringUtils.join(this, ", ")+">";
    }

    public int getRowCount() {
        int max = 0;
        for (Vector v: this) 
            max = Math.max(max, v.size());
        return max;
    }
    
    public Dimension getDimension() {
        return new Dimension(size(), getRowCount());
    }
    
    
    
}
