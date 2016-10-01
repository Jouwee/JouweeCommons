package com.jouwee.commons.math;

/**
 * Equation variable isolator
 * 
 * @author Nícolas Pohren
 */
public interface EquationVariableIsolator {
    
    /**
     * Isolates an variable in the equation
     * 
     * @param equation
     * @param variable
     * @return New equation
     */
    public Equation isolate(Equation equation, String variable);
        
}
