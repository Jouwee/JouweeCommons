package com.jouwee.commons.application;

import com.jouwee.commons.mvc.Model;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Application
 *
 * @author Nícolas Pohren
 * @param <T> Model type of the application
 */
public class Application<T extends Model> extends javafx.application.Application {

    /** Action repository */
    private final ActionRepository actionRepository;
    /** Model */
    private T model;
    /** Body */
    private JavaFXView body;
    /** Main panel */
    private BorderPane mainPanel;
    /** Menu bar */
    private MenuBar menuBar;

    /**
     * Creates a new application
     *
     * @param model
     */
    public Application(T model) {
        super();
        this.model = model;
        this.actionRepository = new ActionRepository();
        new ApplicationMenuBuilder(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        BorderPane root = new BorderPane();
        root.setCenter(getMainPanel());
        primaryStage.setScene(buildScene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    /**
     * Builds the scene
     *
     * @param root
     * @return Scene
     */
    private static Scene buildScene(BorderPane root) {
        Scene scene = new Scene(root, 300, 250);
        String css = Application.class.getResource("default.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);
        return scene;
    }

    /**
     * Returns the main panel
     *
     * @return BorderPane
     */
    public BorderPane getMainPanel() {
        if (mainPanel == null) {
            mainPanel = new BorderPane();
            mainPanel.setTop(buildMenuBar());
        }
        return mainPanel;
    }

    /**
     * Builds a menu bar
     *
     * @return Node
     */
    private Node buildMenuBar() {
        menuBar = new MenuBar();
        return menuBar;
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

    /**
     * Returns the application ActionRepository
     *
     * @return ActionRepository
     */
    public ActionRepository getActionRepository() {
        return actionRepository;
    }

    /**
     * Returns the menu bar
     *
     * @return MenuBar
     */
    public MenuBar getMenuBar() {
        return menuBar;
    }

}
