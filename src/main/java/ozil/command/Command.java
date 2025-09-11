package ozil.command;

import ozil.exception.OzilException;
import ozil.main.TaskList;

/**
 * The parent class of all commands.
 */
public class Command {
    public void run(TaskList tasks) throws OzilException {
    }

    public boolean isTerminatingCommand() {
        return false;
    }
}
