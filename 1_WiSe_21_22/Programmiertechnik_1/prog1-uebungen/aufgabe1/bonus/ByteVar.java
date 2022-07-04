// IntVar.java

package aufgabe1.bonus;

import java.util.Scanner;

/**
 * ByteVar zeigt den Umgang mit Variablen vom Typ byte.
 * Bonusaufgabe 1 zur Programmiertechnik 1.
 * @author Christopher Mogler
 * @version 19.10.2021
 */
public final class ByteVar {
    private ByteVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        byte min = 0x0;
        byte max = 0xF;

        /* Eingabeaufforderung ausgeben */
        System.out.printf("Byte zwischen %x und %x eingeben%n",
            min, max);

        /* zwei ganze Byte einlesen */
        byte firstByte = EINGABE.nextByte();
        byte secondByte = EINGABE.nextByte();

        /* die beiden Zahlen dezimal, okatal und hexadezimal ausgeben */
        System.out.printf("%s ist oktal %o und hexadezimal %x%n",
            firstByte, firstByte, firstByte);
        System.out.printf("%s ist oktal %o und hexadezimal %x%n",
            secondByte, secondByte, secondByte);

        /* alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.printf("%s + %s ist %s%n",
            firstByte, secondByte, firstByte + secondByte);
        System.out.printf("%s - %s ist %s%n",
            firstByte, secondByte, firstByte - secondByte);
        System.out.printf("%s * %s ist %s%n",
            firstByte, secondByte, firstByte * secondByte);
        System.out.printf("%s / %s ist %s%n",
            firstByte, secondByte, firstByte / secondByte);
        System.out.printf("%s %% %s ist %s%n",
            firstByte, secondByte, firstByte % secondByte);

        /* alle Vergleichsoperatoren ausprobieren */
        System.out.printf("%s == %s ist %b%n",
            firstByte, secondByte, firstByte == secondByte);
        System.out.printf("%s != %s ist %b%n",
            firstByte, secondByte, firstByte != secondByte);
        System.out.printf("%s < %s ist %b%n",
            firstByte, secondByte, firstByte < secondByte);
        System.out.printf("%s <= %s ist %b%n",
            firstByte, secondByte, firstByte <= secondByte);
        System.out.printf("%s > %s ist %b%n",
            firstByte, secondByte, firstByte > secondByte);
        System.out.printf("%s >= %s ist %b%n",
            firstByte, secondByte, firstByte >= secondByte);
    }
}

