package ozil.exception;

/**
 * Static class, containing a lot of the commonly displayed ERROR messages in Ozil chatbot
 */
public class ErrorMessages {
    /**
     * Returns error logo.
     * @return Returns error logo
     */
    public static String errorLogo() {
        return " ___ _ _ \n" +
                "|__ \\ | |\n" +
                "  / / | |\n" +
                " |_||_|_|\n" +
                " (_)(_|_)\n";
    }

    /**
     * Returns an error message with the error logo.
     * @param errorMessage Message telling the user their mistake.
     * @return
     */
    public static String errorMessage(String errorMessage) {
        return ErrorMessages.errorLogo() + "\n" + ErrorMessages.line() +
                "\n" + errorMessage;

    }

    private static String line() {
        return "____________________________________________________________\n";
    }

    /**
     * Error message for when selected task does not exist
     * @return
     */
    public static String wrongMarkNumber() {
        return ErrorMessages.line() + ErrorMessages.errorLogo() +
                "You need to select a valid task number bro. \n" +
                ErrorMessages.line();
    }

    /**
     * Error message when user does not give any instructions
     */
    public static String nonsenseError() {
        return ErrorMessages.line() + ErrorMessages.errorLogo() +
                "What's that? No idea what you mean, cannot help you there mate\n" +
                ErrorMessages.line();
    }

    /**
     * Error message when user does not give the description of a task
     * @param tasktype The type of task the user wanted to do
     */
    public static String taskDescriptionError(String tasktype) {
        return ErrorMessages.line() + ErrorMessages.errorLogo() +
                "Your description of a " + tasktype + " cannot be blank :(\n" +
                ErrorMessages.line();
    }

    /**
     * Error message for when events time format is incorrect.
     * @return Error message
     */
    public static String eventTaskTimeError() {
        return ErrorMessages.line() + ErrorMessages.errorLogo() +
                "Your event must have a time format /from <start-time> /to <end-time>\n" +
                ErrorMessages.line();
    }

    /**
     * Error message for deadline tasks missing the deadline.
     * @return Error message
     */
    public static String deadlineTaskTimeError() {
        return ErrorMessages.line() + ErrorMessages.errorLogo() +
                "Your deadline must have a time format /by <deadline>. \n" +
                ErrorMessages.line();
    }


}
