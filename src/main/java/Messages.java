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
    public static void printTaskAddMessage(Task task, ArrayList<? extends Task> taskList) {
        Messages.line();
        System.out.println("Your task has been added to my records:");
        System.out.println(" " + task.toString());
        Messages.printNumberOfTasks(taskList);
        Messages.line();
    }

    public static void printTaskDeleteMessage(Task task) {
        Messages.line();
        System.out.print("Understood. I have deleted the following task:\n");
        System.out.println("  " + task.toString());
        Messages.printNumberOfTasks();
        Messages.line();
    }

    /**
     * Prints the number of tasks in chatbot's list
     * @param tasks Tasklist in chatbot
     */
    public static void printNumberOfTasks(ArrayList<? extends Task> tasks) {
        System.out.println("My boi Benzi, you now have " + tasks.size() + " tasks.");
    }

}
