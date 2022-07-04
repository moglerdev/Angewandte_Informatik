package aufgabe04.list;

import aufgabe04.Element;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<Element<T>> {

    LinkedNodeElement<T> current;

    LinkedListIterator(LinkedListFrequency<T> table) {
        current = table.firstItem;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Element<T> next() {
        var res = current;
        current = current.next;
        return res.getData();
    }
}
