
package com.jouwee.commons.task;

/**
 * Type of task
 * 
 * @author Jouwee
 */
public class TaskType {

    /** Key for the task */
    private final String key;
    /** Strategy for multiple tasks */
    private final MultipleTasksBehavior multipleTasksStrategy;

    /**
     * Creates a new type of task
     * 
     * @param key
     * @param multipleTasksStrategy 
     */
    public TaskType(String key, MultipleTasksBehavior multipleTasksStrategy) {
        this.key = key;
        this.multipleTasksStrategy = multipleTasksStrategy;
    }

    /**
     * Returns the task key
     * 
     * @return String
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the behavior for multiple tasks
     * 
     * @return MultipleTasksBehavior
     */
    public MultipleTasksBehavior getMultipleTasksStrategy() {
        return multipleTasksStrategy;
    }
    
}
