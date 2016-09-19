package com.jouwee.commons.math;

/**
 *
 * @author Jouwee
 */
public class DifferenceNode extends FunctionNode {
    
    /** Left operand */
    private final ValueNode leftOperant;
    /** Right operand */
    private final FunctionNode rightOperant;

    /**
     * Creates a new difference node
     * 
     * @param leftOperant
     * @param rightOperant 
     */
    public DifferenceNode(ValueNode leftOperant, FunctionNode rightOperant) {
        this.leftOperant = leftOperant;
        this.rightOperant = rightOperant;
    }

    /**
     * Returns the left operand
     * 
     * @return ValueNode
     */
    public ValueNode getLeftOperant() {
        return leftOperant;
    }

    /**
     * Returns the right operand
     * 
     * @return FunctionNode
     */
    public FunctionNode getRightOperant() {
        return rightOperant;
    }
    
}
