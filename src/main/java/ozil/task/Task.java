package ozil.task;

/**
* Task class for basic tasks that can be added by users
* @param description Description of the task
* @param isDone boolean to check whether the task has been done or not
*/
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a new task.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as undone.
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String convertToStorageFormat() {
        return String.format("X | %d | %s", this.isDone ? 1 : 0, this.description);
    }

}
