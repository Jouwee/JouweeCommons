package com.jouwee.commons.javafx;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Value changed event
 * 
 * @author Jouwee
 * @param <T>
 */
public class ValueEvent<T> extends Event {

    /** Event type */
    public static final EventType<ValueEvent> TYPE = new EventType<ValueEvent>("CHANGED");
    /** Old value */
    private final T oldValue;
    /** New value */
    private final T newValue;

    /**
     * Creates a new Value Event
     * @param oldValue
     * @param newValue
     */
    public ValueEvent(T oldValue, T newValue) {
        super(TYPE);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Returns the old value
     * 
     * @return Object
     */
    public T getOldValue() {
        return oldValue;
    }

    /**
     * Returns the new value
     * 
     * @return Object
     */
    public T getNewValue() {
        return newValue;
    }
    
}
