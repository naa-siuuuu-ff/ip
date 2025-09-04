package ozil.main;

import ozil.exception.ErrorMessages;
import ozil.exception.OzilException;
import ozil.task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks =  new ArrayList<>();
    }

    public void printlist() {
        if (this.tasks.isEmpty()) {
            Messages.line();
            System.out.println("You have no tasks. You are a free agent :)");
            Messages.line();
        } else {
            String res = "____________________________________________________________\n"
                    + "Here are the tasks in your list:\n";
            for (int i = 0; i < this.tasks.size(); i++) {
                res += (i + 1) + ". " + this.tasks.get(i).toString() + "\n";
            }
            res += "____________________________________________________________\n";
            System.out.println(res);
        }
    }

    /**
     * Adds a task to the tasklist.
     * @param task The task that is to be added to the tasklist.
     */
    public void addTaskToList(Task task) {
        this.tasks.add(task);
    }

    /**
     * Gives the number of tasks.
     * @return An Integer that is the number of tasks.
     */
    public int getNumberOfTasks() {
        return this.tasks.size();
    }

    /**
     * Returns the task of that number. Task number must be valid
     * @param taskNumber The number of that task.
     * @return The task that is that task number.
     * @throws OzilException If the tasknumber is invalid.
     */
    public Task getTask(int taskNumber) throws OzilException{
        if (taskNumber > this.tasks.size() || taskNumber < 1) {
            throw new OzilException(ErrorMessages.errorMessage("Your task number is invalid."));
        }
        return this.tasks.get(taskNumber - 1);
    }

    /**
     * Sets a particular task.
     * @param taskNumber Number of that task, not its index.
     * @param task New task that is to replace/update the old one.
     * @throws OzilException If the task number is invalid.
     */
    public void setTask(int taskNumber, Task task) throws OzilException{
        if (taskNumber > this.tasks.size() || taskNumber < 1) {
            throw new OzilException(ErrorMessages.errorMessage("Your task number is invalid."));
        }
        this.tasks.set(taskNumber - 1, task);
    }

    public void markTaskAsDone(int taskNumber) throws OzilException{
        Task temp = this.getTask(taskNumber);
        temp.markAsDone();
        this.setTask(taskNumber, temp);
    }

    public void markTaskAsUndone(int taskNumber) throws OzilException {
        Task temp = this.getTask(taskNumber);
        temp.markAsUndone();
        this.setTask(taskNumber, temp);
    }

    /**
     * Deletes a particular task.
     * @param taskNumber The number of that task that is to be deleted.
     * @throws OzilException If the task number is invalid.
     */
    public void deleteTask(int taskNumber) throws OzilException {
        if (taskNumber > this.tasks.size() || taskNumber < 1) {
            throw new OzilException(ErrorMessages.errorMessage("Your task number is invalid."));
        }
        Task deletedTask = this.getTask(taskNumber);
        this.tasks.remove(taskNumber - 1);
        Messages.printTaskDeleteMessage(deletedTask, taskNumber);

    }
}

