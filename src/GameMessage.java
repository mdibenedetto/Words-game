package src;

public class GameMessage {

    public void welcome() {
        final String GAME_NAME = "Java Words Game";
        Logger.info("Welcome to " + GAME_NAME);
    }

    public void displayRules() {}

    public void displayLeftLives(Player player1) {}
}
