import static java.lang.System.out;

public class Logger {
    private static final String NEW_LINE = "";

    public static void message(String message) {
        out.println(message);
    }

    public static void info(String message) {
        out.println("INFO: " + message);
    }

    public static void prompt(String message) {
        out.println(">>>>: " + message);
    }

    public static void error(String message) {
        out.println("WARN: " + message + "!");
    }
}
