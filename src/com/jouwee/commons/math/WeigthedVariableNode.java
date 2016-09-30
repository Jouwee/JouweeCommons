package com.jouwee.commons.math;

/**
 * Weighted variable node
 * 
 * @author Jouwee
 */
public class WeigthedVariableNode extends ValueNode {

    /** Variable name */
    private final String variable;
    /** Weight */
    private final double weight;

    /**
     * Creates a new weighted variable
     * 
     * @param variable
     * @param weight 
     */
    public WeigthedVariableNode(String variable, double weight) {
        this.variable = variable;
        this.weight = weight;
    }

    /**
     * Returns the variable
     * 
     * @return String
     */
    public String getVariable() {
        return variable;
    }

    /**
     * Returns the weight
     * 
     * @return double
     */
    public double getWeight() {
        return weight;
    }

    @Override
    public ExpressionNode deepClone() {
        return new WeigthedVariableNode(variable, weight);
    }
    
}
