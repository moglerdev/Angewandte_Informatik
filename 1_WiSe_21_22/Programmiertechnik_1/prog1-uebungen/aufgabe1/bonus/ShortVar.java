package aufgabe1.bonus;

import java.util.Scanner;

/**
 * ShortVar zeigt den Umgang mit Variablen vom Typ short.
 * Bonusaufgabe 1  zur Programmiertechnik 1.
 * @author Christopher Mogler
 * @version 21.10.2021
 */
public final class ShortVar {
    private ShortVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        short min = -32768;
        short max = 32767;

        /* Eingabeaufforderung ausgeben */
        System.out.printf("Short zwischen %x und %x eingeben%n",
            min, max);

        /* zwei ganze Short einlesen */
        short firstShort = EINGABE.nextShort();
        short secondShort = EINGABE.nextShort();

        /* die beiden Zahlen dezimal, okatal und hexadezimal ausgeben */
        System.out.printf("%s ist oktal %o und hexadezimal %x%n",
            firstShort, firstShort, firstShort);
        System.out.printf("%s ist oktal %o und hexadezimal %x%n",
            secondShort, secondShort, secondShort);

        /* alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.printf("%s + %s ist %s%n",
            firstShort, secondShort, firstShort + secondShort);
        System.out.printf("%s - %s ist %s%n",
            firstShort, secondShort, firstShort - secondShort);
        System.out.printf("%s * %s ist %s%n",
            firstShort, secondShort, firstShort * secondShort);
        System.out.printf("%s / %s ist %s%n",
            firstShort, secondShort, firstShort / secondShort);
        System.out.printf("%s %% %s ist %s%n",
            firstShort, secondShort, firstShort % secondShort);

        /* alle Vergleichsoperatoren ausprobieren */
        System.out.printf("%s == %s ist %b%n",
            firstShort, secondShort, firstShort == secondShort);
        System.out.printf("%s != %s ist %b%n",
            firstShort, secondShort, firstShort != secondShort);
        System.out.printf("%s < %s ist %b%n",
            firstShort, secondShort, firstShort < secondShort);
        System.out.printf("%s <= %s ist %b%n",
            firstShort, secondShort, firstShort <= secondShort);
        System.out.printf("%s > %s ist %b%n",
            firstShort, secondShort, firstShort > secondShort);
        System.out.printf("%s >= %s ist %b%n",
            firstShort, secondShort, firstShort >= secondShort);
    }
}
