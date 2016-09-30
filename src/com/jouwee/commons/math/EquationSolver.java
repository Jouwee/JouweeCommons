
package com.jouwee.commons.math;

/**
 * Equation solver
 * 
 * @author Nícolas Pohren
 */
public class EquationSolver {

    /** Equation variable isolator */
    private final EquationVariableIsolator isolator;
    /** Expression solver */
    private final ExpressionSolver expressionSolver;

    /**
     * Equation solver
     */
    public EquationSolver() {
        this.expressionSolver = new ExpressionSolver();
        this.isolator = new EquationVariableIsolator();
    }
    
    /**
     * Returns the variable value
     * 
     * @param variable
     * @param value
     */
    public void putVariable(String variable, double value) {
        expressionSolver.putVariable(variable, value);
    }
    
    /**
     * Solves an equation
     * 
     * @param equation
     * @param variableToSolve
     * @return double
     */
    public double solve(Equation equation, String variableToSolve) {
        if (equation == null) {
            return 0;
        }
        return expressionSolver.solve(isolator.isolate(equation, variableToSolve).getRightFunction());
    }
    
}
