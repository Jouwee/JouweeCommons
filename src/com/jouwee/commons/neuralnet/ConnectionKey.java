
package com.jouwee.commons.neuralnet;

/**
 * Connection between two neurons
 * 
 * @author Nícolas Pohren
 */
public class ConnectionKey {

    /** Layer index 1 */
    public final int layerIndex1;
    /** Neuron index 1 */
    public final int neuronIndex1;
    /** Layer index 2 */
    public final int layerIndex2;
    /** Neuron index 2 */
    public final int neuronIndex2;

    /**
     * Creates a new connection key
     * 
     * @param layerIndex1
     * @param neuronIndex1
     * @param layerIndex2
     * @param neuronIndex2 
     */
    public ConnectionKey(int layerIndex1, int neuronIndex1, int layerIndex2, int neuronIndex2) {
        this.layerIndex1 = layerIndex1;
        this.neuronIndex1 = neuronIndex1;
        this.layerIndex2 = layerIndex2;
        this.neuronIndex2 = neuronIndex2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.layerIndex1;
        hash = 97 * hash + this.neuronIndex1;
        hash = 97 * hash + this.layerIndex2;
        hash = 97 * hash + this.neuronIndex2;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConnectionKey other = (ConnectionKey) obj;
        if (this.layerIndex1 != other.layerIndex1) {
            return false;
        }
        if (this.neuronIndex1 != other.neuronIndex1) {
            return false;
        }
        if (this.layerIndex2 != other.layerIndex2) {
            return false;
        }
        return this.neuronIndex2 == other.neuronIndex2;
    }
    
}
