package com.jouwee.commons.math;

import java.util.Objects;

/**
 * Expression
 * 
 * @author Jouwee
 */
public class Expression {
    
    /** Expression root node */
    private final ExpressionNode node;

    /**
     * Expression
     */
    public Expression() {
        this(new AbsoluteValueNode(0));
    }

    /**
     * Expression
     * 
     * @param node
     */
    public Expression(ExpressionNode node) {
        this.node = node;
    }

    /**
     * Returns the node
     * 
     * @return ExpressionNode
     */
    public ExpressionNode getNode() {
        return node;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.node);
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
        final Expression other = (Expression) obj;
        if (!Objects.equals(this.node, other.node)) {
            return false;
        }
        return true;
    }
    
    /**
     * Returns a computer representation of the expression
     * 
     * @return String
     */
    public String toComputerString() {
        return getNode().toComputerString();
    }

    @Override
    public String toString() {
        return toComputerString();
    }
    
}
