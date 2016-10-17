package com.jouwee.commons.math;

import java.util.Objects;

/**
 * Sum equation node
 * 
 * @author Jouwee
 */
public class SumNode extends ExpressionNode {
    
    /** Left operand */
    private final ExpressionNode leftOperant;
    /** Right operand */
    private final ExpressionNode rightOperant;

    /**
     * Creates a new Sum node
     * 
     * @param leftOperant
     * @param rightOperant 
     */
    public SumNode(ExpressionNode leftOperant, ExpressionNode rightOperant) {
        this.leftOperant = leftOperant;
        this.rightOperant = rightOperant;
    }

    /**
     * Returns the left operand
     * 
     * @return ExpressionNode
     */
    public ExpressionNode getLeftOperant() {
        return leftOperant;
    }

    /**
     * Returns the right operand
     * 
     * @return FunctionNode
     */
    public ExpressionNode getRightOperant() {
        return rightOperant;
    }

    @Override
    public String toComputerString() {
        return getLeftOperant().toComputerString() + " + " + getRightOperant().toComputerString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.leftOperant);
        hash = 71 * hash + Objects.hashCode(this.rightOperant);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SumNode other = (SumNode) obj;
        if (!Objects.equals(this.leftOperant, other.leftOperant)) {
            return false;
        }
        if (!Objects.equals(this.rightOperant, other.rightOperant)) {
            return false;
        }
        return true;
    }

    @Override
    public ExpressionNode deepClone() {
        return new SumNode(leftOperant, rightOperant);
    }
    
}
