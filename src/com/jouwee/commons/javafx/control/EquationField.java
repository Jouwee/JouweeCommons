
package com.jouwee.commons.javafx.control;

import com.jouwee.commons.javafx.ValueEvent;
import com.jouwee.commons.math.Equation;
import com.jouwee.commons.math.EquationParser;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

/**
 * EquationField
 * 
 * @author Jouwee
 */
public class EquationField extends TextField {

    /** Accepted chars */
    private static final Pattern ACCEPTED_CHARS = Pattern.compile("[\\s0-9\\.\\,\\-\\+\\*\\/\\(\\)a-zA-Z=<>]*");
    /** Equation parser */
    private final EquationParser parser;
    /** Equation value */
    private Equation value;
       
    /**
     * Creates a new equation field
     */
    public EquationField() {
        this(null);
    }

    /**
     * Returns a new equation field
     *
     * @param value
     */
    public EquationField(Equation value) {
        super();
        this.parser = new EquationParser();
        setValue(value);
        initGui();
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
        parse();
    }

    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            super.replaceSelection(text);
        }
        parse();
    }
    
    /**
     * Validate the chars
     *
     * @param text
     * @return boolean
     */
    private boolean validate(String text) {
        return ACCEPTED_CHARS.matcher(text).matches();
    }

    /**
     * Parses the equation
     */
    private void parse() {
        try {
            Equation oldValue = value;
            value = parser.parse(getText());
            fireEvent(new ValueEvent(oldValue, value));
            getStyleClass().remove("invalid");
        } catch (Exception e) {
            if (!getStyleClass().contains("invalid")) {
                getStyleClass().add("invalid");
            }
        }
    }

    /**
     * Initializes the interface
     */
    private void initGui() {
        getStylesheets().add(EquationField.class.getResource("EquationField.css").toExternalForm());
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
