package com.jouwee.commons.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Expression solver
 * 
 * @author Nícolas Pohren
 */
public class ExpressionSolver {
    
    /** Variables */
    private final Map<String, Double> variables;
    /** Node solvers */
    private final Map<Class, NodeSolver> nodeSolvers;

    /**
     * Creates a new function solver
     */
    public ExpressionSolver() {
        this.variables = new HashMap<>();
        this.nodeSolvers = new HashMap<>();
        initSolvers();
    }

    /**
     * Init solvers
     */
    private void initSolvers() {
        nodeSolvers.put(AbsoluteValueNode.class, (NodeSolver<AbsoluteValueNode>) (AbsoluteValueNode node) -> {
            return node.getValue();
        });
        nodeSolvers.put(VariableNode.class, (NodeSolver<VariableNode>) (VariableNode node) -> {
            return getVariable(node.getVariable());
        });
        nodeSolvers.put(SumNode.class, (NodeSolver<SumNode>) (SumNode node) -> {
            return solve(node.getLeftOperant()) + solve(node.getRightOperant());
        });
        nodeSolvers.put(DifferenceNode.class, (NodeSolver<DifferenceNode>) (DifferenceNode node) -> {
            return solve(node.getLeftOperant()) - solve(node.getRightOperant());
        });
    }
    
    /**
     * Returns the variable value
     * 
     * @param variable
     * @return double
     */
    public double getVariable(String variable) {
        if (!variables.containsKey(variable)) {
            return 0;
        }
        return variables.get(variable);
    }
    
    /**
     * Sets the variable value
     * 
     * @param variable
     * @param value
     */
    public void putVariable(String variable, double value) {
        variables.put(variable, value);
    }
    
    /**
     * Solve a function
     * 
     * @param function
     * @return double
     */
    public double solve(Expression function) {
        if (function == null) {
            return 0;
        }
        return solve(function.getNode());
    }
        
    /**
     * Solve a function
     * 
     * @param node
     * @return double
     */
    public double solve(ExpressionNode node) {
        return nodeSolvers.get(node.getClass()).solve(node);
    }

    /**
     * NodeSolver
     * 
     * @param T
     */
    private interface NodeSolver<T extends ExpressionNode> {
        
        /**
         * Solves the node
         * 
         * @param node 
         * @return double
         */
        public double solve(T node);
        
    }
    
}
