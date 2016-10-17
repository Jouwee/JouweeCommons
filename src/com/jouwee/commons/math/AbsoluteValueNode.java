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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbsoluteValueNode other = (AbsoluteValueNode) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toComputerString() {
        if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
            return String.valueOf((long)value);
        } else {
            return String.valueOf((double)value).replace(".", ",");
        }
    }

    @Override
    public ExpressionNode deepClone() {
        return new AbsoluteValueNode(value);
    }
    
}
