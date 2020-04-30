import static java.lang.System.out;

public class Logger {
    public static final String NEW_LINE = "\r\n";

    public static void message(String message) {
        out.println(message);
    }

    public static void info(String message) {
        out.println("INFO: " + message);
    }

    public static void prompt(String rawMessage) {
        final String PREFIX = ">>>>: ";
        String message = rawMessage.replaceAll(NEW_LINE, NEW_LINE + PREFIX);
        out.println(PREFIX + message);
    }

    public static void error(String message) {
        out.println("WARN: " + message + "!");
    }
}
