package aufgabe04.card;

import java.util.Random;

public abstract class Card implements Comparable<Card> {
    public enum Suit {
        CLUBS,
        HEARTS,
        SPADES,
        DIAMONDS
    }

    public enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        LADY,
        KING,
        ACE,
    }

    protected Suit suite;
    protected Rank rank;

    protected Rank getRandomRank() {
        Random rand = new Random();
        return switch (rand.nextInt(13)) {
            case 0 -> Rank.TWO;
            case 1 -> Rank.THREE;
            case 2 -> Rank.FOUR;
            case 3 -> Rank.FIVE;
            case 4 -> Rank.SIX;
            case 5 -> Rank.SEVEN;
            case 6 -> Rank.EIGHT;
            case 7 -> Rank.NINE;
            case 8 -> Rank.TEN;
            case 9 -> Rank.JACK;
            case 10 -> Rank.LADY;
            case 11 -> Rank.KING;
            default -> Rank.ACE;
        };
    }

    public Suit getSuite() {
        return suite;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Card) {
            return ((Card) obj).rank.equals(this.rank)
                    && ((Card) obj).suite.equals(this.suite);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "" + "[Suit: " +
                suite +
                " | Rank: " +
                rank +
                "]";
    }

    @Override
    public int compareTo(Card o) {
        if (this.suite.equals(o.suite)) {
            // wenn die Karten die gleiche Suite haben,
            //      Rank vergleichen
            return this.rank.compareTo(o.rank);
        }
        // wenn die Karten unterschiedliche Werte haben,
        //      Suite vergleichen
        return this.suite.compareTo(o.suite);
    }
}
