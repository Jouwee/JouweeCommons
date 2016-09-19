package com.jouwee.commons.math;

/**
 * Equation
 * 
 * @author Jouwee
 */
public class Equation {
    
    /** Left function */
    private final Function leftFunction;
    /** Right function */
    private final Function rightFunction;
    /** Equation type */
    private final EquationType type;

    /**
     * Creates a new equation
     * 
     * @param leftFunction
     * @param rightFunction
     * @param type 
     */
    public Equation(Function leftFunction, Function rightFunction, EquationType type) {
        this.leftFunction = leftFunction;
        this.rightFunction = rightFunction;
        this.type = type;
    }

    /**
     * Returns the left function
     * 
     * @return Function
     */
    public Function getLeftFunction() {
        return leftFunction;
    }

    /**
     * Returns the right function
     * 
     * @return Function
     */
    public Function getRightFunction() {
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
