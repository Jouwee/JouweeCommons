package com.jouwee.commons.neuralnet;

/**
 * Neuron with a fixed value
 * 
 * @author Nícolas Pohren
 */
public class ValueNeuron implements Neuron {

    /** Value of a neuron */
    private double value;
    
    @Override
    public double process(double[] inputs) {
        return value;
    }

    /**
     * Returns the value of this neuron
     * 
     * @return double
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of this neuron
     * 
     * @param value 
     */
    public void setValue(double value) {
        this.value = value;
    }
    
}
