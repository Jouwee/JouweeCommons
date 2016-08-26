package com.jouwee.commons.neuralnet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Neural network
 * 
 * @author Nícolas Pohren
 */
public class NeuralNetwork {

    /** Layers */
    private final List<Layer> layers;
    /** Weights */
    private Map<ConnectionKey, Double> weights;

    /**
     * Creates a new neural network
     */
    public NeuralNetwork() {
        this.layers = new ArrayList<>();
        weights = new HashMap<>();
    }
    
    /**
     * Process the neural network
     * 
     * @return double[]
     */
    public double[] process() {
        double[] lastLayerResult = null;
        for (int i = 0; i < layers.size(); i++) {
            if (i == 0) {
                lastLayerResult = processInputLayer();
            } else {
                lastLayerResult = processLayer(i, layers.get(i), lastLayerResult);
            }
        }
        return lastLayerResult;
    }

    /**    
     * Process the input layer
     * 
     * @return double[]
     * 
     */
    private double[] processInputLayer() {
        List<ValueNeuron> neurons = getInputLayer().getNeurons();
        double[] ret = new double[neurons.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = neurons.get(i).process(null);
        }
        return ret;
    }

    /**
     * Process a layer
     * 
     * @param layerIndex
     * @param layer
     * @param lastLayerResult
     * @return double[]
     */
    private double[] processLayer(int layerIndex, Layer<Neuron> layer, double[] lastLayerResult) {
        double[] result = new double[layer.getNeurons().size()];
        for (int i = 0; i < layer.getNeurons().size(); i++) {
            Neuron neuron = layer.getNeurons().get(i);
            result[i] = neuron.process(applyWeights(lastLayerResult, layerIndex, i));
        }
        return result;
    }
    
    /**
     * Apply the weights
     * 
     * @param input
     * @param layerIndex
     * @param neuronIndex
     * @return double[]
     */
    private double[] applyWeights(double[] input, int layerIndex, int neuronIndex) {
        double[] ret = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            ret[i] = input[i] * getConnectionWeight(layerIndex-1, i, layerIndex, neuronIndex);
        }
        return ret;
    }
    
    /**
     * Adds a layer
     * 
     * @param neurons 
     */
    public void addLayer(Neuron... neurons) {
        layers.add(new Layer(neurons));
    }
    
    /**
     * Adds a layer
     * 
     * @param neurons 
     */
    public void addLayer(Collection<Neuron> neurons) {
        layers.add(new Layer(neurons));
    }
    
    /**
     * Returns the input layer
     * 
     * @return Layer
     */
    public Layer<ValueNeuron> getInputLayer() {
        return layers.get(0);
    }
    
    /**
     * Returns the input layer
     * 
     * @return Layer
     */
    public Layer<Neuron> getOutputLayer() {
        return layers.get(0);
    }

    /**
     * Returns the layers
     * 
     * @return {@List<Layer>}
     */
    public List<Layer> getLayers() {
        return new ArrayList<>(layers);
    }
    
    /**
     * Returns the weight of a connection
     * 
     * @param layerIndex1
     * @param neuronIndex1
     * @param layerIndex2
     * @param neuronIndex2
     * @return double
     */
    public double getConnectionWeight(int layerIndex1, int neuronIndex1, int layerIndex2, int neuronIndex2) {
        ConnectionKey key = new ConnectionKey(layerIndex1, neuronIndex1, layerIndex2, neuronIndex2);
        if (!weights.containsKey(key)) {
            return 0.5;
        }
        return weights.get(key);
    }
    
    /**
     * Puts a weight
     * 
     * @param layerIndex1
     * @param neuronIndex1
     * @param layerIndex2
     * @param neuronIndex2
     * @param weight 
     */
    public void putConnectionWeight(int layerIndex1, int neuronIndex1, int layerIndex2, int neuronIndex2, double weight) {
        weights.put(new ConnectionKey(layerIndex1, neuronIndex1, layerIndex2, neuronIndex2), weight);
    }

}
