package ozil.main;

import ozil.command.Command;
import ozil.exception.OzilException;

import java.util.Scanner;

/**
* This is the chatbot Ozil's main class, that runs the chatbot
* @param tasks Tasks added by the user
* @param isOpen boolean to see whether the chatbot is still running
*/
public class Ozil {
    private TaskList tasks;

    /**
     * Constructor to create a new instance of the chatbot
     */
    public Ozil() {
        this.tasks = new TaskList();
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
                System.out.print(e.getMessage());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Ozil currentOzil = new Ozil();
        currentOzil.run();
    }
}
