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
    
    /**
     * Returns the coeficient for a variable
     * 
     * @param variableName
     * @return 
     */
    public double getVariableCoeficient(String variableName) {
        Double coeficient = getVariableCoeficient(node, variableName);
        if (coeficient != null) {
            return coeficient;
        }
        return 0;
    }

    /**
     * Returns the coeficient based on a node
     * 
     * @param node
     * @param variableName
     * @return 
     */
    private Double getVariableCoeficient(ExpressionNode node, String variableName) {
        if (node instanceof MultiplicationNode) {
            MultiplicationNode mNode = (MultiplicationNode) node;
            if (mNode.getRightOperant() instanceof VariableNode) {
                VariableNode vNode = (VariableNode) mNode.getRightOperant();
                if (vNode.getVariable().equals(variableName)) {
                    if (mNode.getLeftOperant() instanceof AbsoluteValueNode) {
                        AbsoluteValueNode avNode = (AbsoluteValueNode) mNode.getLeftOperant();
                        return avNode.getValue();
                    }
                }
            }
        }
        if (node instanceof MultiplicationNode) {
            MultiplicationNode mNode = (MultiplicationNode) node;
            Double coeficient = getVariableCoeficient(mNode.getLeftOperant(), variableName);
            if (coeficient != null) {
                return coeficient;
            }
            coeficient = getVariableCoeficient(mNode.getRightOperant(), variableName);
            if (coeficient != null) {
                return coeficient;
            }
        }
        if (node instanceof SumNode) {
            SumNode sNode = (SumNode) node;
            Double coeficient = getVariableCoeficient(sNode.getLeftOperant(), variableName);
            if (coeficient != null) {
                return coeficient;
            }
            coeficient = getVariableCoeficient(sNode.getRightOperant(), variableName);
            if (coeficient != null) {
                return coeficient;
            }
        }
        if (node instanceof DifferenceNode) {
            DifferenceNode dNode = (DifferenceNode) node;
            Double coeficient = getVariableCoeficient(dNode.getLeftOperant(), variableName);
            if (coeficient != null) {
                return coeficient;
            }
            coeficient = getVariableCoeficient(dNode.getRightOperant(), variableName);
            if (coeficient != null) {
                return coeficient;
            }
        }
        return null;
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
