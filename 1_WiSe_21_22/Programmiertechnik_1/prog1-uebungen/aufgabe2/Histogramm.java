// Histogramm.java
package aufgabe2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author Christopher Mogler
 * @version 02.11.2021
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {

        /* (1) hier ein Feld von Zaehlern definieren */
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //---------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D/Strg-Z):");

        while (EINGABE.hasNextInt()) {
            int number = EINGABE.nextInt();

            /* (2) hier Anweisungen fuer das
                         Pruefen und Zaehlen der Eingabe schreiben */

            if (number < 1 || number > 7) {
                System.out.printf("Falsche Eingabe wird ingoriert: %s%n", number);
            } else {
                numbers.add(number);
            }
        }

        //------------------------------------------------ Histogramm ausgeben

        /* (3) hier Anweisungen fuer die Histogrammausgabe schreiben */
        System.out.println("Histrogramm:");
        for (int i = 1; i < 7; ++i) {
            int count = 0;

            for (int k = 0; k < numbers.size(); ++k) {
                int n = numbers.get(k);
                if (n == i) {
                    ++count;
                    if (count % 5 == 0) {
                        System.out.print("$");
                    } else {
                        System.out.printf("%s", n);
                    }
                }
            }
            if (count > 0) {
                System.out.printf(" (%s)%n", count);
            }
        }
    }
}

