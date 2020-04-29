public class GameMessage {
    private final String NEW_LINE = "\r\n";

    public void welcome() {
        final String GAME_NAME = "Java Words Game";
        Logger.info("Welcome to " + GAME_NAME);
    }

    public void displayRules() {
        String message = "Rule to award points";
        message +=
            newLine(
                "The player receives the same amount " +
                "of points as the number of duplicated vowels"
            );
        message += newLine("EX:");
        message += newLine("“moon” – 2 points");
        message += newLine("“cheerleader” – 4 points");
        message += newLine("“answer” – 0 points");
        Logger.info(message);
    }

    public void displayLeftLives(Player player1) {}

    private String newLine(String message) {
        return NEW_LINE + message;
    }

    public void displayWelcome() {
        String message = "Welcome to the game";
        Logger.info(message);
    }

    public void promptWantStillPlay() {
        String message = "Do you want to continue the game?";
        message += newLine("a) YES - press 1");
        message += newLine("b) NO - press 2");
        Logger.prompt(message);
    }

    public void displayMaxLives(int maxLives) {
        String message = "A new game is started";
        message += newLine("You have a total of " + maxLives + " lives");
        Logger.prompt(message);
    }
}
