package com.jouwee.commons.mvc;

import com.jouwee.commons.reflection.RProperty;
import com.jouwee.commons.reflection.RClass;
import com.jouwee.commons.reflection.ReflectionException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for multicasting events form a models children
 *
 * @author Jouwee
 */
public class EventMulticaster implements EventListener<PropertyEvent> {

    /** Multicasters */
    private static final Map<Integer, EventMulticaster> MULTICASTERS = new HashMap<>();
    /** Model */
    private final WeakReference<Model> model;

    /**
     * Creates a new event multicaster
     *
     * @param model
     */
    public EventMulticaster(Model model) {
        this.model = new WeakReference<>(model);
    }

    /**
     * Returns a multicaster for the model
     *
     * @param model
     * @return EventMulticaster
     */
    public static EventMulticaster get(Model model) {
        Integer key = key(model);
        EventMulticaster multicaster = MULTICASTERS.get(key);
        if (multicaster == null) {
            multicaster = new EventMulticaster(model);
            MULTICASTERS.put(key, multicaster);
        }
        return multicaster;
    }

    /**
     * Returns the key for a model
     *
     * @param model
     * @return Integer
     */
    private static Integer key(Model model) {
        return model.hashCode();
    }

    /**
     * Adds an event listener to the model
     *
     * @param <T>
     * @param listener
     */
    public <T extends EventObject> void addEventListener(EventListener<T> listener) {
        Model theModel = model.get();
        theModel.addEventListener(this);
        theModel.addEventListener(listener);
        try {
            for (RProperty property : RClass.get(theModel).getProperties()) {
                Object value = property.get(theModel);
                if (value instanceof Model) {
                    Model child = (Model) value;
                    child.addChildEventListener(listener);
                }
            }
        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes an event listener to the model
     *
     * @param <T>
     * @param listener
     */
    public <T extends EventObject> void removeEventListener(EventListener<T> listener) {

    }

    @Override
    public void observed(PropertyEvent event) {
        
    }

}
