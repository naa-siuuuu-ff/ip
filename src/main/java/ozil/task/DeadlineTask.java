package ozil.task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Deadline tasks are an extension of tasks, containing a deadline
*/
public class DeadlineTask extends Task {
    private String deadline;
    private Date deadlineTime;

    /**
     * Creates a new instance of a deadline task.
     * @param description Description of the task.
     * @param deadline Due date for the task.
     */
    public DeadlineTask(String description, String deadline) {
        super(description);
        this.deadline = deadline.trim();
        try{
            this.deadlineTime = parseDateTime(deadline.trim());
        } catch (ParseException e) {
            System.out.println("Task has been stored, but date time operations cannot be carried out");
            System.out.println("Deadline need to be given in the format /by dd-MM-yyyy HHmm");
        }
    }

    @Override
    public String toString() {
        if (deadlineTime != null) {
            DateFormat formatter = new SimpleDateFormat("HHmm");
            if (formatter.format(deadlineTime).equals("0000")) {
                formatter = new SimpleDateFormat("dd-MM-yyyy");
            } else {
                formatter = new SimpleDateFormat("dd-MM-yyyy HHmm");
            }
            return String.format("[D] %s by: %s ", super.toString(), formatter.format(deadlineTime));
        } else {
            return "[D] " + super.toString() + " by: " + this.deadline;
        }
    }

    @Override
    public String convertToStorageFormat() {
        return String.format("D | %d | %s | %s ", this.isDone ? 1 : 0, this.description
                , this.deadline);
    }
}
