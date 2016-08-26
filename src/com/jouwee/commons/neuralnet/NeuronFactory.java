package com.jouwee.commons.neuralnet;

/**
 * Factory for common neurons
 *
 * @author Nícolas Pohren
 */
public class NeuronFactory {

    /**
     * Sum all the inputs
     * 
     * @return Neuron
     */
    public static Neuron createSum() {
        return (double[] inputs) -> {
            double sum = 0;
            for (double input : inputs) {
                sum += input;
            }
            return sum;
        };
    }

}
