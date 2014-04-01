package terminalcommands;

/**
 *
 * @author Austin
 */
public class Login implements Command {

    boolean auth = false;

    @Override
    public String executeCommand(String command) {
        String message = "";
        if (command.matches("bitly")) {
            auth = true;
            message = "authentication sucess\n";
        } else if (command.matches("deauth")) {
            auth = false;
            message = "deauthenticated\n";
        } else {
            message = "authentication failure\n";
        }
        return message;
    }

    @Override
    public String getName() {
        return "login";
    }
}
