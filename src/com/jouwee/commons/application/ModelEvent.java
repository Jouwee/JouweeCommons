package com.jouwee.commons.application;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Model changed event
 * 
 * @author Jouwee
 * @param <T>
 */
public class ModelEvent<T> extends Event {
    
    /** Model changed event */
    public static final EventType<ModelEvent> MODEL_CHANGED = new EventType<>("MODEL_CHANGED");
    /** Old value */
    private final T oldModel;
    /** New value */
    private final T newModel;

    /**
     * Creates a new ModelEvent
     * 
     * @param oldModel
     * @param newModel
     */
    public ModelEvent(T oldModel, T newModel) {
        super(MODEL_CHANGED);
        this.oldModel = oldModel;
        this.newModel = newModel;
    }

    /**
     * Returns the old Model
     * 
     * @return Object
     */
    public T getOldModel() {
        return oldModel;
    }

    /**
     * Returns the new Model
     * 
     * @return Object
     */
    public T getNewModel() {
        return newModel;
    }

}
