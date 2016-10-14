package com.jouwee.commons.mvc;

/**
 * Model
 * 
 * @author Nícolas Pohren
 */
public interface Model {

    /**
     * Adds an event listener to the model
     * 
     * @param <T>
     * @param listener 
     */
    public default <T extends EventObject> void addEventListener(EventListener<T> listener) {
        EventDispatcher.get().addEventListener(this, listener);
    }
        
    /**
     * Removes an event listener to the model
     * 
     * @param <T>
     * @param listener 
     */
    public default <T extends EventObject> void removeEventListener(EventListener<T> listener) {
        EventDispatcher.get().removeEventListener(this, listener);
    }
    
    /**
     * Fires an event
     * 
     * @param <T>
     * @param event
     */
    public default <T extends EventObject> void fireEvent(T event) {
        EventDispatcher.get().fireEvent(this, event);
    }
    
}
