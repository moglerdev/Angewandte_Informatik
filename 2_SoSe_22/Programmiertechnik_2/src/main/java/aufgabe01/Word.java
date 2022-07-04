package aufgabe01;

import java.util.Objects;

/**
 * Klasse für Wörter mit ihren Häufigkeiten.
 * @author oliverbittel
 * @since 22.3.2019
 */
public class Word {
	final private String word;
	private int freqency;
	
	/**
	 * Konstruktor.
	 * @param word Wort
	 * @param f H&auml;ufgkeit
	 */
	public Word(String word, int f) {
		this.word = word;
		this.freqency = f;
	}

	/**
	 * Liefert Wort zur&uuml;ck.
	 * @return Wort
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Liefert H&auml;ufgkeit zur&uuml;ck.
	 * @return H&auml;ufgkeit
	 */
	public int getFrequency() {
		return freqency;
	}
	
	/**
	 * Addiert zur H&auml;ufgkeit f dazu.
	 * @param f H&auml;ufgkeits&auml;nderung.
	 */
	public void addFrequency(int f) {
		freqency += f;
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		return word + ":" + freqency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Word word1 = (Word) o;
		return Objects.equals(word, word1.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
}
