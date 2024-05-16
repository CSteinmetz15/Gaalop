package de.gaalop.gappco.hardware;

import de.gaalop.gapp.instructionSet.CalculationType;
import java.awt.Dimension;
import java.util.HashMap;

/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class HardwareDescription {
    
    public HashMap<Dimension, Long> maximumDotVectorUnits; // null of a given dimension = Unlimited
    public Long maximumRegisterLength; // null = Unlimited
    public HashMap<CalculationType, Long> maximumCalculationUnits; // null of a given calculationType = Unlimited
    public boolean canCreateOwnDimensions;

    public HardwareDescription() {
        this.maximumRegisterLength = null;
        this.maximumDotVectorUnits = new HashMap<>();
        this.maximumCalculationUnits = new HashMap<>();
        this.canCreateOwnDimensions = false;
    }

    public HardwareDescription(Long maximumRegisterLength, HashMap<Dimension, Long> maximumDotVectorUnits, HashMap<CalculationType, Long> maximumCalculationUnits, boolean canCreateOwnDimensions) {
        this.maximumRegisterLength = maximumRegisterLength;
        this.maximumDotVectorUnits = maximumDotVectorUnits;
        this.maximumCalculationUnits = maximumCalculationUnits;
        this.canCreateOwnDimensions = canCreateOwnDimensions;
    }
    
    public static HardwareDescription paperDesign() {
        HashMap<Dimension, Long> dotVectorUnits = new HashMap<>();
        dotVectorUnits.put(new Dimension(2, 4), 3L);            // Three dotvector units with for scalarproduct of two 4-width-vectors
        
        HashMap<CalculationType, Long> calculationUnits = new HashMap<CalculationType, Long>();
        for (CalculationType type: CalculationType.values())
            calculationUnits.put(type, 0L);
        
        return new HardwareDescription(32L, dotVectorUnits, calculationUnits, false);    // 32 times 32-bit registers
    }
    
    public static HardwareDescription unlimitedDesign() {   // good for theoretical check
        HashMap<Dimension, Long> dotVectorUnits = new HashMap<>();
        dotVectorUnits.put(new Dimension(2, 4), null);            // Three dotvector units with for scalarproduct of two 4-width-vectors
        dotVectorUnits.put(new Dimension(4, 4), null);
        dotVectorUnits.put(new Dimension(3, 4), null);
        
        HashMap<CalculationType, Long> calculationUnits = new HashMap<CalculationType, Long>();
        for (CalculationType type: CalculationType.values())
            calculationUnits.put(type, null);
        
        return new HardwareDescription(null, dotVectorUnits, calculationUnits, true);    // 32 times 32-bit registers
    }

    @Override
    public String toString() {
        return "description: [registerlength="+maximumRegisterLength+", dotvectorunits="+maximumDotVectorUnits.toString()+"]";
    }

}
