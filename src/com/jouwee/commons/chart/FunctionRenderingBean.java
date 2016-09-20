package com.jouwee.commons.chart;

import com.jouwee.commons.math.Function;

/**
 * Function Rendering Bean
 * 
 * @author Jouwee
 */
public class FunctionRenderingBean {
    
    /** Function */
    private final Function function;

    /**
     * Creates a new function rendering bean
     * 
     * @param function 
     */
    public FunctionRenderingBean(Function function) {
        this.function = function;
    }

    /**
     * Returns the function
     * 
     * @return Function
     */
    public Function getFunction() {
        return function;
    }
    
}
