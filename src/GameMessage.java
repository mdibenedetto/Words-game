/**
 * This class handles all messages needed of the application,
 * such us:
 * - welcome the players
 * - alert
 * - display a simple output
 */
public class GameMessage {
    private final String GAME_NAME = "Java Words Game";
    private final String SEPARATOR =
        "----------------------------------------------------";
    private final String TITLE_LINE =
        ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";

    /**
     * This method creates an empty new line
     */
    private String newLine() {
        return Logger.NEW_LINE;
    }

    /**
     * This method prefixes a message with a new line
     */
    private String newLine(String message) {
        return Logger.NEW_LINE + message;
    }

    /**
     * This method wraps a string into 2 lead line SEPARATOR
     */
    private String wrapMessage(String rawMessage) {
        String message = SEPARATOR;
        message += newLine(rawMessage);
        message += newLine(SEPARATOR);
        return message;
    }

    /**
     * This method centers a string into the console message,
     * calculates the distance based on the constants TITLE_LINE
     * or SEPARATOR which are sent through the param "textLine"
     */
    private String centerMessage(String text, String textLine) {
        int leftSpaces = (textLine.length() - text.length()) / 2;
        String spaces = new String(new char[leftSpaces]).replace('\0', ' ');
        return spaces + text;
    }

    /**
     * This method displays a welcome message
     */
    public void displayWelcome() {
        String message = TITLE_LINE;
        String title = "Welcome to " + GAME_NAME;

        message += newLine(centerMessage(title, TITLE_LINE));
        message += newLine(TITLE_LINE);

        Logger.message(message);
    }

    /**
     * This method displays all the rules to play the game and make the score
     */
    public void displayRules() {
        String message = "";
        message += centerMessage("Rule to award points", SEPARATOR);
        message += newLine(SEPARATOR);
        message += newLine("The player receives the same amount of points");
        message += newLine("as the number of duplicated vowels");
        message += newLine("EX:");
        message += newLine("\t“moon” – 2 points");
        message += newLine("\t“cheerleader” – 4 points");
        message += newLine("\t“answer” – 0 points");
        Logger.message(wrapMessage(message));
    }

    /**
     * This method displays how many lives a player has got
     */
    public void displayMaxLives(int maxLives) {
        String message = "";
        message += centerMessage("A new game is started", SEPARATOR);
        message +=
            newLine(
                centerMessage(
                    "You have a total of " + maxLives + " lives",
                    SEPARATOR
                )
            );
        Logger.message(wrapMessage(message));
    }

    /**
     * This method prompts a player if want to play another game
     */
    public void promptWantStillPlay() {
        String message = "";
        message += newLine("Do you want to continue the game?");
        message += newLine("'(y)es' to continue or any other letter to end.");
        message += newLine();
        Logger.prompt(message);
    }

    /**
     * This method prompts a player to input a word to play the game
     */
    public void promptNextWord(Player player, String nextLetter) {
        String message = makePlayerRoundSummary(player);
        message += newLine();
        message += newLine("Please input a valid English word ");
        message += newLine("starting with letter << " + nextLetter + " >>");
        Logger.prompt(message);
    }

    /**
     * This method displays which word the player has typed
     */
    public void displayChosenWord(
        String playerName,
        String word,
        boolean isTurnSkipped
    ) {
        String message = playerName;
        message += ": Your choosen word is << " + word + " >>";
        if (isTurnSkipped) {
            message += newLine("You decided to skip this round.");
            message += newLine("You will loose one life.");
        }
        Logger.info(message);
        Logger.message("");
    }

    /**
     * This method displays a well done message, used in case the word is correct
     */
    public void infoWellDone() {
        String message = "Well done!";
        Logger.info(message);
        Logger.message("");
    }

    /**
     * This method displays a summary of at the end of the game,
     * who is the winner and the score.
     * The winner is whoever has more lives left
     */
    public void displayEndGameSummary(
        int gameCounter,
        Player player1,
        Player player2
    ) {
        Player winner, looser;

        if (player1.numberOfLives > 0) {
            winner = player1;
            looser = player2;
        } else {
            winner = player2;
            looser = player1;
        }

        String message = "The Game N." + gameCounter + " is ended";
        message += newLine(SEPARATOR);
        message += makePlayerGameSummary(winner, "winner");
        message += newLine();
        message += makePlayerGameSummary(looser, "looser");
        Logger.message(wrapMessage(message));
    }

    /**
     * This method create a string with a summary of the player
     * status after the game ended
     */
    private String makePlayerGameSummary(Player player, String title) {
        String message = "";
        message += newLine("The " + title + " is: " + player.name);
        message += newLine("Total score  : " + player.score + " points");
        message += newLine("Lives left   : " + player.numberOfLives);
        return message;
    }

    /**
     * This method alerts the player that the word typed
     * is not part of the English vacabulary of the  game
     */
    public void warnNotExistWord(String word) {
        String message = "Sorry! The word '" + word + "' is not a valid.";
        message += newLine("Try again or type '-' to skip this turn");

        Logger.warn(message);
        Logger.message("");
    }

    /**
     * This method displays the end greeting whenthe game ends
     */
    public void displayGreetings() {
        String message = TITLE_LINE;
        String title = "Thanks to have played with " + GAME_NAME;

        message += newLine(centerMessage(title, TITLE_LINE));
        message += newLine(TITLE_LINE);

        Logger.message(message);
    }

    /**
     * This method displays a summary of the players
     * status after a round ended
     */
    public void displayRoundSummary(
        Player player1,
        Player player2,
        int roundCounter
    ) {
        String message = "Summary - Round N." + roundCounter;
        message += newLine(SEPARATOR);
        message += newLine(makePlayerRoundSummary(player1));
        message += newLine(makePlayerRoundSummary(player2));
        Logger.message(wrapMessage(message));
    }

    /**
     * This method create a string with a summary of the player
     * status after a round ended
     */
    private String makePlayerRoundSummary(Player player) {
        String message =
            player.name +
            " (Lives: " +
            player.numberOfLives +
            ", Score:" +
            player.score +
            ")";
        return message;
    }
}
