
package com.jouwee.commons.mvc.mocks;

import com.jouwee.commons.mvc.Model;
import com.jouwee.commons.mvc.PropertyEvent;
import java.util.Objects;

/**
 *
 * @author Nícolas Pohren
 */
public class ModelWithHash implements Model {
    
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.stringProperty);
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
        final ModelWithHash other = (ModelWithHash) obj;
        if (!Objects.equals(this.stringProperty, other.stringProperty)) {
            return false;
        }
        return true;
    }
    
}