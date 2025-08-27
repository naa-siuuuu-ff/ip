import java.util.ArrayList;
import java.util.Scanner;

/**
* This is the chatbot Ozil's main class, that runs the chatbot
* @param tasks Tasks added by the user
* @param isOpen boolean to see whether the chatbot is still running
*/
public class Ozil {
    private ArrayList<Task> tasks;
    private boolean isOpen;

    /**
     * Constructor to create a new instance of the chatbot
     */
    public Ozil() {
        this.tasks = new ArrayList<Task>();
        this.isOpen = true;
    }

    private static void echo(String userinput) {
        Messages.line();
        System.out.println(userinput);
        Messages.line();
    }

    private void addTaskToList(String userinput) {
        Task task = new Task(userinput);
        this.tasks.add(task);
        Messages.printTaskAddMessage(task, this.tasks);
    }

    private void addTodoTaskToList(String userinput) {
        TodoTask task = new TodoTask(userinput);
        this.tasks.add(task);
        Messages.printTaskAddMessage(task, this.tasks);
    }

    private void addEventTaskToList(String userinput) {
        String[] parts = userinput.split("/from|/to");
        if (parts.length < 3) {
            System.out.println("Your event format is not it. Event deatils, start time, or end time");
            System.out.println("ARE MISSING");
            System.out.println("Use: event <description> /from <start> /to <end>");
            return;
        }
        String description = parts[0].trim();
        String startTime = parts[1].trim();
        String endTime = parts[2].trim();
        EventTask task = new EventTask(description, startTime, endTime);
        this.tasks.add(task);
        Messages.printTaskAddMessage(task, this.tasks);
    }

    private void addDeadlineTaskToList(String userinput) {
        String[] parts = userinput.trim().split("/by", 2);
        if (parts.length < 2) {
            System.out.println("Your deadline format is not it. Task details or deadline cannot be missing");
            System.out.println("Use: deadline <description> /by <time>");
            return ;
        }
        String description = parts[0].trim();
        String deadline = parts[1];
        DeadlineTask task = new DeadlineTask(description, deadline);
        this.tasks.add(task);
        Messages.printTaskAddMessage(task, this.tasks);
    }

    private void markTask(int tasknum) {
        Task temp = this.tasks.get(tasknum - 1);
        temp.markAsDone();
        String res = "____________________________________________________________\n"
                + "Ok! I have marked this task as completed:\n"
                + temp.toString()
                + "____________________________________________________________\n";
        this.tasks.set(tasknum - 1, temp);
        System.out.println(res);

    }

    private void unmarkTask(int tasknum) {
        Task temp = this.tasks.get(tasknum - 1);
        temp.markAsUndone();
        String res = "Task has been marked as incomplete:\n"
                + temp.toString() + "\n";
        this.tasks.set(tasknum - 1, temp);
        Messages.line();
        System.out.println(res);
        Messages.line();
    }

    private void printlist() {
        String res = "____________________________________________________________\n"
                + "Here are the tasks in your list:\n";
       for (int i = 0; i < this.tasks.size(); i++) {
           res += (i + 1) + ". " + this.tasks.get(i).toString() + "\n";
       }
        res += "____________________________________________________________\n";
        System.out.println(res);
    }

    private void inputHandler(String input) {
        String[] sections = input.split("\\s+", 2);
        String command = sections[0].toLowerCase();

        switch (command) {
        case "mark":
            if (sections.length > 1) {
                this.markTask(Integer.parseInt(sections[1]));
            }
            break;
        case "unmark":
            if (sections.length > 1) {
                this.unmarkTask(Integer.parseInt(sections[1]));
            }
            break;
        case "todo":
            if (sections.length > 1) {
                this.addTodoTaskToList(sections[1]);
            }
            break;
        case "deadline":
            if (sections.length > 1) {
                this.addDeadlineTaskToList(sections[1]);
            }
            break;
        case "event":
            if (sections.length > 1) {
                this.addEventTaskToList(sections[1]);
            }
            break;
        case "list":
            this.printlist();
            break;
        case "bye":
            Messages.outro();
            this.isOpen = false;
            break;
        default:
            this.addTaskToList(input);
        }


    }

    public static void main(String[] args) {
        Ozil currentOzil = new Ozil();
        Scanner scanner = new Scanner(System.in);

        Messages.intro();

        while (currentOzil.isOpen) {
            String input = scanner.nextLine().trim();
            currentOzil.inputHandler(input);
        }

        scanner.close();
    }

}
