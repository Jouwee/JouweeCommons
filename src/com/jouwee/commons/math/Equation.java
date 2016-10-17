package com.jouwee.commons.math;

import java.util.Objects;

/**
 * Equation
 * 
 * @author Jouwee
 */
public class Equation extends ExpressionNode {
    
    /** Left function */
    private final ExpressionNode leftFunction;
    /** Right function */
    private final ExpressionNode rightFunction;
    /** Equation type */
    private final EquationType type;

    /**
     * Creates a new equation
     * 
     * @param leftFunction
     * @param rightFunction
     * @param type 
     */
    public Equation(ExpressionNode leftFunction, ExpressionNode rightFunction, EquationType type) {
        this.leftFunction = leftFunction;
        this.rightFunction = rightFunction;
        this.type = type;
    }

    /**
     * Returns the left ExpressionNode
     * 
     * @return ExpressionNode
     */
    public ExpressionNode getLeftFunction() {
        return leftFunction;
    }

    /**
     * Returns the right ExpressionNode
     * 
     * @return ExpressionNode
     */
    public ExpressionNode getRightFunction() {
        return rightFunction;
    }

    /**
     * Returns the equation type
     * 
     * @return EquationType
     */
    public EquationType getType() {
        return type;
    }
    
    @Override
    public String toComputerString() {
        String sLeft = "<null>";
        String sRight = "<null>";
        if (getLeftFunction() != null) {
            sLeft = getLeftFunction().toComputerString();
        }
        if (getRightFunction() != null) {
            sRight = getRightFunction().toComputerString();
        }
        return sLeft + "=" + sRight;
    }

    @Override
    public String toString() {
        return toComputerString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.leftFunction);
        hash = 61 * hash + Objects.hashCode(this.rightFunction);
        hash = 61 * hash + Objects.hashCode(this.type);
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
        final Equation other = (Equation) obj;
        if (!Objects.equals(this.leftFunction, other.leftFunction)) {
            return false;
        }
        if (!Objects.equals(this.rightFunction, other.rightFunction)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public ExpressionNode deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
