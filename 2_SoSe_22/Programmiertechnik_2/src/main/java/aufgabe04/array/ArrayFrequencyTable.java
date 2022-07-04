package aufgabe04.array;

import aufgabe04.AbstractFrequencyTable;
import aufgabe04.Element;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
	private int size;
	Element<T>[] fqTable;
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
		this.fqTable = new Element[this.DEFAULT_SIZE];
	}

	@Override
	public void add(T value, int f) {
		this.isSorted = false;
		Element<T> toTest = new Element<T>(value, f);
		if (this.size() + 1 >= fqTable.length) {
			Element[] tmp = fqTable.clone();
			fqTable = new Element[this.DEFAULT_SIZE + tmp.length];
			for (int i = 0; i < tmp.length; i++) {
				this.fqTable[i] = tmp[i];
			}
		}
		boolean toAdd = true;
		for (Element<T> element: this) {
			if (element.getValue().equals(toTest.getValue())) {
				element.addFrequency(f);
				toAdd = false;
				toTest = element;
				break;
			}
		}
		for (int i = 0; i < this.size(); ++i) {
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
				Element temp = null;
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
	public Element get(int pos) throws IndexOutOfBoundsException {
		if(pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		if (this.isSorted == false) this.sort();
		return this.fqTable[pos];
	}

	@Override
	public int get(T value) {
		if (this.isSorted == false) this.sort();
		for (Element element : this) {
			if (element.getValue().equals(value)) {
				return element.getFrequency();
			}
		}
		return 0;
	}

	@Override
	public Iterator<Element<T>> iterator() {
		return new ArrayTableIterator<>(this);
	}
}
