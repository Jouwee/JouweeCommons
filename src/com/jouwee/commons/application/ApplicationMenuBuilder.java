package com.jouwee.commons.application;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Menu builder for an application
 * 
 * @author Nícolas Pohren
 */
public class ApplicationMenuBuilder {
    
    /** Application */
    private final Application application;

    /**
     * Creates a new menu builder
     * @param application 
     */
    public ApplicationMenuBuilder(Application application) {
        this.application = application;
        application.getActionRepository().addListener((Observable observable) -> {
            update();
        });
        build();
    }
    
    /**
     * Updates the application menu
     */
    private void update() {
        application.getMenuBar().getMenus().clear();
        build();
    }

    /**
     * Builds the application menu
     */
    private void build() {
        Menu menu = new Menu("Menu");
        if (application.getMenuBar() == null) {
            return;
        }
        for (Action action : application.getActionRepository().getActions()) {
            menu.getItems().add(buildMenuFromAction(action));
        }
        application.getMenuBar().getMenus().add(menu);
    }
    
    /**
     * Creates a menu from an action
     * 
     * @param action
     * @return MenuItem
     */
    private MenuItem buildMenuFromAction(Action action) {
        MenuItem menu = new MenuItem(action.getName());
        menu.setOnAction((ActionEvent event) -> {
            action.performed(new com.jouwee.commons.application.ActionEvent(application));
        });
        return menu;
    }
    
}
