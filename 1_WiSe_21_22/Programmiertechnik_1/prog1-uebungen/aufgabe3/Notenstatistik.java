// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * <code>Ganze,Zehntel</code> oder <code>Ganze.Zehntel</code>,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author Christopher Mogler
 * @version 23.11.2021
 */
public final class Notenstatistik {
    private Notenstatistik() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * Write Message like System.out.printf.
     * @param msg the Format-String for the output
     * @param objects the parameters for the Format-String
     */
    public static void write(String msg, Object... objects) {
        System.out.printf(msg, objects);
    }

    /**
     * Evaluate Input from User and try to parse it to a Note.
     * @return Note as Integer, to get the write Note you have to divide it with 10
     */
    public static int evalInput() {

        String stringNote = EINGABE.next();

        //---------------------------------------------- Eingabe pruefen

        /* (1) die Zeichen im String note pruefen ... */
        String[] splitNote = stringNote.split("[.,]"); 
        if (splitNote.length < 2 || splitNote[1].length() > 1) {
            write("Note %s wird wegen Formatfehler ignoriert!%n", stringNote);
            return -1;
        }

        int vorkommaNote = 0;
        int nachkommaNote = 0;

        try {
            vorkommaNote = Integer.parseInt(splitNote[0]);
            nachkommaNote = Integer.parseInt(splitNote[1]);
        } catch (NumberFormatException e) {
            write("Note %s wird wegen Formatfehler ignoriert!%n", stringNote);
            return -1;
        }

        if (vorkommaNote < 1 || vorkommaNote > 5) {
            write("Note %s wird wegen Vorkommastelle %s ignoriert!%n", stringNote, vorkommaNote);
            return -1;
        }

        if ((nachkommaNote != 7 && nachkommaNote != 3 && nachkommaNote != 0) || (nachkommaNote != 0 && vorkommaNote > 3)) {
            write("Note %s wird wegen Nachkommastelle %s ignoriert!%n", stringNote, nachkommaNote);
            return -1;
        }

        //------------------------------------------------ Note erfassen

        /* (2) Notensumme Bestandene, Anzahl Bestandene,
                     Anzahl Durchgefallene sowie
                     beste und schlechteste Note aktualisieren ... */

        return (vorkommaNote * 10) + nachkommaNote;
    }

    /**
     * Handle the Input from use, till the User press Cntrl. + D.
     */
    public static void handleInput() {

        int cntNoten = 0;
        int cntProofedNoten = 0;
        int bestNote = 50;
        int badestNote = 10;
        double durchschnittProofedNote = 0.0;
        double durchfallqoute = 0.0;


        while (EINGABE.hasNext()) {
            int note = evalInput();

            if (note != -1) {
                ++cntNoten;

                if (badestNote < note) {
                    badestNote = note;
                }
                if (bestNote > note) {
                    bestNote = note;
                }
                if (note < 50) {
                    ++cntProofedNoten;
                    durchschnittProofedNote += note;
                }
            }
        } // while


        durchfallqoute = (double) (cntNoten - cntProofedNoten) / (double) cntNoten * 100;
        durchschnittProofedNote = durchschnittProofedNote / cntProofedNoten;

        //------------------------------------------ Notenstatistik ausgeben

        /* (3) Durchschnitt und Durchfallquote berechnen
                     und dann die gesamte Statistik ausgeben ... */

        write("%nAnzahl beruecksichtigter Noten: %s%n", cntNoten);
        write("Anzahl Bestandene: %s%n", cntProofedNoten);

        if (cntProofedNoten > 0) {
            write("Beste Note: %.1f%n", (double) bestNote / 10.0);
            write("Schlechteste Note: %.1f%n", (double) badestNote / 10.0);
            write("Durchschnitt Bestandene: %.1f%n", (double) durchschnittProofedNote / 10.0);
            write("Durchfallquote: %.1f%%%n", durchfallqoute);
        }
    }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        handleInput();
    } // main
}

