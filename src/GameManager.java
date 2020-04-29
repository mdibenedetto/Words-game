import java.util.Scanner;

public class GameManager {
    private Scanner sc = null;
    GameMessage message;
    final int MAX_LIVES = 3;

    /**
     * This constructor set all instances:
     * - 'sc' to use class Scanner to collect input from the User
     * - message to show information
     *
     * @author  Michele Di Bendetto
     *
     */
    public GameManager() {
        sc = new Scanner(System.in);
        message = new GameMessage();
    }

    /**
     * This method manages all life cycle of the game
     *
     * @author  Michele Di Bendetto
     *
     */
    public void start() {
        message.displayWelcome();
        message.displayRules();

        boolean keepPlay = true;
        while (keepPlay) {
            message.displayMaxLives(MAX_LIVES);
            startGame();
            keepPlay = wantStillPlay();
        }
    }

    /**
     * This method runs a game,
     * it collects all inputs from the players,
     * it process those inputs,
     * it updates the Game History
     * it shows who won the round
     *
     * @author  Michele Di Bendetto
     *
     */
    private void startGame() {}

    /**
     * This method asks the user if they want to keep playings
     *
     * @author Raminta Kairyte
     *
     */
    private boolean wantStillPlay() {
        boolean stillPlay = false;
        int userResponse = 0;
        do {
            message.promptWantStillPlay();

            if (sc.hasNextInt()) {
                userResponse = sc.nextInt();

                if (userResponse == 1) {
                    stillPlay = true;
                } else if (userResponse == 2) {
                    stillPlay = false;
                }
            } else {
                // keep going getting the next token (next user input)
                sc.next();
            }
        } while (userResponse < 0 || userResponse > 2);

        return stillPlay;
    }
}
