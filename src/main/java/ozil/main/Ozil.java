package ozil.main;

import ozil.command.Command;
import ozil.exception.OzilException;

import java.util.Scanner;

/**
* This is the chatbot Ozil's main class, that runs the chatbot
*/
public class Ozil {
    private TaskList tasks;
    private Storage storage;
    private static final String FILEPATH = "data/tasks.txt";

    /**
     * Constructor to create a new instance of the chatbot
     */
    public Ozil(){
        this.storage = new Storage(FILEPATH);

        try {
            this.tasks = storage.loadStoredTasks();
        } catch (OzilException e) {
            System.out.println(e.getMessage());
        }
    }

    public TaskList getTaskList() {
        return this.tasks;
    }

    private static void echo(String userinput) {
        Messages.line();
        System.out.println(userinput);
        Messages.line();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        Messages.intro();

        Command command = new Command();

        while (!command.isTerminatingCommand()) {
            try {
                String input = scanner.nextLine().trim();
                command = Parser.handleInput(input);
                command.run(this.tasks);
            } catch (OzilException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            this.storage.save(this.getTaskList());
        } catch (OzilException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }

    public static void main(String[] args) {
            Ozil currentOzil = new Ozil();
            currentOzil.run();
    }
}
