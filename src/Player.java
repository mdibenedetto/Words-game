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

    public void setWord(String value) {
        if (value.equals("-")) numberOfLives--;
        this.word = value;
    }
}
