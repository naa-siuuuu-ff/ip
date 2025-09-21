package ozil.main;

import ozil.command.Command;
import ozil.exception.ErrorMessages;
import ozil.exception.OzilException;


/**
* This is the chatbot Ozil's main class, that runs the chatbot
*/
public class Ozil {
    private static final String FILEPATH = "data/tasks.txt";
    private TaskList tasks;
    private Storage storage;

    /**
     * Constructor to create a new instance of the chatbot
     */
    public Ozil() {
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

    public String getResponse(String input) {
        try {
            if (input.isBlank()) {
                throw new OzilException(ErrorMessages.nonsenseError());
            }
            Command command = Parser.handleInput(input);
            if (command.isTerminatingCommand()) {
                try {
                    this.storage.save(this.getTaskList());
                } catch (OzilException e) {
                    throw new RuntimeException(e);
                }
                return Messages.outro();
            } else {
                return command.run(this.tasks);
            }
        } catch (OzilException e) {
            return e.getMessage();
        }
    }
//    /**
//     * Runs the current instance of the chatbot.
//     */
//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//
//        Messages.intro();
//
//        Command command = new Command();
//
//        while (!command.isTerminatingCommand()) {
//            try {
//                String input = scanner.nextLine().trim();
//                command = Parser.handleInput(input);
//                command.run(this.tasks);
//            } catch (OzilException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        try {
//            this.storage.save(this.getTaskList());
//        } catch (OzilException e) {
//            throw new RuntimeException(e);
//        }
//        scanner.close();
//    }
//
//    public static void main(String[] args) {
//        Ozil currentOzil = new Ozil();
//        currentOzil.run();
//    }
}
