package com.jouwee.commons.math;

/**
 * Parsing exception
 * 
 * @author Jouwee
 */
public class ParsingException extends Exception {

    /**
     * Creates a new parsing exception
     * 
     * @param message
     * @param cause
     */
    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new parsing exception
     * 
     * @param cause
     */
    public ParsingException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new parsing exception
     * 
     * @param message
     */
    public ParsingException(String message) {
        super(message);
    }

    /**
     * Creates a new parsing exception
     */
    public ParsingException() {
        super();
    }

}
