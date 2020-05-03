/**
 * This class contains helper methods
 */
public class Helper {

    /**
     * This method is used to sleep the process enough time between
     * and console message and another.
     * This gives more time the user to read a meesage at once rather
     * than saw a bunch of messages all together and create confusion
     * to player.
     */
    public static void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
