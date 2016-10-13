package com.jouwee.commons.javafx.control;

import com.jouwee.commons.javafx.ValueEvent;
import com.jouwee.commons.math.Expression;
import com.jouwee.commons.math.ExpressionParser;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

/**
 * Expression text-field
 *
 * @author Jouwee
 */
public class ExpressionField extends TextField {

    /** Accepted chars */
    private static final Pattern ACCEPTED_CHARS = Pattern.compile("[\\s0-9\\.\\,\\-\\+\\*\\/\\(\\)a-zA-Z]*");
    /** Expression parser */
    private final ExpressionParser parser;
    /** Expression value */
    private Expression value;
       
    /**
     * Creates a new expression field
     */
    public ExpressionField() {
        this(null);
    }

    /**
     * Returns a new expression field
     *
     * @param value
     */
    public ExpressionField(Expression value) {
        super();
        this.parser = new ExpressionParser();
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
     * Parses the expression
     */
    private void parse() {
        try {
            Expression oldValue = value;
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
        getStylesheets().add(ExpressionField.class.getResource("ExpressionField.css").toExternalForm());
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
        setText(value.toString());
    }

}
