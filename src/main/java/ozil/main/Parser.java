package ozil.main;

import ozil.command.*;
import ozil.exception.ErrorMessages;
import ozil.exception.OzilException;

/**
 * The main handler for user input. It throws some exceptions when user is missing input,
 * and deals with function calls for the different inputs.
 */
public class Parser {

    private static boolean doesInputStartWith(String input, String command) {
        return input.toLowerCase().startsWith(command);
    }

    public static Command handleInput(String userInput) throws OzilException {
        String input = userInput.trim();

        if (doesInputStartWith(input, "bye")) {
            return new TerminatingCommand(input);
        } else if (doesInputStartWith(input, "mark")) {
            return new MarkTaskCommand(input);
        } else if (doesInputStartWith(input, "unmark")) {
            return new UnmarkTaskCommand(input);
        } else if (doesInputStartWith(input, "delete")) {
            return new DeleteTaskCommand(input);
        } else if (doesInputStartWith(input, "todo")) {
            return new AddTodoTaskCommand(input);
        } else if (doesInputStartWith(input, "deadline")) {
            return new AddDeadlineTaskCommand(input);
        } else if (doesInputStartWith(input, "event")) {
            return new AddEventTaskCommand(input);
        } else if (doesInputStartWith(input, "list")) {
            return new ListTasksCommand(input);
        } else {
            throw new OzilException(ErrorMessages.nonsenseError());
        }

    }
}