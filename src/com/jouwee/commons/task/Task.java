package com.jouwee.commons.task;

/**
 * Task
 * 
 * @author Jouwee
 */
public abstract class Task {
    
    /** Name of the task */
    private final String name;

    /**
     * Creates a new task
     * 
     * @param name 
     */
    public Task(String name) {
        this.name = name;
    }
    
    /**
     * Run the task
     */
    public abstract void run();

    /**
     * Returns the name of the task
     * 
     * @return Strng
     */
    public String getName() {
        return name;
    }
    
}
