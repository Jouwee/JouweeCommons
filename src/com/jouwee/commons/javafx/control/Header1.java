package com.jouwee.commons.javafx.control;

import javafx.scene.control.Label;

/**
 * Header level 2
 * 
 * @author Jouwee
 */
public class Header1 extends Label {

    /**
     * Creates a new header
     */
    public Header1() {
        super();
        init();
    }

    /**
     * Creates a new header
     * 
     * @param text
     */
    public Header1(String text) {
        super(text);
        init();
    }

    /**
     * Initializes
     */
    private void init() {
        getStyleClass().add(".h1");
    }
    
}
