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
     * @param nodes
     * @param classes
     * @return Node itself
     */
    public static final Node[] styleClass(Node[] nodes, String... classes) {
        for (Node node : nodes) {
            styleClass(node, classes);
        }
        return nodes;
    }

    /**
     * Adds style classes on the node
     * 
     * @param <T>
     * @param node
     * @param classes
     * @return Node itself
     */
    public static final <T extends Node> T styleClass(T node, String... classes) {
        node.getStyleClass().addAll(Arrays.asList(classes));
        return node;
    }
    
}
