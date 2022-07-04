// KlausurArray.java

/**
 * KlausurArray gibt eine Punkteliste f&uuml;r Klausuraufgaben aus.
 * Verbesserte Version von Klausur.java mit einem Array statt vieler Variablen.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author Christopher Mogler
 * @version 03.11.2021
 */
public final class KlausurArray {
    private KlausurArray() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        int[] punkte = {12, 8, 10};

        for (int i = 0; i < punkte.length; ++i) {
            System.out.printf("Aufgabe %d: %d Punkte%n", i + 1, punkte[i]);
        }
    }
}