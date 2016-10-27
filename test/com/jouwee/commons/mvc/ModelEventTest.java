package com.jouwee.commons.mvc;

import com.jouwee.commons.mvc.mocks.ModelA;
import com.jouwee.commons.mvc.mocks.ModelWithHash;
import com.jouwee.commons.mvc.mocks.RootModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests involving model events
 * 
 * @author Jouwee
 */
public class ModelEventTest {
    
    /** Test event listener */
    private TestEventListener listener;
    
    /**
     * Setup
     */
    @Before
    public void setup() {
        listener = new TestEventListener();
    }
    
    @Test
    public void testSimpleEvent() {
        ModelA model = new ModelA();
        model.addEventListener(listener);
        model.setStringProperty("New string");
        listener.assertNext("stringProperty", null, "New string");
    }
    
    @Test
    public void testSimpleEventWithHash() {
        ModelWithHash model = new ModelWithHash();
        model.addEventListener(listener);
        model.setStringProperty("New string");
        model.setStringProperty("Another one");
        listener.assertNext("stringProperty", null, "New string");
        listener.assertNext("stringProperty", "New string", "Another one");
    }
    
    @Test
    public void testSimpleChildEvent() {
        RootModel model = new RootModel();
        model.addChildEventListener(listener);
        model.getModelA().setStringProperty("New string");
        listener.assertNext("stringProperty", null, "New string");
    }
    
    private class TestEventListener implements EventListener<PropertyEvent> {

        private final List<PropertyEvent> events;
        private Iterator<PropertyEvent> iterator;

        public TestEventListener() {
            this.events = new ArrayList<>();
        }
        
        @Override
        public void observed(PropertyEvent event) {
            events.add(event);
        }

        private void assertNext(String stringProperty, Object oldValue, Object newValue) {
            assertTrue(getIterator().hasNext());
            PropertyEvent event = getIterator().next();
            assertEquals(stringProperty, event.getPropertyName());
            assertEquals(oldValue, event.getOldValue());
            assertEquals(newValue, event.getNewValue());
        }

        public Iterator<PropertyEvent> getIterator() {
            if (iterator == null) {
                iterator = events.iterator();
            }
            return iterator;
        }
        
    }
    
}
