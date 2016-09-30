package com.jouwee.commons.math;

import java.util.Objects;

/**
 *
 * @author Jouwee
 */
public class DifferenceNode extends ExpressionNode {
    
    /** Left operand */
    private final ValueNode leftOperant;
    /** Right operand */
    private final ExpressionNode rightOperant;

    /**
     * Creates a new difference node
     * 
     * @param leftOperant
     * @param rightOperant 
     */
    public DifferenceNode(ValueNode leftOperant, ExpressionNode rightOperant) {
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
    public ExpressionNode getRightOperant() {
        return rightOperant;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.leftOperant);
        hash = 79 * hash + Objects.hashCode(this.rightOperant);
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
        final DifferenceNode other = (DifferenceNode) obj;
        if (!Objects.equals(this.leftOperant, other.leftOperant)) {
            return false;
        }
        if (!Objects.equals(this.rightOperant, other.rightOperant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toComputerString() {
        return getLeftOperant().toComputerString() + " - " + getRightOperant().toComputerString();
    }

    @Override
    public String toString() {
        return toComputerString();
    }
    
}
