package aufgabe01;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
	private int size;
	private Word fqTable[];
	private final int DEFAULT_SIZE = 100;
	private boolean isSorted = false;

	public ArrayFrequencyTable() {
        clear();
    }
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		this.isSorted = false;
		this.size = 0;
		this.fqTable = new Word[this.DEFAULT_SIZE];
	}

	@Override
	public void add(String w, int f) {
		this.isSorted = false;
		Word word = null;
		Word toTest = new Word(w, f);
		if (this.size() + 1 >= fqTable.length) {
			Word[] tmp = fqTable.clone();
			fqTable = new Word[this.DEFAULT_SIZE + tmp.length];
			for (int i = 0; i < tmp.length; i++) {
				this.fqTable[i] = tmp[i];
			}
		}
		boolean toAdd = true;
		for (int i = 0; i < this.size(); ++i) {
			word = this.fqTable[i];
			if (word.getWord().equals(toTest.getWord())) {
				word.addFrequency(f);
				toAdd = false;
				toTest = word;
				break;
			}
		}
		if (toAdd) {
			this.fqTable[this.size()] = toTest;
			++this.size;
		}
	}

	private void sort() {
		for (int i = 0; i < this.size(); ++i) {
			// Inner nested loop pointing 1 index ahead
			for (int k = i + 1; k < this.size(); ++k) {
				// Checking elements
				Word temp = null;
				if (this.fqTable[k].getFrequency() >= this.fqTable[i].getFrequency()) {
					// Swapping
					temp = this.fqTable[i];
					this.fqTable[i] = this.fqTable[k];
					this.fqTable[k] = temp;
				}
			}
		}
		this.isSorted = true;
	}

	@Override
	public Word get(int pos) throws IndexOutOfBoundsException {
		if(pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		if (this.isSorted == false) this.sort();
		return this.fqTable[pos];
	}

	@Override
	public int get(String w) {
		if (this.isSorted == false) this.sort();
		Word word = null;
		for (int i = 0; i < this.size; ++i) {
			word = this.get(i);
			if (word.getWord().equals(w)) {
				return word.getFrequency();
			}
		}
		return 0;
	}
}
