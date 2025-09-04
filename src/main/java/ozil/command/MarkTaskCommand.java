package ozil.command;

import ozil.exception.ErrorMessages;
import ozil.main.Messages;
import ozil.exception.OzilException;
import ozil.main.TaskList;

public class MarkTaskCommand extends Command {
    private int taskNumber;

    public MarkTaskCommand(String userInput) throws OzilException {
        String[] sections = userInput.split("\\s+", 2);
        if (sections.length < 2) {
            throw new OzilException(ErrorMessages.wrongMarkNumber());
        }
        this.taskNumber = Integer.parseInt(sections[1]);
    }

    @Override
    public void run(TaskList tasks) throws OzilException {
        if (this.taskNumber > tasks.getNumberOfTasks()) {
            throw new OzilException(ErrorMessages.wrongMarkNumber());
        }
        tasks.markTaskAsDone(this.taskNumber);
        Messages.line();
        System.out.println("Ok! I have marked this task as completed:\n");
        System.out.println(tasks.getTask(this.taskNumber).toString());
        Messages.line();
    }
}
