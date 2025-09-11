package ozil.command;

import ozil.exception.ErrorMessages;
import ozil.main.Messages;
import ozil.exception.OzilException;

/**
 * The command class to handle the exit ccommand.
 */
public class TerminatingCommand extends Command {

    public TerminatingCommand(String userInput) throws OzilException {
        String[] sections = userInput.split("\\s+", 2);
        if (sections.length > 1) {
            throw new OzilException(ErrorMessages.errorMessage("You cannot tell me to go, \n" +
                "then still tell me other things :(."));
        }
        Messages.outro();
    }

    @Override
    public boolean isTerminatingCommand() {
        return true;
    }
}
