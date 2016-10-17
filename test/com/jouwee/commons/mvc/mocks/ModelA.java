package com.jouwee.commons.mvc.mocks;

import com.jouwee.commons.mvc.Model;
import com.jouwee.commons.mvc.PropertyEvent;

/**
 * Model A
 * 
 * @author Jouwee
 */
public class ModelA implements Model {
    
    /** String property */
    private String stringProperty;

    public String getStringProperty() {
        return stringProperty;
    }

    public void setStringProperty(String stringProperty) {
        String oldValue = this.stringProperty;
        this.stringProperty = stringProperty;
        fireEvent(new PropertyEvent("stringProperty", oldValue, stringProperty));
    }
    
}
