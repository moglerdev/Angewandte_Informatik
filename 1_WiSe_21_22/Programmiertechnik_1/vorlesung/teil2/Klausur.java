// Klausur.java

/**
 * Klausur gibt eine Punkteliste f&uuml;r Klausuraufgaben aus.
 * Bsp. zur Programmiertechnik 1, Teil 2.
 * @author Christopher Mogler
 * @version 03.11.2021
 */
public final class Klausur {
    private Klausur() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        int punkteAufgabe1 = 12;
        int punkteAufgabe2 = 8;
        int punkteAufgabe3 = 10;

        System.out.printf("Aufgabe 1: %d Punkte%n", punkteAufgabe1);
        System.out.printf("Aufgabe 2: %d Punkte%n", punkteAufgabe2);
        System.out.printf("Aufgabe 3: %d Punkte%n", punkteAufgabe3);
    }
}