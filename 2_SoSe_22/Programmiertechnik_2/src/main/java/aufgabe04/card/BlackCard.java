package aufgabe04.card;

import java.util.Random;

public class BlackCard extends Card {

    public BlackCard(Suit suit, Rank rank) {
        if (!suit.equals(Suit.SPADES) && !suit.equals(Suit.CLUBS)) {
            throw new IllegalArgumentException();
        }
        this.suite = suit;
        this.rank = rank;
    }

    public BlackCard() {
        Random rand = new Random();

        int r = rand.nextInt(1);
        if (r < 1) {
            this.suite = Suit.SPADES;
        } else {
            this.suite = Suit.CLUBS;
        }
        this.rank = this.getRandomRank();
    }
}
