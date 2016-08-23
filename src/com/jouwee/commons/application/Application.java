package com.jouwee.commons.application;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Application
 * 
 * @author Nícolas Pohren
 */
public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();
        root.getChildren().add(buildMainPanel());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    /**
     * Builds the main panel
     * 
     * @return Node
     */
    private Node buildMainPanel() {
        return new Button("dqw");
    }
    
}
