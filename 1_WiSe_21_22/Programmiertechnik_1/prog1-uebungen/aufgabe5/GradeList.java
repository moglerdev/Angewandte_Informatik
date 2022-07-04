package aufgabe5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Liste für Grade (Note). */
public final class GradeList implements Iterable<Grade> {
    private Element head = null;

    /**
     * Konstruktor für GradeList.
     * @param grades Anfangsbestand der Liste (wird sortiert).
     */
    public GradeList(Grade... grades) {
        this.insert(grades);
    }

    /**
     * fügt die Note der Liste hinzu (sortiert!).
     * @param grade neue Note
     * @return index der Note in der Liste
     */
    public int insert(Grade grade) {
        if (grade == null) {
            throw new IllegalArgumentException();
        }
        int cnt = 0;
        Element newEle = new Element(grade);
        if (this.head == null) {
            this.head = newEle;
            return cnt;
        } else {
            Element before = null;
            Element curr = this.head;

            while (curr != null) {
                int c = grade.compare(grade, curr.value);

                if (c <= 0) {
                    newEle.next = curr;
                    if (before != null) {
                        before.next = newEle;
                    } else {
                        this.head = newEle;
                    }

                    return cnt;
                } else {
                    before = curr;
                    curr = curr.next;
                }
                ++cnt;
            }
            before.next = newEle;
        }
        return cnt;
    }

    /**
     * ganzes Array hinzufügen (wird sortiert!).
     * @param grades Array von Noten
     */
    public void insert(Grade... grades) {
        if (grades != null && grades.length > 0) {
            for (Grade grade : grades) {
                this.insert(grade);
            }
        }
    }

    /**
     * gibt Note über index zurück.
     * @param index des Objekts
     * @return Objekt über index in der Liste
     */
    public Grade get(int index) {
        if (index > -1) {
            Element result = this.head;
            for (int i = 1; i < index; ++i) {
                if (result.next == null) {
                    throw new IndexOutOfBoundsException();
                }
                result = result.next;
            }

            return result.value;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * gibt die aktuelle Länge der Liste zurück.
     * @return länge als int
     */
    public int length() {
        Element ele = this.head;
        int result = 0;
        while (ele != null) {
            ++result;
            ele = ele.next;
        }
        return result;
    }

    /**
     * um diese Klasse Iterable zu machen (bspw. foreach)
     * @return GradeIterator
     */
    @Override()
    public Iterator<Grade> iterator() {
        return new GradeIterator(this);
    }

    /** GradeItator Klasse für Iterable (bspw. foreach). */
    public static final class GradeIterator implements Iterator<Grade> {
        private Element current = null;

        /**
         * Konstruktor mit zur iterierender Liste.
         * @param list aktuelle Liste
         */
        GradeIterator(GradeList list) {
            this.current = list.head;
        }

        /**
         * ob es ein nächstes Objekt in der Liste gibt.
         * @return true == ja
         */
        public boolean hasNext() {
            return this.current != null;
        }

        /**
         * nächstes Item von der Liste.
         * @return nänstes Item von der Liste
         */
        public Grade next() {
            if (this.hasNext()) {
                Element e = this.current;
                this.current = this.current.getNext();
                return e.getValue();
            }

            throw new NoSuchElementException();
        }

        /**
         * Löschen (UnsupportedOperationException!).
         * throws UnsupportedOperationException
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /** Element Klasse für die Liste. */
    private static final class Element {
        /** nächstes Item der Liste. */
        private Element next = null;
        /** Value (Grade) von dem Item in der Liste. */
        private Grade value = null;

        /**
         * Konstruktor für das Element.
         * @param value aktueller Wert
         */
        Element(Grade value) {
            this.value = value;
        }

        /**
         * gibt das Nächste Item der Liste zurück.
         * @return Element nächstes Item
         */
        public Element getNext() {
            return next;
        }

        /**
         * gibt aktuelle Value zurück.
         * @return value als Grade
         */
        public Grade getValue() {
            return value;
        }
    }
}