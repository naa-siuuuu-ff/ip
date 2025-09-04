package ozil.task;

/**
* Todotasks that are an extension of tasks
*/
public class TodoTask extends Task {
    /**
     * creates a new Todo task.
     * @param description Description of the task.
     */
    public TodoTask(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}
