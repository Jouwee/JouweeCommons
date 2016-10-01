
package com.jouwee.commons.math;

import java.util.Objects;

/**
 * Multiplication node
 * 
 * @author Nícolas Pohren
 */
public class MultiplicationNode extends ExpressionNode {

    /** Left operand */
    private final ValueNode leftOperant;
    /** Right operand */
    private final ExpressionNode rightOperant;

    /**
     * Creates a new multiplication node
     * 
     * @param leftOperant
     * @param rightOperant 
     */
    public MultiplicationNode(ValueNode leftOperant, ExpressionNode rightOperant) {
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
    public String toComputerString() {
        return getLeftOperant().toComputerString() + " * " + getRightOperant().toComputerString();
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
        final MultiplicationNode other = (MultiplicationNode) obj;
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
        return new MultiplicationNode(leftOperant, rightOperant);
    }

}
