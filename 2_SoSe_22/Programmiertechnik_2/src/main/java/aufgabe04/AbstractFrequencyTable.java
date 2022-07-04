package aufgabe04;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(T element) {
        add(element, 1);
    }

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
		Element<T> element = null;
		for (int i = 0; i < fq.size(); ++i) {
			element = fq.get(i);
			this.add(element.getValue(), element.getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable<? super T> fq) {
		fq.clear();
		if (this.size() < 1) {
			return;
		}

		int mostFrqz = this.get(0).getFrequency();

		for (Element<T> element: this) {
			if (element.getFrequency() == mostFrqz) {
				fq.add(element.getValue(), element.getFrequency());
			}
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable<? super T> fq) {
		fq.clear();
		if (this.size() < 0) {
			return;
		}

		int leastFrgz = this.get(this.size() - 1).getFrequency();

		for (Element<T> element: this) {
			if (element.getFrequency() == leastFrgz) {
				fq.add(element.getValue(), element.getFrequency());
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
		Element w = null;
		for (int i = 0; i < this.size(); i++) {
			// die:2, das:1
			w = this.get(i);
			s.append(w.getValue());
			s.append(':');
			s.append(w.getFrequency());
			s.append(", ");
		}
		s.append("} size = " + this.size());
		return s.toString();
	}
}
