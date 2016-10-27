package com.jouwee.commons.javafx.control;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Table pane
 * 
 * @author Jouwee
 */
public class TablePane extends GridPane {

    /**
     * Creates a new table pane
     */
    public TablePane() {
        super();
        initGui();
    }
    
    /**
     * Initializes the interface
     */
    private void initGui() {
        getStylesheets().add(ExpressionLabel.class.getResource("TablePane.css").toExternalForm());
        getStyleClass().add("table-pane");
    }

    @Override
    public void addRow(int rowIndex, Node... children) {
        super.addRow(rowIndex, stylize(rowIndex, children));
    }

    /**
     * Stylize children
     * 
     * @param rowIndex
     * @param children
     * @return 
     */
    private Node[] stylize(int rowIndex, Node[] children) {
        Node[] styilized = new Node[children.length];
        for (int i = 0; i < children.length; i++) {
            Node node = children[i];
            styilized[i] = stylizeNode(rowIndex, node);
        }
        return styilized;
    }

    /**
     * Stylize a node
     * 
     * @param rowIndex
     * @param node
     * @return node;
     */
    private Node stylizeNode(int rowIndex, Node node) {
        BorderPane pane = new BorderPane();
        pane.setCenter(node);
        pane.getStyleClass().add("cell");
        if (rowIndex == 0) {
            pane.getStyleClass().add("header");
        }
        if (rowIndex % 2 == 0) {
            pane.getStyleClass().add("row-even");
        } else {
            pane.getStyleClass().add("row-odd");
        }
        return pane;
    }
    
}
