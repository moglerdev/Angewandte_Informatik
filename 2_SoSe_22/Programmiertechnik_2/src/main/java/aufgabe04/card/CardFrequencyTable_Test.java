package aufgabe04.card;

import aufgabe04.FrequencyTable;
import aufgabe04.array.ArrayFrequencyTable;

import java.util.Random;

/**
 *
 * @author oliverbittel
    public static void main(String[] args) {

        // set the scale of the coordinate system
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);

        // Draw line
        StdDraw.line(1, 1, 8, 8);

        // Draw square
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.01);
        StdDraw.square(3, 3, 2);

        // Draw filled Square
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(5, 8, 2);

        // Draw Circle
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        StdDraw.circle(5, 5, 2);

        // text
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(6, 1, "black text");
    }
 * @since 12.2.2020
 */
public class CardFrequencyTable_Test {

	public static void main(String[] args) {

		FrequencyTable<Card> cardTab1 = new ArrayFrequencyTable<>();
		FrequencyTable<Card> cardTab2 = new ArrayFrequencyTable<>();
		FrequencyTable<RedCard> redCardTab = new ArrayFrequencyTable<>();
		FrequencyTable<BlackCard> blackCardTab = new ArrayFrequencyTable<>();

		// Beachte:
		// Evtl. wird bei Ihnen die rite Karte "sieben Herz" anders definiert.
		redCardTab.add(new RedCard(Card.Suit.HEARTS, Card.Rank.SEVEN));	
		System.out.println(redCardTab.get(new RedCard(Card.Suit.HEARTS, Card.Rank.SEVEN))); // sollte die Häufigkeit 1 ergeben
		
		Random rand = new Random();
		for (int i = 0; i < 400; i++) {
			if (rand.nextInt() % 2 == 0) {
				RedCard c = new RedCard();
				cardTab1.add(c);
				redCardTab.add(c);
			} else {
				BlackCard c = new BlackCard();
				cardTab1.add(c);
				blackCardTab.add(c);
			}
		}

		System.out.println(cardTab1);
		System.out.println(redCardTab);
		System.out.println(blackCardTab);

		//redCardTab.addAll(cardTab1); // nicht OK
		cardTab1.addAll(redCardTab);
		redCardTab.addAll(redCardTab);
		System.out.println(redCardTab);
		cardTab1.collectMostFrequent(cardTab2);
		//scardTab1.collectMostFrequent(redCardTab); // nicht OK
		redCardTab.collectMostFrequent(cardTab1);
	}
}
