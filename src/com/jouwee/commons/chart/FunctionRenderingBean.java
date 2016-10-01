package com.jouwee.commons.chart;

import com.jouwee.commons.math.ExpressionNode;

/**
 * Function Rendering Bean
 * 
 * @author Jouwee
 */
public class FunctionRenderingBean {
    
    /** Function */
    private final ExpressionNode expression;

    /**
     * Creates a new function rendering bean
     * 
     * @param function 
     */
    public FunctionRenderingBean(ExpressionNode function) {
        this.expression = function;
    }

    /**
     * Returns the function
     * 
     * @return Function
     */
    public ExpressionNode getFunction() {
        return expression;
    }
    
}
