// Klausurergebnis.java
package aufgabe4;
import aufgabe4.switzerland.Grades;
import java.util.Locale;
import java.util.Scanner;

/**
 * Klausurergebnis erstellt eine Notenstatistik.
 * <p>
 * Das Programm liest Noten als Strings ein und bestimmt die beste und
 * die schlechteste Note, den Durchschnitt der Bestandenen sowie
 * die Durchfallquote in Prozent.
 * Das Programm ber&uuml;cksichtigt dabei nur die laut Noten.istZulaessig
 * erlaubten Noten. Andere Noten werden unter Ausgabe einer Warnung ignoriert.
 * Welche Noten besser und schlechter sind, welche als bestanden oder
 * durchgefallen gelten und wie die String-Darstellung der Noten aussieht,
 * wird mit Methoden der Klasse Noten bestimmt.
 * </p>
 * Das Programm gibt als Klausurergebnis folgende Werte aus:
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote</li>
 * </ul>
 *
 * @author Christopher Mogler
 * @version 02.12.2021
 */
public final class Klausurergebnis {
    private Klausurergebnis() { }

    /** Beste Note. */
    private static double bestGrade = Grades.SCHLECHTESTE;
    /** Schlechteste Note. */
    private static double worstGrade = Grades.BESTE;

    /** Anzahl aller korekten Noten. */
    private static int countGrades = 0;
    /** Anzahl aller bestandenen Noten. */
    private static int countPassed = 0;

    /** Die Summe aller Noten, für den Durchschnitt. */
    private static double sumOfPassedGrades = 0.0;

    /**
     * Gibt die Anzahl der Noten zurück.
     * @return anzahl der Noten
     */
    public static int getCountOfGrades() {
        return countGrades;
    }

    /**
     * Gibt die Anzahl aller Bestandenen zurück.
     * @return anzahl der Bestandnenen
     */
    public static int getCountOfPassed() {
        return countPassed;
    }

    /**
     * Füge eine Noten hinzu für die Berechnung.
     * @param grade die Note als Double
     */
    public static void addGrade(double grade) {
        countGrades++;
        if (Grades.isPassed(grade)) {
            countPassed++;
            sumOfPassedGrades += grade;
        }

        bestGrade = Grades.isBetter(grade, bestGrade);
        worstGrade = Grades.isWorse(grade, worstGrade);
    }

    /**
     * Berechnet den Durchschnitt der Bestandenen und gibt diese zurück.
     * @return durchschnitts Note der Bestandenen
     */
    public static double getAverageOfPassed() {
        return sumOfPassedGrades / countPassed;
    }

    /**
     * Berechnet die Durchfallquote und gibt diese zurück.
     * @return durchfallquote
     */
    @SuppressWarnings("magicnumber")
    public static double getFailureRate() {
        return (double) (countGrades - countPassed) / (double) countGrades * 100;
    }

    /**
     * gibt die beste Note zurück.
     * @return beste Note als double (min. 1.0)
     */
    public static double getBestGrade() {
        return bestGrade;
    }

    /**
     * gibt die schlechteste Note zurück.
     * @return schlechteste Note als double (max. 5.0)
     */
    public static double getWorstGrade() {
        return worstGrade;
    }

    /** Gibt alle Werte in die Console an. */
    public static void printInformation() {
        System.out.printf("%nAnzahl beruecksichtigter Noten: %s%n", Klausurergebnis.getCountOfGrades());
        System.out.printf("Anzahl Bestandene: %s%n", Klausurergebnis.getCountOfPassed());

        if (Klausurergebnis.getCountOfPassed() > 0) {
            System.out.printf("Beste Note: %s%n", Grades.toString(bestGrade));
            System.out.printf("Schlechteste Note: %s%n", Grades.toString(worstGrade));
            System.out.printf("Durchschnitt Bestandene: %s%n", Grades.toString(getAverageOfPassed()));
            System.out.printf("Durchfallquote: %.1f%%%n", Klausurergebnis.getFailureRate());
        }
    }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);

        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            String strGrade = EINGABE.next();

            //---------------------------------------------- Eingabe pruefen

            /* (1) note pruefen ... */

            if (!Grades.isCorrect(strGrade)) {
                System.out.printf("Unzulaessige Note %s wird ignoriert!%n", strGrade);
                continue;
            }

            //------------------------------------------------ Note erfassen

            /* (2) Notensumme Bestandene, Anzahl Bestandene,
                         Anzahl Durchgefallene sowie
                         beste und schlechteste Note aktualisieren ...
            */

            double grade = Grades.toDouble(strGrade);

            Klausurergebnis.addGrade(grade);

        } // while

        //------------------------------------------ Notenstatistik ausgeben

        /* (3) Durchschnitt und Durchfallquote berechnen
                     und dann die gesamte Statistik ausgeben ...
        */

        Klausurergebnis.printInformation();

    } // main
}

