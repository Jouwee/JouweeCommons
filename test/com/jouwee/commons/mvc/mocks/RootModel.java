package com.jouwee.commons.mvc.mocks;

import com.jouwee.commons.mvc.Model;
import com.jouwee.commons.mvc.PropertyEvent;

/**
 *
 * @author Nicolas
 */
public class RootModel implements Model {
    
    private ModelA modelA;

    public RootModel() {
        modelA = new ModelA();
    }
    
    public ModelA getModelA() {
        return modelA;
    }

    public void setModelA(ModelA modelA) {
        ModelA oldValue = this.modelA;
        this.modelA = modelA;
        fireEvent(new PropertyEvent("modelA", oldValue, modelA));
    }
    
}
