package com.jouwee.commons.math;

/**
 * Expression node
 * 
 * @author Jouwee
 */
public abstract class ExpressionNode {
 
    /**
     * Writes this node as a computer String
     * 
     * @return String
     */
    public String toComputerString() {
        return "<undefined>";
    }
    
    @Override
    public String toString() {
        return toComputerString();
    }
    
    /**
     * Clones this node
     * 
     * @return ExpressionNode
     */
    public abstract ExpressionNode deepClone();
    
}
