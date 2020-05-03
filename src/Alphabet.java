import java.util.Random;

/**
 * This class handle the entire English Alphabet
 */
public class Alphabet {
    char[] letters = {
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z'
    };

    /**
     * This method return a random letter to be used to play the game
     */
    public char findRandomLetter() {
        int index = findRandomIndex();
        char letter = letters[index];
        return letter;
    }

    /**
     * This method return a random index into the range of the English Alphabet array
     */
    private int findRandomIndex() {
        int low = 0, high = letters.length - 1;
        int randomIndex;

        Random rnd = new Random();
        randomIndex = rnd.nextInt(high) + low;

        return randomIndex;
    }
}
