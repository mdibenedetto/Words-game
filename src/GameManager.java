import java.util.Scanner;

/**
 * This class the core component of the game.
 * It acts as orchestrator between all classes of the application.
 * It is in charge to collect the input of the user,
 * to validate it, to process the input, and show the output.
 */
public class GameManager {
    private final int MAX_LIVES = 3;
    private Scanner sc = null;
    private GameMessage message;
    private Player player1, player2;
    private Alphabet alphabet;
    private Game game;

    /**
     * This constructor sets all instances variables
     * needed to handle the life cycle of the game
     */
    public GameManager() {
        sc = new Scanner(System.in);
        message = new GameMessage();
        alphabet = new Alphabet();
    }

    /**
     * This method handles all life cycle of the game.
     * - Shows a welcome message.
     * - Shows the rule of the games and max lives player has got
     * - keeps playing as much as the user wants
     * - displays a summary of the winner at the end of every game
     */
    public void startUp() {
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

    /**
     * This method:
     * - sets the players and their attribute
     * - sets the game object used to handle all game processing
     *
     * Considering that no history is required,
     * this method comes handy when it starts a new game,
     * since all instances get recreated than resetted.
     */
    private void loadNewGame() {
        player1 = new Player("PLAYER-1", MAX_LIVES);
        player2 = new Player("PLAYER-2", MAX_LIVES);
        game = new Game(player1, player2);
    }

    /**
     * This method handles the life cycle of a game and its rounds.
     * it plays a core role which also includes:
     * - It handles the life cycle of a game and its rounds; it takes care of  the turn over between players;
     * - It reads the input of the player;
     * - It computes the input
     * - It displays a round summary after every round;
     * - It keeps running until one of the user runs out all lives
     */
    private void startGame() {
        boolean isGameOver = false;
        Player nextPlayer = player1;
        int turnCounter = 0;
        int roundCounter = 0;
        String nextWord = "";
        // play so far is not Game Over
        while (!isGameOver) {
            readNextWordPlayer(nextPlayer, nextWord);
            nextWord = nextPlayer.getWord();
            turnCounter++;

            // this block it handles the turn over
            if (nextPlayer.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }
            // isGameOver end the current game session
            isGameOver = game.isGameOver();
            // The turnCounter indicates when both player
            // made their choice, so the round can be played
            // the score can be computed
            if (!isGameOver && turnCounter == 2) {
                roundCounter++;
                game.play();
                message.displayRoundSummary(player1, player2, roundCounter);
                turnCounter = 0;
            }
        }
    }

    /**
     * This method handles the player input and it applies the validation rules
     */
    private String readNextWordPlayer(Player player, String lastWord) {
        boolean isValidInput = false, isTurnSkipped = false;
        String word = "";
        String nextLetter;
        // Get a random letter, at the begenning of the game ("")
        // or if the previous round was skipped ("-")
        // otherwise, as per game rule,requires a word which starts
        // with the last 2 letters of the previous word typed
        if (lastWord.equals("") || lastWord.equals("-")) {
            nextLetter = "" + alphabet.findRandomLetter();
        } else {
            nextLetter = lastWord.substring(lastWord.length() - 2);
        }
        // collect the input. Loop untill the input is valid or a turn is skipped
        do {
            message.promptNextWord(player, nextLetter);
            // read user input and set into player
            word = sc.next();
            player.setWord(word);
            // check if the player wants to skip this turn
            isTurnSkipped = game.isTurnSkipped(player);
            message.displayChosenWord(player.name, word, isTurnSkipped);

            if (!isTurnSkipped) {
                // a valid input is either a word into the limited vocabulary
                isValidInput = game.isValidWord(word);
                // notify the user if the input is valid or not
                if (isValidInput) {
                    message.infoWellDone();
                } else {
                    message.warnNotExistWord(word);
                }
            }
        } while (!isValidInput && !isTurnSkipped);

        return word;
    }

    /**
     * This method handles the user wish to play another game
     * The user can type either "yes" or "y", case insensitive
     */
    private boolean wantStillPlay() {
        boolean stillPlay = false;
        boolean isValidAnswer = false;
        String userResponse;

        do {
            message.promptWantStillPlay();

            if (sc.hasNext()) {
                userResponse = sc.next().toLowerCase();
                // the player can keep playing by typing either "yes" or "y"
                // any other word/letter will e considered a negative answer
                if (userResponse.equals("yes") || userResponse.equals("y")) {
                    stillPlay = true;
                }

                isValidAnswer = true;
            } else {
                sc.next();
            }
        } while (!isValidAnswer);

        return stillPlay;
    }
}
