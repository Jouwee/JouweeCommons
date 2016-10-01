package com.jouwee.commons.math;

/**
 * Equation variable isolator factory
 * 
 * @author Nícolas Pohren
 */
public class EquationVariableIsolatorFactory {

    /**
     * Create the variable isolator
     * 
     * @return EquationVariableIsolator
     */
    public static EquationVariableIsolator create() {
        return new MaximaEquationVariableIsolator();
    }
    
}
