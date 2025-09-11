package ozil.command;

import ozil.exception.ErrorMessages;
import ozil.main.Messages;
import ozil.exception.OzilException;
import ozil.main.TaskList;
import ozil.task.TodoTask;

/**
 * Handles the command ot add a todo task
 */
public class AddTodoTaskCommand extends Command {
    private String userInputDescription;

    public AddTodoTaskCommand(String userInput) throws OzilException {
        String[] sections = userInput.split("\\s+", 2);
        if (sections.length < 2) {
            throw new OzilException(ErrorMessages.taskDescriptionError("todo"));
        }
        this.userInputDescription = sections[1];
    }

    @Override
    public void run(TaskList tasks) {
        TodoTask task = new TodoTask(this.userInputDescription);
        tasks.addTaskToList(task);
        Messages.printTaskAddMessage(task, tasks.getNumberOfTasks());
    }
}
