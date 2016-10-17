package com.jouwee.commons.javafx.control;

import com.jouwee.commons.javafx.ValueEvent;
import com.jouwee.commons.math.Equation;
import javafx.scene.control.Label;

/**
 * Label for showing equations
 * 
 * @author Jouwee
 */
public class EquationLabel extends Label {

    /** Equation value */
    private Equation value;
       
    /**
     * Creates a new equation field
     */
    public EquationLabel() {
        this(null);
    }

    /**
     * Returns a new equation field
     *
     * @param value
     */
    public EquationLabel(Equation value) {
        super();
        setValue(value);
        initGui();
    }

    /**
     * Initializes the interface
     */
    private void initGui() {
        getStylesheets().add(EquationLabel.class.getResource("EquationLabel.css").toExternalForm());
    }

    /**
     * Returns the field value
     *
     * @return Equation
     */
    public Equation getValue() {
        return value;
    }

    /**
     * Sets the field value
     *
     * @param value
     */
    public final void setValue(Equation value) {
        Equation oldValue = this.value;
        this.value = value;
        fireEvent(new ValueEvent(oldValue, value));
        if (value == null) {
            setText("");
        } else {
            setText(value.toString());
        }
    }

}
