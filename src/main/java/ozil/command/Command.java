package ozil.command;

import ozil.exception.OzilException;
import ozil.main.TaskList;

public class Command {
    public void run(TaskList tasks) throws OzilException {
    }

    public boolean isTerminatingCommand() {
        return false;
    }
}
