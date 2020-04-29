import java.util.Scanner;

public class GameManager {
    private final int MAX_LIVES = 3;
    private Scanner sc = null;
    private GameMessage message;
    private Player player1, player2;

    /**
     * This constructor set all instances:
     * - 'sc' to use class Scanner to collect input from the User
     * - message to show information
     *
 
     *
     */
    public GameManager() {
        sc = new Scanner(System.in);
        message = new GameMessage();
        player1 = new Player("player-1", MAX_LIVES);
        player2 = new Player("player-2", MAX_LIVES);
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

    private void startGame() {
        final String EXIT_CHAR = "-";
        String nextWord = "";
        Game game = new Game(player1, player2);
        Player nextPlayer = player1;

        while (!nextWord.equals(EXIT_CHAR)) {
            nextWord = nextWordPlayer(nextPlayer);

            if (nextPlayer.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }

            game.play();
        }
    }

    private String nextWordPlayer(Player player) {
        message.displayPromptNextWord(player.name);

        String word = sc.next();
        player.currentWord = word;

        message.displayChosenWord(player.name, word);
        delay();
        return word;
    }

    private void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }

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
