package com.jouwee.commons.neuralnet;

/**
 * Neuron
 * 
 * @author Nícolas Pohren
 */
public interface Neuron {
    
    /**
     * Process the neuron
     * 
     * @param inputs
     * @return double
     */
    public double process(double[] inputs);
    
}
