
package com.jouwee.commons.application;

import com.jouwee.commons.javafx.JFXClass;
import com.jouwee.commons.mvc.Model;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX view
 * 
 * @author Nícolas Pohren
 * @param <M> View model type
 */
public abstract class JavaFXView<M extends Model> extends BorderPane implements JFXClass {

    /** Model */
    private M model;
    
    /**
     * Cria uma nova view
     * 
     * @param model
     */
    public JavaFXView(M model) {
        super();
        setModel(model);
    }

    /**
     * Returns the model
     * 
     * @return M
     */
    public M getModel() {
        return model;
    }

    /**
     * Sets the model
     * 
     * @param model 
     */
    public final void setModel(M model) {
        M oldModel = this.model;
        this.model = model;
        fireEvent(new ModelEvent(oldModel, model));
    }
    
}
