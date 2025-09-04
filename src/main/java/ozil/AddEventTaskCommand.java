package ozil;

import ozil.task.EventTask;

public class AddEventTaskCommand extends Command{
    private String description;
    private String startTime;
    private String endTime;

    public AddEventTaskCommand(String userInput) throws OzilException{
        String[] sections = userInput.split("\\s+", 2);

        if (sections[1].trim().startsWith("/from")) {
            throw new OzilException(ErrorMessages.taskDescriptionError("event"));
        }

        String[] parts = sections[1].trim().split("/from|/to");
        if (parts.length < 3) {
            throw new OzilException(ErrorMessages.eventTaskTimeError());
        }

        this.description = parts[0].trim();
        this.startTime = parts[1]. trim();
        this.endTime = parts[2].trim();
    }

    @Override
    public void run(TaskList tasks) {
        EventTask task = new EventTask(this.description, this.startTime, this.endTime);
        tasks.addTaskToList(task);
        Messages.printTaskAddMessage(task, tasks.getNumberOfTasks());
    }
}
