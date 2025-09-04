package ozil.task;

/**
* Deadline tasks are an extension of tasks, containing a deadline
* @param deadline Deadline of the task
*/
public class DeadlineTask extends Task {
    private String deadline;

    /**
     * Creates a new instance of a deadline task.
     * @param description Description of the task.
     * @param deadline Due date for the task.
     */
    public DeadlineTask(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + deadline + ")";
    }
}
