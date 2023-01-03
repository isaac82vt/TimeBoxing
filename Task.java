package timeBoxing;


/**
 * This is a task that is needed to be completed.
 */
public class Task {
    
    private int importance;
    private String description;
    private double timeNeeded; // hours
    
    /**
     * 
     * @param importance
     *      This is the rank, from 1 to 10, of the importance of the task.
     *      1 being not important and 10 being very important.
     *      
     * @param timeNeeded
     *      This is the time, in hours, needed to complete the task
     *      
     * @param description
     *      This is the description of what the task includes
     */
    public Task(String description, int importance, double timeNeeded) {
        
        this.importance = importance;
        this.description = description;
        this.timeNeeded = timeNeeded;
            
    }
    
    /**
     * 
     * @return the importance rating of this task
     */
    public int getImportance() {
        return this.importance;
    }
    
    /**
     * 
     * @return the task description
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * 
     * @return the time needed to complete the task 
     */
    public double getTimeNeeded() {
        return this.timeNeeded;
    }
    
    /**
     * @param obj
     *      This is the object that is being compared to the current task
     */
    @Override
    public boolean equals(Object obj) {
        // check if object is null
        if (obj == null) {
            return false;
        }
        
        // check if object signature is the same
        if (obj == this) {
            return true;
        }
        
        // check if classes are same
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        
        Task taskObj = (Task)obj;
        // check if task objects have same parameters
        if (taskObj.getDescription().equals(this.getDescription()) 
            && taskObj.getImportance() == this.getImportance() 
                && taskObj.getTimeNeeded() == this.getTimeNeeded()) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param otherTask
     *      This is the task that is being compared
     *      
     * @return a double that is the difference between the two items
     */
    public double compareTime(Task otherTask) {
        
        if (otherTask == null) {
            throw new NullPointerException("compareTime method has an "
                + "illegal null argument in the Task class");
        }
        
        return timeNeeded - otherTask.getTimeNeeded();
    }
    
    /**
     * 
     * @param otherTask
     *      This is the task that is being compared
     *      
     * @return an integer of the importance rank difference
     */
    public int compareImportance(Task otherTask) {
        
        if (otherTask == null) {
            throw new NullPointerException("compareImportance method has an "
                + "illegal null argument in the Task class");
        }
        
        return this.importance - otherTask.getImportance();
    }

}
