/**
 * This class is one the core component of the game.
 * It is in charge to process the input of the user
 */
public class Game {
    private LimitedVocabulary vocabulary;
    private Player player1, player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        vocabulary = new LimitedVocabulary();
    }

    /**
     * This method compute and assign the user score
     */
    public void play() {
        player1.score += countDuplicatedVowels(player1.getWord());
        player2.score += countDuplicatedVowels(player2.getWord());
    }

    /**
     * This method  calcualte how many points the user gets
     *
     * based on the rule R4 - double vowels:
     * The player receives the same amount of points
     * as the number of duplicated vowels in the word
     * “moon” – 2 points
     * “cheerleader” – 4 points
     *  “answer” – 0 points
     */
    private int countDuplicatedVowels(String word) {
        int aCounter = 0;
        int eCounter = 0;
        int iCounter = 0;
        int oCounter = 0;
        int uCounter = 0;
        // counts how many times a vowel appears into the word
        for (int i = 0, len = word.length(); i < len; i++) {
            char letter = word.charAt(i);

            switch (letter) {
                case 'a':
                    aCounter++;
                    break;
                case 'e':
                    eCounter++;
                    break;
                case 'i':
                    iCounter++;
                    break;
                case 'o':
                    oCounter++;
                    break;
                case 'u':
                    uCounter++;
                    break;
            }
        }
        // create a temporary array which contains all counter variables
        int[] vowelsCounter = {
            aCounter,
            eCounter,
            iCounter,
            oCounter,
            uCounter
        };
        // Find the vowel which has more occurrences into the word
        int max = 0;
        for (int i = 0; i < 5; i++) {
            int current = vowelsCounter[i];
            max = Math.max(max, current);
        }
        // if the vowel has more then 1 ooccurrence,
        // it means it is duplicated then return the value,
        // otherwise returns 0
        return max > 1 ? max : 0;
    }

    /**
     * This method check if any of the player has run out all lives provided,
     * return a boolean to indicate if the game is over
     */
    public boolean isGameOver() {
        return player1.numberOfLives == 0 || player2.numberOfLives == 0;
    }

    /**
     * This method check if a player want to skip the turn based
     * on the rule to check if the input is "-"
     */
    public boolean isTurnSkipped(Player player) {
        final String EXIT_CHAR = "-";
        return player.getWord().equals(EXIT_CHAR);
    }

    /**
     * This method check the word inputed is
     * - is minimum of 3 characters
     * - is part of the valid word stored into the vocabulary
     */
    public boolean isValidWord(String word) {
        if (word.length() < 3) return false;
        if (!vocabulary.isValidWord(word)) return false;
        return true;
    }
}
