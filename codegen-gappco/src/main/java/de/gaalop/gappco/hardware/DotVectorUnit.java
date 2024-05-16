package de.gaalop.gappco.hardware;

import de.gaalop.gappco.model.DotVectorOperation;
import de.gaalop.gappco.model.RegisterEntryLink;
import java.awt.Dimension;
import java.util.LinkedList;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class DotVectorUnit {
    
    public Dimension dimension;
    
    public LinkedList<DotVectorOperation> operations = new LinkedList<>();

    public DotVectorUnit(Dimension dimension) {
        this.dimension = dimension;
    }
    
    public Dimension getFreeDimension() {
        Dimension rest = new Dimension(dimension);
        for (DotVectorOperation op: operations) 
            rest.height -= op.getDimension().height;
        return rest;
    }

    @Override
    public String toString() {
        return operations.toString();
    }
    
    public RegisterEntryLink[][] getFactors() {
        RegisterEntryLink[][] factors = new RegisterEntryLink[dimension.width][dimension.height];
        for (int factor=0;factor<dimension.width;factor++) {
            factors[factor] = new RegisterEntryLink[dimension.height];
            int index = 0;
            for (DotVectorOperation op: operations) 
                for (RegisterEntryLink entry: op.get(factor)) {
                    factors[factor][index] = entry;
                    index++;
                }
        }
        return factors;
    }
 
}
