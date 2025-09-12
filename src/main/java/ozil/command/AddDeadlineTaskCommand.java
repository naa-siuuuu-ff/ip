package ozil.command;

import ozil.exception.ErrorMessages;
import ozil.exception.OzilException;
import ozil.main.Messages;
import ozil.main.TaskList;
import ozil.task.DeadlineTask;


/**
 * Runs the deadline tast creation command
 */
public class AddDeadlineTaskCommand extends Command {
    private String description;
    private String deadline;

    /**
     * Constructor for Deadline command.
     * @param userInput String input by user.
     * @throws OzilException
     */
    public AddDeadlineTaskCommand(String userInput) throws OzilException {
        String[] sections = userInput.split("\\s+", 2);

        if (sections[1].trim().startsWith("/by")) {
            throw new OzilException(ErrorMessages.taskDescriptionError("deadline"));
        }

        String[] parts = sections[1].trim().split("/by", 2);
        if (parts.length < 2) {
            throw new OzilException(ErrorMessages.deadlineTaskTimeError());
        }

        this.description = parts[0].trim();
        this.deadline = parts[1].trim();

    }

    @Override
    public void run(TaskList tasks) {
        DeadlineTask task = new DeadlineTask(this.description, this.deadline);
        tasks.addTaskToList(task);
        Messages.printTaskAddMessage(task, tasks.getNumberOfTasks());
    }

}
