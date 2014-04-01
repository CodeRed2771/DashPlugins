package terminalcommands;

/**
 *
 * @author Austin
 */
interface Command {
    public String executeCommand(String command);
    public String getName();
}
