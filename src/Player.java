/**
 * This class reppresents the Player
 */
public class Player {
    public String name;
    public int score;
    public int numberOfLives;
    private String word;

    public Player(String name, int numberOfLives) {
        this.name = name;
        this.numberOfLives = numberOfLives;
    }

    public String getWord() {
        return word;
    }

    /**
     * This setter method is in charge to decrease the lives of the player
     * in case they inputed the special character to skip the  turn
     */
    public void setWord(String value) {
        if (value.equals("-")) numberOfLives--;
        this.word = value;
    }
}
