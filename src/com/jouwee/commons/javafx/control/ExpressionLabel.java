package com.jouwee.commons.javafx.control;

import com.jouwee.commons.javafx.ValueEvent;
import com.jouwee.commons.math.Expression;
import javafx.scene.control.Label;

/**
 * Label for showing expressions
 * 
 * @author Jouwee
 */
public class ExpressionLabel extends Label {

    /** Expression value */
    private Expression value;
       
    /**
     * Creates a new expression field
     */
    public ExpressionLabel() {
        this(null);
    }

    /**
     * Returns a new expression field
     *
     * @param value
     */
    public ExpressionLabel(Expression value) {
        super();
        setValue(value);
        initGui();
    }

    /**
     * Initializes the interface
     */
    private void initGui() {
        getStylesheets().add(ExpressionLabel.class.getResource("ExpressionLabel.css").toExternalForm());
    }

    /**
     * Returns the field value
     *
     * @return Expression
     */
    public Expression getValue() {
        return value;
    }

    /**
     * Sets the field value
     *
     * @param value
     */
    public final void setValue(Expression value) {
        Expression oldValue = this.value;
        this.value = value;
        fireEvent(new ValueEvent(oldValue, value));
        if (value == null) {
            setText("");
        } else {
            setText(value.toString());
        }
    }

}
