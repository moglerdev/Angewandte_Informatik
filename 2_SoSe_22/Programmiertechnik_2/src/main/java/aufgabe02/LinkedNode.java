package aufgabe02;

/**
 * @author Christopher Mogler
 * @since 30.03.2022
 * @param <T> Generic for Node
 */
public class LinkedNode<T> {
    T data;
    LinkedNode<T> next;
    LinkedNode<T> prev;

    public LinkedNode(T data, LinkedNode<T> next, LinkedNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public LinkedNode<T> insertBefore(T before) {
        var t = new LinkedNode<>(before, this, this.prev);
        if (this.prev != null) {
            this.prev.next = t;
        }
        this.prev = t;
        return t;
    }

    public LinkedNode<T> insertAfter(T after) {
        var t = new LinkedNode<>(after, this.next, this);
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

    public T getData() {
        return this.data;
    }

    public LinkedNode<T> getNext() {
        return this.next;
    }

    public LinkedNode<T> getPrev() {
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
