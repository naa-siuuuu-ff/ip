package ozil.command;

import ozil.main.TaskList;

/**
 * The command to list all current tasks.
 */
public class ListTasksCommand extends Command {
    private String userInput;

    public ListTasksCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String run(TaskList tasks) {
        return tasks.printlist();
    }
}
