package com.jouwee.commons.application;

/**
 * Action event
 * 
 * @author Nícolas Pohren
 */
public class ActionEvent {

    /** Application */
    private final Application application;

    /**
     * Creates a new event
     * 
     * @param application 
     */
    public ActionEvent(Application application) {
        this.application = application;
    }

    /**
     * Returns the application
     * 
     * @return Application
     */
    public Application getApplication() {
        return application;
    }
    
}
