public class GameMessage {
    final String GAME_NAME = "Java Words Game";
    final String SEPARATOR =
        "----------------------------------------------------";
    final String TITLE_LINE =
        ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";

    private String newLine() {
        return Logger.NEW_LINE;
    }

    private String newLine(String message) {
        return Logger.NEW_LINE + message;
    }

    private String wrapMessage(String rawMessage) {
        String message = SEPARATOR;
        message += newLine(rawMessage);
        message += newLine(SEPARATOR);
        return message;
    }

    private String centerMessage(String text, String textLine) {
        int leftSpaces = (textLine.length() - text.length()) / 2;
        String spaces = new String(new char[leftSpaces]).replace('\0', ' ');
        return spaces + text;
    }

    public void displayWelcome() {
        String message = TITLE_LINE;
        String title = "Welcome to " + GAME_NAME;

        message += newLine(centerMessage(title, TITLE_LINE));
        message += newLine(TITLE_LINE);

        Logger.message(message);
    }

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

    public void displayMaxLives(int maxLives) {
        String message = "";
        message += ("A new game is started");
        message += newLine("You have a total of " + maxLives + " lives");
        Logger.message(wrapMessage(message));
    }

    public void promptWantStillPlay() {
        String message = "";
        message += newLine("Do you want to continue the game?");
        message += newLine("Type 'yes' or choose an option:");
        message += newLine("a) YES - press 1");
        message += newLine("b) NO - press 2");
        message += newLine();
        Logger.prompt(message);
    }

    public void displayPromptNextWord(String playerName, String nextLetter) {
        String message = playerName + ":";
        message += newLine("Please input a valid English word ");
        message += newLine("starting with letter << " + nextLetter + " >>");
        Logger.prompt(message);
    }

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

    public void displayPromptFirstWord() {
        String message = "Please input the FIRST word";
        Logger.prompt(message);
    }

    public void display(String message) {
        Logger.info(message);
    }

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

    public void displayWordNotExist(String word) {
        String message = "Sorry! The word '" + word + "' is not a valid.";
        message += newLine("Try again or type '-' to skip this turn");
        message += newLine();

        Logger.warn(message);
    }
}
