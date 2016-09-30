package com.jouwee.commons.chart;

import com.jouwee.commons.math.Expression;

/**
 * Function Rendering Bean
 * 
 * @author Jouwee
 */
public class FunctionRenderingBean {
    
    /** Function */
    private final Expression function;

    /**
     * Creates a new function rendering bean
     * 
     * @param function 
     */
    public FunctionRenderingBean(Expression function) {
        this.function = function;
    }

    /**
     * Returns the function
     * 
     * @return Function
     */
    public Expression getFunction() {
        return function;
    }
    
}
