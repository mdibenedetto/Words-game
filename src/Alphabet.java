import java.util.Random;

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

    public char findRandomLetter() {
        int index = findRandomIndex();
        char letter = letters[index];
        return letter;
    }

    private int findRandomIndex() {
        int low = 1, high = 26;
        int randomIndex;

        Random rnd = new Random();
        randomIndex = rnd.nextInt(high) + low;

        return randomIndex;
    }
}
