package ozil;

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

    //        String[] sections = input.split("\\s+", 2);
//        String command = sections[0].toLowerCase();
//        switch (command) {
//        case "mark":
//            if (sections.length > 1) {
//                int tasknum = Integer.parseInt(sections[1]);
//                if (tasknum > this.tasks.size()) {
//                    throw new OzilException(ErrorMessages.wrongMarkNumber());
//                }
//                this.markTask(tasknum);
//            } else {
//                throw new OzilException(ErrorMessages.wrongMarkNumber());
//            }
//            break;
//        case "unmark":
//            if (sections.length > 1) {
//                int tasknum = Integer.parseInt(sections[1]);
//                if (tasknum > this.tasks.size()) {
//                    throw new OzilException(ErrorMessages.wrongMarkNumber());
//                }
//                this.unmarkTask(tasknum);
//            } else {
//                throw new OzilException(ErrorMessages.wrongMarkNumber());
//            }
//            break;
//        case "delete":
//            if (sections.length > 1) {
//                int tasknum = Integer.parseInt(sections[1]);
//                if (tasknum > this.tasks.size()) {
//                    throw new OzilException(ErrorMessages.wrongMarkNumber());
//                }
//                this.deleteTask(tasknum);
//            } else {
//                throw new OzilException(ErrorMessages.wrongMarkNumber());
//            }
//            break;
//        case "todo":
//            if (sections.length > 1) {
//                this.addTodoTaskToList(sections[1]);
//            } else {
//                throw new OzilException(ErrorMessages.taskDescriptionError("todo"));
//            }
//            break;
//        case "deadline":
//            if (sections.length > 1) {
//                this.addDeadlineTaskToList(sections[1]);
//            } else {
//                throw new OzilException(ErrorMessages.taskDescriptionError("deadline"));
//            }
//            break;
//        case "event":
//            if (sections.length > 1) {
//                this.addEventTaskToList(sections[1]);
//            } else {
//                throw new OzilException(ErrorMessages.taskDescriptionError("event"));
//            }
//            break;
//        case "list":
//            this.printlist();
//            break;
//        case "bye":
//            Messages.outro();
//            this.isOpen = false;
//            break;
//        default:
//            throw new OzilException(ErrorMessages.nonsenseError());
//        }


