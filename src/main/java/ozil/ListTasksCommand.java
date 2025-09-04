package ozil;

public class ListTasksCommand extends Command {
    private String userInput;

    public ListTasksCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void run(TaskList tasks) {
        tasks.printlist();
    }
}
