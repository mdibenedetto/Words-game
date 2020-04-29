import java.util.Scanner;

public class GameManager {
    private final int MAX_LIVES = 3;
    private Scanner sc = null;
    private GameMessage message;
    private Player player1, player2;
    private Alphabet alphabet;
    private Game game;
    LimitedVocabulary vocabulary;

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
        vocabulary = new LimitedVocabulary();
        alphabet = new Alphabet();

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
        boolean keepPlay = true;

        final String EXIT_CHAR = "-";
        String nextWord = "";
        game = new Game(player1, player2);
        Player nextPlayer = player1;
        int matchCounter = 0;

        while (keepPlay) {
            nextWord = nextWordPlayer(nextPlayer);

            if (nextWord.equals(EXIT_CHAR)) {
                nextPlayer.numberOfLives--;
            }

            matchCounter++;

            if (nextPlayer.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }

            if (matchCounter == 2) {
                game.play();

                message.display("player1.score: " + player1.score);
                message.display("player2.score: " + player2.score);

                matchCounter = 0;
            }
        }
    }

    private String nextWordPlayer(Player player) {
        boolean isValid = false;
        String word = "";
        char nextLetter = alphabet.findRandomLetter();

        do {
            message.displayPromptNextWord(player.name, nextLetter);
            word = sc.next();
            message.displayChosenWord(player.name, word);
            isValid = vocabulary.isValidWord(word);
        } while (!isValid);

        player.setWord(word);
        Helper.delay();

        return word;
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
