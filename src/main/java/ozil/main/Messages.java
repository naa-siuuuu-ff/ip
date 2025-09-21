package ozil.main;

import java.util.ArrayList;

import ozil.task.Task;
/**
* Static class, containing a lot of the commonly displayed messages in Ozil chatbot
*/
public class Messages {
    /**
     * Prints intro message of chatbot.
     */
    public static void intro() {
        System.out.println("Hello! I'm Ozil, your personal assist machine!"
                + "How may I assist you?"
        );
    }

    /**
     * Outro message.
     * @return Bye message
     */
    public static String outro() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Prints a line
     */
    public static void line() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints out the task added message.
     * @param task Task that just has been added.
     */
    @SuppressWarnings("checkstyle:SingleSpaceSeparator")
    public static String printTaskAddMessage(Task task, int numberOfTasks) {
        return "Your task has been added to my records:\n"
              + " " + task.toString() + "\n" + Messages.printNumberOfTasks(numberOfTasks);
    }

    /**
     * Prints the delete task message
     * @param task Task that is deleted
     * @param numberOfTasks Number of current tasks
     * @return Deleted task message
     */
    public static String printTaskDeleteMessage(Task task, int numberOfTasks) {
        return "Understood. I have deleted the following task:" + " " + task.toString()
                + Messages.printNumberOfTasks(numberOfTasks);
    }

    /**
     * Prints the number of tasks in chatbot's list
     * @param numberOfTasks Number of tasks in current chatbot
     */
    public static String printNumberOfTasks(int numberOfTasks) {
        return "My boi Benzi, you now have " + numberOfTasks + " tasks.";
    }

    /**
     * Returns tasks that user was trying to find.
     * @param foundTasks
     * @return String showing message.
     */
    public static String printSearchedTasks(ArrayList<Task> foundTasks) {
        if (foundTasks.isEmpty()) {
            System.out.print("Sorry bro, I could not find any related tasks.");
            return "Sorry bro, I could not find any related tasks.";
        }
        int taskNum = 1;
        String res = "Here are the matching tasks in your list:\n";
        for (Task task: foundTasks) {
            res += taskNum + "." + task.toString() + "\n";
            taskNum++;
        }
        System.out.print(res);
        return res;
    }
}
