package aufgabe01;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(String w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
		Word w = null;
		for (int i = 0; i < fq.size(); ++i) {
			w = fq.get(i);
			this.add(w.getWord(), w.getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable fq) {
		fq.clear();
		if (this.size() < 1) {
			return;
		}

		int mostFrqz = this.get(0).getFrequency();

		for (int k = 0; k < this.size(); ++k) {
			Word w = this.get(k);
			if (w.getFrequency() == mostFrqz) {
				fq.add(w.getWord(), w.getFrequency());
			}
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable fq) {
		fq.clear();
		if (this.size() < 0) {
			return;
		}

		int leastFrgz = this.get(this.size() - 1).getFrequency();

		for (int k = 0; k < this.size(); ++k) {
			Word w = this.get(k);
			if (w.getFrequency() == leastFrgz) {
				fq.add(w.getWord(), w.getFrequency());
			}
		}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		// {ist:5, Test:5, das:3, ein:2, kurzer:1, Text:1, } size = 6
		StringBuilder s = new StringBuilder("");
		// Ihr Code:
		s.append('{');
		s.append(' ');
		Word w = null;
		for (int i = 0; i < this.size(); i++) {
			// die:2, das:1
			w = this.get(i);
			s.append(w.getWord());
			s.append(':');
			s.append(w.getFrequency());
			s.append(", ");
		}
		s.append("} size = " + this.size());
		return s.toString();
	}
}
