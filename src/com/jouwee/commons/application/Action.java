package com.jouwee.commons.application;

/**
 * Action for a application
 * 
 * @author Nícolas Pohren
 */
public abstract class Action {
    
    /** Name of the action. Also used as a short description */
    private String name;

    /**
     * Creates a new Action
     * 
     * @param name 
     */
    public Action(String name) {
        this.name = name;
    }
    
    /**
     * The action was performed
     * 
     * @param event
     */
    public abstract void performed(ActionEvent event);

    /**
     * Returns the name of the action
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the application
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
