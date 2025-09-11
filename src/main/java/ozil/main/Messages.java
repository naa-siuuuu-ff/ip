package ozil.main;

import ozil.task.Task;

import java.util.ArrayList;

/**
* Static class, containing a lot of the commonly displayed messages in Ozil chatbot
*/
public class Messages {
    /**
     * Prints intro message of chatbot.
     */
    public static void intro() {
        Messages.line();
        System.out.print("  ___      _ _        _  ___  \n" +
                " / _ \\ ___(_) |      / |/ _ \\ \n" +
                "| | | |_  / | |      | | | | |\n" +
                "| |_| |/ /| | |      | | |_| |\n" +
                " \\___//___|_|_|      |_|\\___/ \n");
        System.out.println( "____________________________________________________________\n"
                + "Hello! I'm Ozil, your personal assist machine!\n"
                + "How may I assist you?\n"
                + "____________________________________________________________\n"
        );
    }

    /**
     * Prints bye message for chatbot.
     */
    public static void outro() {
        System.out.println("____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n");
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
    public static void printTaskAddMessage(Task task, int numberOfTasks) {
        Messages.line();
        System.out.println("Your task has been added to my records:");
        System.out.println(" " + task.toString());
        Messages.printNumberOfTasks(numberOfTasks);
        Messages.line();
    }

    public static void printTaskDeleteMessage(Task task, int numberOfTasks) {
        Messages.line();
        System.out.print("Understood. I have deleted the following task:\n");
        System.out.println("  " + task.toString());
        Messages.printNumberOfTasks(numberOfTasks);
        Messages.line();
    }

    /**
     * Prints the number of tasks in chatbot's list
     * @param numberOfTasks Number of tasks in current chatbot
     */
    public static void printNumberOfTasks(int numberOfTasks) {
        System.out.println("My boi Benzi, you now have " + numberOfTasks + " tasks.");
    }

    public static String printSearchedTasks(ArrayList<Task> foundTasks) {
        if (foundTasks.isEmpty()) {
            System.out.print("Sorry bro, I could not find any related tasks.");
            return "Oops";
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
