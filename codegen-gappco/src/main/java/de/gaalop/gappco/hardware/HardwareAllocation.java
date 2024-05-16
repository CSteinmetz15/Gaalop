package de.gaalop.gappco.hardware;

import de.gaalop.gapp.instructionSet.CalculationType;
import de.gaalop.gappco.model.CalculateOperation;
import de.gaalop.gappco.model.DotVectorOperation;
import de.gaalop.gappco.model.GappcoProgram;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 *
 * @author Christian Steinmetz, :em AG, 2020
 */
public class HardwareAllocation {
    
    public GappcoProgram program;
    
    public HardwareDescription description;
    
    public HashMap<Dimension, Long> createdUnits = new HashMap<>();
    
    public HashMap<CalculationType, Long> createdCalculationUnits = new HashMap<>();
    
    public ArrayList<DotVectorUnit> dotVectorUnits = new ArrayList<>();
    public ArrayList<CalculateOperation> calculateUnits = new ArrayList<>();

    public HardwareAllocation(HardwareDescription description, GappcoProgram program) {
        this.program = program;
        this.description = description;
    }
    
    public LinkedList<DotVectorUnit> getNotFullUnits(Dimension minimalDimension) {
        LinkedList<DotVectorUnit> result = new LinkedList<>();
        for (DotVectorUnit dvu: dotVectorUnits) 
            if (dvu.dimension.width >= minimalDimension.width && dvu.getFreeDimension().height >= minimalDimension.height)
                result.add(dvu);
        return result;
    }
    
    
    
    private HashSet<Dimension> getFreeUnitTypes() {
        HashSet<Dimension> result = new HashSet<Dimension>();
        for (Dimension key: description.maximumDotVectorUnits.keySet()) {
            if (description.maximumDotVectorUnits.get(key) == null || description.maximumDotVectorUnits.get(key) > createdUnits.getOrDefault(key, 0L))
                result.add(key);
        }
            
        return result;
    }

    public DotVectorUnit getNewUnit(Dimension minimalDimension) {
        HashSet<Dimension> freeTypes = getFreeUnitTypes();
        
        //first try to fit optimal
        if (freeTypes.contains(new Dimension(minimalDimension.width, minimalDimension.height))) {
            createdUnits.put(new Dimension(minimalDimension.width, minimalDimension.height), createdUnits.getOrDefault(new Dimension(minimalDimension.width, minimalDimension.height), 0L) + 1);
            DotVectorUnit dvu = new DotVectorUnit(new Dimension(minimalDimension.width, minimalDimension.height));
            dotVectorUnits.add(dvu);
            return dvu;
        }
        
        //try to fit to optimal width
        int minHeight = Integer.MAX_VALUE;
        for (Dimension dimension: freeTypes) {
            if (dimension.width == minimalDimension.width && dimension.height >= minimalDimension.height) {
                minHeight = Math.min(minHeight, dimension.height);
            }
        }
        if (freeTypes.contains(new Dimension(minimalDimension.width, minHeight))) {
            createdUnits.put(new Dimension(minimalDimension.width, minHeight), createdUnits.getOrDefault(new Dimension(minimalDimension.width, minHeight), 0L) + 1);
            DotVectorUnit dvu = new DotVectorUnit(new Dimension(minimalDimension.width, minHeight));
            dotVectorUnits.add(dvu);
            return dvu;
        }
        
        //we have also the possiblity to use more-wider vectors if they have the minimum height
        LinkedList<Dimension> widerUnits = new LinkedList<>();
        for (Dimension dimension: freeTypes) 
            if (dimension.width > minimalDimension.width && dimension.height >= minimalDimension.height) 
                widerUnits.add(dimension);
        
        if (widerUnits.isEmpty())
            return null;
        
        if (widerUnits.size() == 1) {
            createdUnits.put(widerUnits.getFirst(), createdUnits.getOrDefault(widerUnits.getFirst(), 0L) + 1);
            DotVectorUnit dvu = new DotVectorUnit(widerUnits.getFirst());
            dotVectorUnits.add(dvu);
            return dvu;
        }
        
        Collections.sort(widerUnits, new Comparator<Dimension>() {
            @Override
            public int compare(Dimension o1, Dimension o2) {
                if (o1.width != o2.width)
                    return o2.width - o1.width;
                else
                    return o2.height - o1.height;
            }
        });
        
        createdUnits.put(widerUnits.getFirst(), createdUnits.getOrDefault(widerUnits.getFirst(), 0L) + 1);
        DotVectorUnit dvu = new DotVectorUnit(widerUnits.getFirst());
        dotVectorUnits.add(dvu);
        return dvu;
    }

    @Override
    public String toString() {
        return dotVectorUnits.toString(); 
    }

    public Integer getUnitIndex(DotVectorOperation dvu) {
        int index = 1;
        for (DotVectorUnit unit: dotVectorUnits) {
            if (unit.operations.contains(dvu)) 
                return index;
            index++;
        }
        return null;
    }
    
    public HashSet<CalculationType> getFreeCalculationUnitTypes() {
        HashSet<CalculationType> result = new HashSet<CalculationType>();
        for (CalculationType key: description.maximumCalculationUnits.keySet()) {
            if (description.maximumCalculationUnits.get(key) == null || description.maximumCalculationUnits.get(key) > createdCalculationUnits.getOrDefault(key, 0L))
                result.add(key);
        }
            
        return result;
    }

    public boolean allocateCalculateOperation(CalculateOperation op) {
        if (getFreeCalculationUnitTypes().contains(op.function)) {
            createdCalculationUnits.put(op.function, createdCalculationUnits.getOrDefault(op.function, 0L) + 1);
            calculateUnits.add(op);
            return true;
        }
        else 
            return false;
    }
}
