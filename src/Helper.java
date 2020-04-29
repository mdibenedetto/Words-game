public class Helper {

    public static void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
