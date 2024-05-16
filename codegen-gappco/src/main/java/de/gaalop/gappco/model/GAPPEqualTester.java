package de.gaalop.gappco.model;

import de.gaalop.gapp.variables.GAPPConstant;
import de.gaalop.gapp.variables.GAPPMultivector;
import de.gaalop.gapp.variables.GAPPMultivectorComponent;
import de.gaalop.gapp.variables.GAPPScalarVariable;
import de.gaalop.gapp.variables.GAPPValueHolder;
import de.gaalop.gapp.variables.GAPPVariableVisitor;
import de.gaalop.gapp.variables.GAPPVector;

/**
 *
 * @author steinmetz
 */
public class GAPPEqualTester implements GAPPVariableVisitor {
    
    private static final double EPSILON = 10E-7;
    
    public static boolean equals(GAPPValueHolder o1, GAPPValueHolder o2) {
        if (o1 == null) return o2 == null;
        if (o2 == null) return false;
        if (!o1.getClass().equals(o2.getClass())) return false;
        return (Boolean) o1.accept(new GAPPEqualTester(), o2);
    }

    @Override
    public Object visitConstant(GAPPConstant gappConstant, Object arg) {
        GAPPConstant other = (GAPPConstant) arg;
        return Math.abs(gappConstant.getValue() - other.getValue()) < EPSILON;
    }

    @Override
    public Object visitMultivector(GAPPMultivector gappMultivector, Object arg) {
        GAPPMultivector other = (GAPPMultivector) arg;
        return gappMultivector.getName().equals(other.getName());
    }

    @Override
    public Object visitMultivectorComponent(GAPPMultivectorComponent gappMultivectorComponent, Object arg) {
        GAPPMultivectorComponent other = (GAPPMultivectorComponent) arg;
        return gappMultivectorComponent.getName().equals(other.getName()) && gappMultivectorComponent.getBladeIndex() == other.getBladeIndex();
    }

    @Override
    public Object visitScalarVariable(GAPPScalarVariable gappScalarVariable, Object arg) {
        GAPPScalarVariable other = (GAPPScalarVariable) arg;
        return gappScalarVariable.getName().equals(other.getName());
    }

    @Override
    public Object visitVector(GAPPVector gappVector, Object arg) {
        GAPPVector other = (GAPPVector) arg;
        return gappVector.getName().equals(other.getName());
    }
    
}
