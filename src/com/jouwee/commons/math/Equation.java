package com.jouwee.commons.math;

/**
 * Equation
 * 
 * @author Jouwee
 */
public class Equation {
    
    /** Left function */
    private final Expression leftFunction;
    /** Right function */
    private final Expression rightFunction;
    /** Equation type */
    private final EquationType type;

    /**
     * Creates a new equation
     * 
     * @param leftFunction
     * @param rightFunction
     * @param type 
     */
    public Equation(Expression leftFunction, Expression rightFunction, EquationType type) {
        this.leftFunction = leftFunction;
        this.rightFunction = rightFunction;
        this.type = type;
    }

    /**
     * Returns the left function
     * 
     * @return Function
     */
    public Expression getLeftFunction() {
        return leftFunction;
    }

    /**
     * Returns the right function
     * 
     * @return Function
     */
    public Expression getRightFunction() {
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
    
}
