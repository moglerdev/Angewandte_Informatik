// LeistungsListe.java
package aufgabe6;

import java.util.NoSuchElementException;

import java.util.Iterator;

/**
 * LeistungsListe kapselt eine Liste von Leistungen.
 * @author Christopher Mogler
 * @version 13.01.2022
 */
public final class RatingList implements Iterable<Rating> {
    private Element head = null;

    /**
     * Konstruktor für ratingList.
     * @param ratings Anfangsbestand der Liste (wird sortiert).
     */
    public RatingList(Rating... ratings) {
        for (Rating rating : ratings) {
            this.insert(rating);
        }
    }

    /**
     * fügt die Note der Liste hinzu (UNIQUE!).
     * @param rating neue Note
     * @return index der Note in der Liste
     */
    public Rating insert(Rating rating) {
        if (rating == null) {
            throw new IllegalArgumentException();
        }
        Rating deletetElement = null;
        Element newEle = new Element(rating);

        if (this.head == null) {
            this.head = newEle;
        } else {
            Element curr = this.head;
            while (true) {
                Rating test = curr.value;
                if (rating.isGraded()
                    && rating.getSubject().equals(test.getSubject())) {
                    deletetElement = curr.value;
                    curr.value = rating;
                    break;
                } else if (curr.next == null) {
                    curr.next = newEle;
                    curr = null;
                    break;
                }
                curr = curr.next;
            }
        }
        return deletetElement;
    }

    /**
     * ganzes Array hinzufügen (wird sortiert!).
     * @param ratings Array von Noten
     */
    public void insert(Rating... ratings) {
        if (ratings != null && ratings.length > 0) {
            for (Rating rating : ratings) {
                this.insert(rating);
            }
        }
    }

    /**
     * gibt Note über index zurück.
     * @param index des Objekts
     * @return Objekt über index in der Liste
     */
    public Rating get(int index) {
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
     * @return new NIterator
     */
    @Override()
    public Iterator<Rating> iterator() {
        return new NIterator(this);
    }

    /** ratingItator Klasse für Iterable (bspw. foreach). */
    public static final class NIterator implements Iterator<Rating> {
        private Element current = null;

        /**
         * Konstruktor mit zur iterierender Liste.
         * @param list aktuelle Liste
         */
        NIterator(RatingList list) {
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
        public Rating next() {
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
        /** Value (rating) von dem Item in der Liste. */
        private Rating value = null;

        /**
         * Konstruktor für das Element.
         * @param value aktueller Wert
         */
        Element(Rating value) {
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
         * @return value als rating
         */
        public Rating getValue() {
            return value;
        }
    }
}

