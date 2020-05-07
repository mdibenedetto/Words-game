/**
 * This class contains helper methods
 */
public class Helper {

    /**
     * This method is used to sleep the process enough time
     * between a console message and another.
     *
     * This gives more time the user to read a message 1 by 1,
     * rather than to sse a bunch of messages all together
     * which creates confusion to the player.
     */
    public static void delay() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
