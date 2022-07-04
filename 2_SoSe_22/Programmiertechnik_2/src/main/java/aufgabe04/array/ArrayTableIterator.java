package aufgabe04.array;

import aufgabe04.Element;

import java.util.Iterator;

public class ArrayTableIterator<T> implements Iterator<Element<T>> {

    int pos = 0;
    ArrayFrequencyTable<T> table;

    ArrayTableIterator(ArrayFrequencyTable<T> table) {
        this.table = table;
    }

    @Override
    public boolean hasNext() {
        return this.pos < this.table.size();
    }

    @Override
    public Element<T> next() {
        return this.table.fqTable[this.pos++];
    }
}
