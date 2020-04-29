public class GameMessage {
    private final String NEW_LINE = "\r\n";
    final String GAME_NAME = "Java Words Game";
    final String SEPARATOR =
        "----------------------------------------------------";

    private String newLine() {
        return NEW_LINE;
    }

    private String newLine(String message) {
        return NEW_LINE + message;
    }

    private String wrapMessage(String rawMessage) {
        String message = SEPARATOR;
        message += newLine(rawMessage);
        message += newLine(SEPARATOR);
        return message;
    }

    public void displayWelcome() {
        Logger.message(wrapMessage("Welcome to " + GAME_NAME));
    }

    public void displayRules() {
        String message = "";
        message += "Rule to award points";
        message +=
            newLine(
                "The player receives the same amount " +
                "of points as the number of duplicated vowels"
            );
        message += newLine("EX:");
        message += newLine();
        message += newLine("“moon” – 2 points");
        message += newLine("“cheerleader” – 4 points");
        message += newLine("“answer” – 0 points");
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
        message += newLine("a) YES - press 1");
        message += newLine("b) NO - press 2");
        message += newLine();
        Logger.prompt(message);
    }

    public void displayPromptNextWord(String playerName, char nextLetter) {
        String message =
            playerName +
            ": Please input a valid English word which start with the letter << " +
            nextLetter +
            " >>";
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

        String message = "Game number " + gameCounter;
        message += newLine("The winner is: " + winner.name);
        message += newLine("Total score  :" + winner.score);
        message += newLine();
        message += newLine("The winner is: " + looser.name);
        message += newLine("Total score  :" + looser.score);
        message += newLine();
        Logger.info(message);
    }
}
