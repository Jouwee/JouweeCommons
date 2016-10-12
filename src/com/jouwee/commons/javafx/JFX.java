package com.jouwee.commons.javafx;

import java.util.Arrays;
import javafx.scene.Node;

/**
 * JavaFX helper
 * 
 * @author Jouwee
 */
public class JFX {

    /**
     * Adds style classes on the node
     * 
     * @param node
     * @param classes
     * @return Node itself
     */
    public static final Node styleClass(Node node, String... classes) {
        node.getStyleClass().addAll(Arrays.asList(classes));
        return node;
    }
    
}
