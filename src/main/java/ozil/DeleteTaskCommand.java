package ozil;

public class DeleteTaskCommand extends Command{
    private int taskNumber;

    public DeleteTaskCommand(String userInput) throws OzilException {
        String[] sections = userInput.trim().split("\\s+", 2);
        if (sections.length < 2) {
            throw new OzilException(ErrorMessages.wrongMarkNumber());
        }
        this.taskNumber = Integer.parseInt(sections[1]);
    }

    @Override
    public void run(TaskList tasks) throws OzilException{
        if (this.taskNumber > tasks.getNumberOfTasks()) {
            throw new OzilException(ErrorMessages.wrongMarkNumber());
        }
        tasks.deleteTask(this.taskNumber);
    }
}
