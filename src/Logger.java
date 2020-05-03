import static java.lang.System.out;

/**
 * This class is a helper class to show generic message.
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

        out.println("INFO: " + message);
    }

    public static void prompt(String rawMessage) {
        Helper.delay();

        final String PREFIX = ">>>>: ";
        String message = rawMessage.replaceAll(NEW_LINE, (NEW_LINE + PREFIX));
        out.println(PREFIX + message);
    }

    public static void warn(String message) {
        Helper.delay();

        out.println("WARN: " + message);
    }
}
