package aufgabe04.list;

import aufgabe04.Element;

/**
 * @author Christopher Mogler
 * @since 30.03.2022
 * @param <T> Generic for Node
 */
public class LinkedNodeElement<T> {
    Element<T> data;
    LinkedNodeElement<T> next;
    LinkedNodeElement<T> prev;

    public LinkedNodeElement(Element<T> data, LinkedNodeElement<T> next, LinkedNodeElement<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public LinkedNodeElement<T> insertBefore(Element<T> before) {
        var t = new LinkedNodeElement<>(before, this, this.prev);
        if (this.prev != null) {
            this.prev.next = t;
        }
        this.prev = t;
        return t;
    }

    public LinkedNodeElement<T> insertAfter(Element<T> after) {
        var t = new LinkedNodeElement<>(after, this.next, this);
        if (this.next != null) {
            this.next.prev = t;
        }
        this.next = t;
        return t;
    }

    public void switchWithNext() {
        var data = this.data;
        this.data = next.getData();
        this.next.data = data;
    }

    public void switchWithPrev() {
        var data = this.data;
        this.data = this.prev.data;
        this.prev.data = data;
    }

    public Element<T> getData() {
        return this.data;
    }

    public LinkedNodeElement<T> getNext() {
        return this.next;
    }

    public LinkedNodeElement<T> getPrev() {
        return this.prev;
    }

    public void remove() {
        this.next = null;
        this.prev = null;
        this.data = null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        s.append(data);
        if(next != null) {
            s.append(", " + next.data);
        }
        return s.toString();
    }
}
