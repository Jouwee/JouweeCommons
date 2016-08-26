
package com.jouwee.commons.neuralnet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Layer of the network
 * 
 * @author Nícolas Pohren
 * @param <T>
 */
public class Layer<T extends Neuron> {

    /** Neurons */
    private final List<T> neurons;

    /**
     * Creates a new layer
     * 
     * @param neurons 
     */
    public Layer(T... neurons) {
        this();
        this.neurons.addAll(Arrays.asList(neurons));
    }

    /**
     * Creates a new layer
     * 
     * @param neurons 
     */
    public Layer(Collection<T> neurons) {
        this();
        this.neurons.addAll(neurons);
    }

    /**
     * Creates a new layer
     */
    public Layer() {
        this.neurons = new ArrayList<>();
    }
    
    /**
     * Returns a neuron
     * 
     * @param index
     * @return Neuron
     */
    public T get(int index) {
        return neurons.get(index);
    }

    /**
     * Returns the neurons
     * 
     * @return {@code List<T>}
     */
    public List<T> getNeurons() {
        return new ArrayList<>(neurons);
    }
    
}
