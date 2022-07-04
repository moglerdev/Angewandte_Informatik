// IntVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Christopher Mogler
 * @version 19.10.2021
 */
public final class IntVar {
    private IntVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        int min = 0x80000000;
        int max = 0x7fffffff;

        /* Eingabeaufforderung ausgeben */
        System.out.printf("Zwei ganze Zahlen zwischen %s und %s eingeben%n",
            min, max);

        /* zwei ganze Zahlen einlesen */
        int firstInt = EINGABE.nextInt();
        int secondInt = EINGABE.nextInt();

        /* die beiden Zahlen dezimal, okatal und hexadezimal ausgeben */
        System.out.printf("%s ist oktal %o und hexadezimal %x%n",
            firstInt, firstInt, firstInt);
        System.out.printf("%s ist oktal %o und hexadezimal %x%n",
            secondInt, secondInt, secondInt);

        /* alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.printf("%s + %s ist %s%n",
            firstInt, secondInt, firstInt + secondInt);
        System.out.printf("%s - %s ist %s%n",
            firstInt, secondInt, firstInt - secondInt);
        System.out.printf("%s * %s ist %s%n",
            firstInt, secondInt, firstInt * secondInt);
        System.out.printf("%s / %s ist %s%n",
            firstInt, secondInt, firstInt / secondInt);
        System.out.printf("%s %% %s ist %s%n",
            firstInt, secondInt, firstInt % secondInt);

        /* alle Vergleichsoperatoren ausprobieren */
        System.out.printf("%s == %s ist %b%n",
            firstInt, secondInt, firstInt == secondInt);
        System.out.printf("%s != %s ist %b%n",
            firstInt, secondInt, firstInt != secondInt);
        System.out.printf("%s < %s ist %b%n",
            firstInt, secondInt, firstInt < secondInt);
        System.out.printf("%s <= %s ist %b%n",
            firstInt, secondInt, firstInt <= secondInt);
        System.out.printf("%s > %s ist %b%n",
            firstInt, secondInt, firstInt > secondInt);
        System.out.printf("%s >= %s ist %b%n",
            firstInt, secondInt, firstInt >= secondInt);
    }
}

