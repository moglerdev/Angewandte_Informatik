// IntSum. java

import java.util.Scanner;

/**
* IntSum liest ganze Zahlen ein und gibt deren Summe aus.
* Beispielprogramm zur Programmiertechnik 1, Teil 2.
* @author Christopher Mogler
* @version 21.20.2021
*/
public final class IntSum {
    private IntSum() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
    * main ist der Startpunkt des Programms.
    * @param args wird nicht verwendet.
    */

    public static void main(String[] args) {
        int sum = 0;

        System.out.println("Ganze Zahlen eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNextInt()) {
            sum += EINGABE.nextInt();
        }

        System.out.printf("Summe: %d%n", sum);
    }
}