package aufgabe04.card;

import java.util.Random;

public class RedCard extends Card {
    public RedCard(Suit suit, Rank rank) {
        if (!suit.equals(Suit.HEARTS) && !suit.equals(Suit.DIAMONDS)) {
            throw new IllegalArgumentException();
        }
        this.suite = suit;
        this.rank = rank;
    }

    public RedCard() {
        Random rand = new Random();

        int r = rand.nextInt(1);
        if (r < 1) {
            this.suite = Suit.HEARTS;
        } else {
            this.suite = Suit.DIAMONDS;
        }
        this.rank = this.getRandomRank();
    }
}
