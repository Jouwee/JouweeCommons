
package com.jouwee.commons.math;

import java.util.Objects;

/**
 * Variable node
 * 
 * @author Nícolas Pohren
 */
public class VariableNode extends ValueNode {

    /** Variable name */
    private final String variable;

    /**
     * Creates a new weighted variable
     * 
     * @param variable
     */
    public VariableNode(String variable) {
        this.variable = variable;
    }

    /**
     * Returns the variable
     * 
     * @return String
     */
    public String getVariable() {
        return variable;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.variable);
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
        final VariableNode other = (VariableNode) obj;
        if (!Objects.equals(this.variable, other.variable)) {
            return false;
        }
        return true;
    }

    @Override
    public String toComputerString() {
        return variable;
    }

    @Override
    public ExpressionNode deepClone() {
        return new VariableNode(variable);
    }

}
