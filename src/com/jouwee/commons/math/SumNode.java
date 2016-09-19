package com.jouwee.commons.math;

/**
 * Sum equation node
 * 
 * @author Jouwee
 */
public class SumNode extends FunctionNode {
    
    /** Left operand */
    private final ValueNode leftOperant;
    /** Right operand */
    private final FunctionNode rightOperant;

    /**
     * Creates a new Sum node
     * 
     * @param leftOperant
     * @param rightOperant 
     */
    public SumNode(ValueNode leftOperant, FunctionNode rightOperant) {
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
