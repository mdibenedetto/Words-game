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

        int gameCounter = 0;
        boolean keepPlay = true;
        while (keepPlay) {
            gameCounter++;
            message.displayMaxLives(MAX_LIVES);
            loadNewGame();
            startGame();
            message.displayEndGameSummary(gameCounter, player1, player2);
            keepPlay = wantStillPlay();
        }

        message.displayGreetings();
    }

    private void loadNewGame() {
        player1 = new Player("PLAYER-1", MAX_LIVES);
        player2 = new Player("PLAYER-2", MAX_LIVES);
        game = new Game(player1, player2);
    }

    private void startGame() {
        boolean isGameOver = false;
        Player nextPlayer = player1;
        int turnCounter = 0;
        String lastWord = "";

        while (!isGameOver) {
            readNextWordPlayer(nextPlayer, lastWord);
            lastWord = nextPlayer.getWord();
            turnCounter++;

            if (nextPlayer.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }

            if (turnCounter == 2) {
                game.play();
                isGameOver = game.isGameOver();
                turnCounter = 0;
            }
        }
    }

    private String readNextWordPlayer(Player player, String lastWord) {
        boolean isValid = false, isTurnSkipped = false;
        String word = "";
        String nextLetter;

        if (lastWord.equals("") || lastWord.equals("-")) {
            nextLetter = "" + alphabet.findRandomLetter();
        } else {
            nextLetter = lastWord.substring(lastWord.length() - 2);
        }

        do {
            message.displayPromptNextWord(player, nextLetter);

            word = sc.next();
            player.setWord(word);
            isTurnSkipped = game.hasSkippedTurn(player);

            message.displayChosenWord(player.name, word, isTurnSkipped);

            if (isTurnSkipped) {
                isValid = true;
            } else {
                isValid = isValidInput(word);
            }

            if (!isValid) {
                Helper.delay();
                message.displayWordNotExist(word);
            }
        } while (!isValid);

        Helper.delay();

        return word;
    }

    private boolean isValidInput(String word) {
        if (word.length() < 3) return false;
        if (!vocabulary.isValidWord(word)) return false;
        return true;
    }

    private boolean wantStillPlay() {
        boolean stillPlay = false;
        boolean isValidAnswer = false;
        String userResponse;

        do {
            message.promptWantStillPlay();

            if (sc.hasNext()) {
                userResponse = sc.next().toLowerCase();

                if (userResponse.equals("yes") || userResponse.equals("y")) {
                    stillPlay = true;
                } else {
                    stillPlay = false;
                }

                isValidAnswer = true;
            } else {
                sc.next();
            }
        } while (!isValidAnswer);

        return stillPlay;
    }
}
