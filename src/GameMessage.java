/**
 * This class handle all messages needed of the application,
 * such welcoming, alerting, or to display a simple output *
 */
public class GameMessage {
    private final String GAME_NAME = "Java Words Game";
    private final String SEPARATOR =
        "----------------------------------------------------";
    private final String TITLE_LINE =
        ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";

    private String newLine() {
        return Logger.NEW_LINE;
    }

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
     * This method center a string into the console message,
     * calculate the distance based on the constants TITLE_LINE
     * or SEPARATOR
     */
    private String centerMessage(String text, String textLine) {
        int leftSpaces = (textLine.length() - text.length()) / 2;
        String spaces = new String(new char[leftSpaces]).replace('\0', ' ');
        return spaces + text;
    }

    /**
     * This method display a welcome message
     */
    public void displayWelcome() {
        String message = TITLE_LINE;
        String title = "Welcome to " + GAME_NAME;

        message += newLine(centerMessage(title, TITLE_LINE));
        message += newLine(TITLE_LINE);

        Logger.message(message);
    }

    /**
     * This method display all the rules to play the game and make a score
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
     * This method display how many lives a player has
     */
    public void displayMaxLives(int maxLives) {
        String message = "";
        message += ("A new game is started");
        message += newLine("You have a total of " + maxLives + " lives");
        Logger.message(wrapMessage(message));
    }

    /**
     * This method prompt a player if  want to play another game
     */
    public void promptWantStillPlay() {
        String message = "";
        message += newLine("Do you want to continue the game?");
        message += newLine("'(y)es' to continue or any other letter to end.");
        message += newLine();
        Logger.prompt(message);
    }

    /**
     * This method promp a player to input a  word to play the game
     */
    public void promptNextWord(Player player, String nextLetter) {
        String message =
            player.name +
            " (Lives: " +
            player.numberOfLives +
            ", Score:" +
            player.score +
            ")";
        message += newLine();
        message += newLine("Please input a valid English word ");
        message += newLine("starting with letter << " + nextLetter + " >>");
        Logger.prompt(message);
    }

    /**
     * This method display which word the player has input
     */
    public void displayChosenWord(
        String playerName,
        String word,
        boolean isTurnSkipped
    ) {
        String message = playerName;
        message += ": Your choosen word is << " + word + " >>";
        if (isTurnSkipped) {
            message +=
                newLine(
                    "You decided to skip this round. You will loose one life."
                );
        }
        message += newLine();
        Logger.info(message);
    }

    /**
     * This method display a summary of at the end of the game,
     * who is the winner and  the score
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
        message += newLine();
        message += newLine("The winner is: " + winner.name);
        message += newLine("Total score  :" + winner.score);
        message += newLine();
        message += newLine("The looser is: " + looser.name);
        message += newLine("Total score  :" + looser.score);
        message += newLine();
        Logger.info(wrapMessage(message));
    }

    /**
     * This method alert the player that the word inputed
     * is not part of the English vacabulary of the  game
     */
    public void warnNotExistWord(String word) {
        String message = "Sorry! The word '" + word + "' is not a valid.";
        message += newLine("Try again or type '-' to skip this turn");
        message += newLine();

        Logger.warn(message);
    }

    /**
     * This method display the end greeting when the game ends
     */
    public void displayGreetings() {
        String message = TITLE_LINE;
        String title = "Thaks to have played with " + GAME_NAME;

        message += newLine(centerMessage(title, TITLE_LINE));
        message += newLine(TITLE_LINE);

        Logger.message(message);
    }
}
