public class Player {
    public String name;
    public int score;
    public int numberOfLives;
    public String word;

    public Player(String name, int numberOfLives) {
        this.name = name;
        this.numberOfLives = numberOfLives;
    }

    public void setWord(String value) {
        this.word = value;
    }
}
