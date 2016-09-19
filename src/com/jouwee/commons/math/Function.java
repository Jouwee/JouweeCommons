package com.jouwee.commons.math;

/**
 * Function
 * 
 * @author Jouwee
 */
public class Function {
    
    /** Function root node */
    private final FunctionNode node;

    /**
     * Function
     * 
     * @param node
     */
    public Function(FunctionNode node) {
        this.node = node;
    }

    /**
     * Returns the node
     * 
     * @return FunctionNode
     */
    public FunctionNode getNode() {
        return node;
    }
    
}
