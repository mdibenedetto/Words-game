package src;

public class GameManager {
    GameMessage message;
    Player player1;
    Player player2;

    public GameManager() {
        message = new GameMessage();
        player1 = new Player();
        player2 = new Player();
    }

    public void start() {
        message.displayRules();
        message.displayLeftLives(player1);
    }

    private void nextTurn() {}
}
