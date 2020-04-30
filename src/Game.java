public class Game {
    Player player1, player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        // updateNumberOfLives(player1);
        player1.score = countDuplicatedVowels(player1.getWord());

        // updateNumberOfLives(player2);
        player2.score = countDuplicatedVowels(player2.getWord());
    }

    public boolean hasSkippedTurn(Player player) {
        final String EXIT_CHAR = "-";
        return player.getWord().equals(EXIT_CHAR);
    }

    // private void updateNumberOfLives(Player player) {
    //     if (hasSkippedTurn(player)) {
    //         player.numberOfLives--;
    //     }
    // }

    private int countDuplicatedVowels(String word) {
        int aCounter = 0;
        int eCounter = 0;
        int iCounter = 0;
        int oCounter = 0;
        int uCounter = 0;

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

        int[] vowelsCounter = {
            aCounter,
            eCounter,
            iCounter,
            oCounter,
            uCounter
        };

        int max = 0;
        for (int i = 0; i < 5; i++) {
            int current = vowelsCounter[0];
            max = Math.max(max, current);
        }

        return max;
    }

    public boolean isGameOver() {
        return player1.numberOfLives == 0 || player2.numberOfLives == 0;
    }
}
