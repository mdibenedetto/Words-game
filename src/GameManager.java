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
            startGame();
            message.displayEndGameSummary(gameCounter, player1, player2);
            keepPlay = wantStillPlay();
        }
    }

    private void startGame() {
        boolean keepPlay = true;

        player1 = new Player("PLAYER-1", MAX_LIVES);
        player2 = new Player("PLAYER-2", MAX_LIVES);
        game = new Game(player1, player2);

        Player nextPlayer = player1;
        int matchCounter = 0;
        String lastWord = "";

        while (keepPlay) {
            readNextWordPlayer(nextPlayer, lastWord);
            lastWord = nextPlayer.word;
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
                keepPlay = !game.isGameOver();

                matchCounter = 0;
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
            message.displayPromptNextWord(player.name, nextLetter);

            word = sc.next();
            player.setWord(word);
            isTurnSkipped = game.hasSkippedTurn(player);

            message.displayChosenWord(player.name, word, isTurnSkipped);

            if (isTurnSkipped) {
                isValid = true;
            } else {
                isValid = isValidInput(word);
            }
        } while (!isValid);

        Helper.delay();

        return word;
    }

    private boolean isValidInput(String word) {
        if (word.length() > 2) return true; // least 3 letters
        if (vocabulary.isValidWord(word)) return true;
        return false;
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
