package src;

import static java.lang.System.out;

public class Logger {

    public static void info(String message) {
        out.println("INFO: " + message + ".");
    }

    public static void prompt(String message) {
        out.println(">: " + message);
    }

    public static void error(String message) {
        out.println("WARNING: " + message + "!");
    }
}
