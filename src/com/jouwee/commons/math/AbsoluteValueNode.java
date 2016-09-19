package com.jouwee.commons.math;

/**
 * Absolute value node
 * 
 * @author Jouwee
 */
public class AbsoluteValueNode extends ValueNode {
    
    /** Value */
    private final double value;

    /**
     * Creates a new value node
     * 
     * @param value 
     */
    public AbsoluteValueNode(double value) {
        this.value = value;
    }

    /**
     * Returns the value
     * 
     * @return double
     */
    public double getValue() {
        return value;
    }
    
}
