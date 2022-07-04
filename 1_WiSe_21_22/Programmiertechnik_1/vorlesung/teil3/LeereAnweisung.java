// LeereAnweisung.java

/**
 * LeereAnweisung zeigt Fehlerquelle durch leere Anweisung.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author Christopher Mogler
 * @version 03.11.2021
 */
public final class LeereAnweisung {
    private LeereAnweisung() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};

        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
    }
}