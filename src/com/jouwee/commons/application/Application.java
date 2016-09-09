package com.jouwee.commons.application;

import com.jouwee.commons.mvc.Model;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Application
 * 
 * @author Nícolas Pohren
 * @param <T> Model type of the application
 */
public class Application<T extends Model> extends javafx.application.Application {

    /** Model */
    private T model;
    /** Body */
    private JavaFXView body;
    /** Main panel */
    private BorderPane mainPanel;

    /**
     * Creates a new application
     */
    public Application(T model) {
        super();
        this.model = model;
//        body = new ...;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();
        root.getChildren().add(getMainPanel());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    /**
     * Returns the main panel
     * 
     * @return BorderPane
     */
    public BorderPane getMainPanel() {
        if (mainPanel == null) {
            mainPanel = new BorderPane();
        }
        return mainPanel;
    }

    /**
     * Returns the body
     * 
     * @return JavaFXView
     */
    public JavaFXView getBody() {
        return body;
    }

    /**
     * Sets the body
     * 
     * @param body 
     */
    public void setBody(JavaFXView body) {
        this.body = body;
        getMainPanel().setCenter(body);
    }

    /**
     * Returns the model
     * 
     * @return T
     */
    public T getModel() {
        return model;
    }

    /**
     * Sets the model
     * 
     * @param model 
     */
    public void setModel(T model) {
        this.model = model;
    }

}
