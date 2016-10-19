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
     * Returns the coeficient for a variable
     * 
     * @param variableName
     * @return 
     */
    public double getVariableCoeficient(String variableName) {
        Double coeficient = getVariableCoeficient(this, variableName);
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
    
    /**
     * Clones this node
     * 
     * @return ExpressionNode
     */
    public abstract ExpressionNode deepClone();
    
}
