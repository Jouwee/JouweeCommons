
package com.jouwee.commons.task;

import java.util.List;
import java.util.Map;

/**
 * Task manager
 * 
 * @author Jouwee
 */
public class TaskManager {

    /** Tasks */
    public final Map<TaskType, List<Task>> tasks;

    /**
     * Creates a new task manager
     */
    public TaskManager() {
        this.tasks = null;
    }
    
}
