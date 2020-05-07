import static java.lang.System.out;

/**
 * This class is a helper class to show message prefixed by
 * a string which indicates the type of message.
 * such as:
 * - "INFO: ": indicates information
 * - ">>>>: ": prompt the user to input something
 * - "WARN: ": indicates warning about something
 * It works strictly close to the class GameMessage
 */
public class Logger {
    public static final String NEW_LINE = "\r\n";

    public static void message(String message) {
        Helper.delay();
        out.println(message);
    }

    public static void info(String message) {
        Helper.delay();
        prefixMessage(message, "INFO: ");
    }

    public static void prompt(String message) {
        prefixMessage(message, ">>>>: ");
    }

    public static void warn(String message) {
        prefixMessage(message, "WARN: ");
    }

    private static void prefixMessage(String rawMessage, String prefix) {
        Helper.delay();
        // prefix the message and all is new lines with the constant PREFIX
        final String PREFIX = prefix;
        String message = rawMessage.replaceAll(NEW_LINE, (NEW_LINE + PREFIX));
        out.println(PREFIX + message);
    }
}
