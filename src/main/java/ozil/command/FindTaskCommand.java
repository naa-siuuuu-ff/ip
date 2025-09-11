package ozil.command;

import ozil.exception.OzilException;
import ozil.main.TaskList;

/**
 * Handles the command to find a task.
 */
public class FindTaskCommand extends Command{
    private String keywords;

    public FindTaskCommand(String userInput) throws OzilException {
        String[] sections = userInput.split("\\s+", 2);
        if (sections.length < 2) {
            throw new OzilException("Please input a task to find bro.");
        }
        this.keywords = sections[1];
    }

    @Override
    public void run(TaskList tasks) {
        tasks.findTask(this.keywords);
    }
}
