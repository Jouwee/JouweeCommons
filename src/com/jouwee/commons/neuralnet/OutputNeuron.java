
package com.jouwee.commons.neuralnet;

/**
 *
 * @author Nícolas Pohren
 */
public class OutputNeuron implements Neuron {

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
