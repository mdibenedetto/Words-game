import static java.lang.System.out;

public class Logger {
    private static final String NEW_LINE = "";

    public static void info(String message) {
        out.println("INFO: " + message + ".");
    }

    public static void prompt(String message) {
        out.println(">: " + message);
    }

    public static void error(String message) {
        out.println("WARNING: " + message + "!");
    }

    /**
     * This method is a helper method to display Info message
     *
     * @author  Michele Di Bendetto
     *
     */
    public static void displayMessage(String msg) {
        display("> " + msg);
    }

    /**
     * This method is a helper method to display Info message with different indentation
     *
     * @author  Michele Di Bendetto
     *
     */
    public static void displaySubMessage(String msg) {
        display("  " + msg);
    }

    /**
     * This method is a helper method to display request of Info message
     *
     * @author  Michele Di Bendetto
     *
     */
    public static void displayInfoRequest(String msg) {
        System.out.print(NEW_LINE + "?-INPUT: " + msg + " ");
    }

    /**
     * This method is a helper method to display Warning message
     *
     * @author  Michele Di Bendetto
     *
     */
    public static void displayWarning(String msg) {
        display("!-WARNING: " + msg);
    }

    /**
     * This method is a helper method to display message
     *
     * @author  Michele Di Bendetto
     *
     */
    public static void display(String msg) {
        System.out.println(msg);
    }
}
