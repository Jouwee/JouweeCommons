package com.jouwee.commons.application;

import com.jouwee.commons.mvc.Model;
import com.sun.javafx.event.EventDispatchChainImpl;
import com.sun.javafx.scene.NodeEventDispatcher;
import java.io.InputStream;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Application
 *
 * @author Nícolas Pohren
 * @param <T> Model type of the application
 */
public abstract class Application<T extends Model> extends javafx.application.Application {
    
    /** Action repository */
    private final ActionRepository actionRepository;
    /** Event dispatcher */
    private NodeEventDispatcher internalEventDispatcher;
    /** Model */
    private T model;
    /** Body */
    private JavaFXView body;
    /** Main panel */
    private BorderPane mainPanel;
    /** Menu bar */
    private MenuBar menuBar;
    /** Stage */
    private Stage stage;
    /** Image */
    private Image image;

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
        stage = primaryStage;
        stage.setTitle("Hello World!");
        BorderPane root = new BorderPane();
        root.setCenter(getMainPanel());
        stage.setScene(buildScene(root));
        stage.setMaximized(true);
        stage.getIcons().add(image);
        stage.show();
        this.internalEventDispatcher = new NodeEventDispatcher(stage);
        onStart();
    }
    
    /**
     * Starts the application
     */
    public abstract void onStart();

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
     * Registers an event handler to this node. The handler is called when the
     * node receives an {@code Event} of the specified type during the bubbling
     * phase of event delivery.
     *
     * @param <T> the specific event class of the handler
     * @param eventType the type of the events to receive by the handler
     * @param eventHandler the handler to register
     * @throws NullPointerException if the event type or handler is null
     */
    public final <T extends Event> void addEventHandler(final EventType<T> eventType, final EventHandler<? super T> eventHandler) {
        internalEventDispatcher.getEventHandlerManager().addEventHandler(eventType, eventHandler);
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
        T oldModel = this.model;
        this.model = model;
        internalEventDispatcher.dispatchEvent(new ModelEvent<>(oldModel, model), new EventDispatchChainImpl());
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
    
    /**
     * Sets the application icon
     * 
     * @param icon 
     */
    public void setIcon(InputStream icon) {
        image = new Image(icon);
        if (stage != null) {
            stage.getIcons().add(image);
        }
    }

}
