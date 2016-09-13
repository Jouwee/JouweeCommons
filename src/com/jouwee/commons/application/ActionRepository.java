package com.jouwee.commons.application;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Action repository for the application
 *
 * @author Nícolas Pohren
 */
public class ActionRepository {

    /**
     * Actions
     */
    private final ObservableList<Action> actions;

    /**
     * Creates a new Repository
     */
    public ActionRepository() {
        this.actions = FXCollections.observableArrayList();
    }

    /**
     * Adds a new action
     *
     * @param action
     */
    public void add(Action action) {
        actions.add(action);
    }
    
    /**
     * Adds a invalidation listener on the actions
     * 
     * @param invalidationListener 
     */
    public void addListener(InvalidationListener invalidationListener) {
        actions.addListener(invalidationListener);
    }

    /**
     * Returns the actions
     * 
     * @return {@code List<Action>}
     */
    public List<Action> getActions() {
        return new ArrayList<>(actions);
    }

}
