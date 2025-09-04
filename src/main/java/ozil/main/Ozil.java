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
    public Ozil() throws OzilException{
        this.storage = new Storage(FILEPATH);

        try {
            this.tasks = storage.loadStoredTasks();
        } catch (OzilException e) {
            throw new OzilException(e.getMessage());
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

    public void run() throws OzilException {
        Scanner scanner = new Scanner(System.in);

        Messages.intro();

        Command command = new Command();

        while (!command.isTerminatingCommand()) {
            try {
                String input = scanner.nextLine().trim();
                command = Parser.handleInput(input);
                command.run(this.tasks);
            } catch (OzilException e) {
                System.out.print(e.getMessage());
            }
        }

        this.storage.save(this.getTaskList());

        scanner.close();
    }

    public static void main(String[] args) {
        try {
            Ozil currentOzil = new Ozil();
            currentOzil.run();
        } catch (OzilException e) {
            throw new RuntimeException(e);
        }
    }
}
