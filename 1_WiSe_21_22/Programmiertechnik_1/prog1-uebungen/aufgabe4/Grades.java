package aufgabe4;

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
@SuppressWarnings("magincnumber")
public final class Grades {
    /** Constructor. */
    private Grades() {
        super();
    }

    /** Beste mögliche Note. */
    public static final double BESTE = 1.0;

    /** Schlechteste mögliche Note. */
    public static final double SCHLECHTESTE = 5.0;

    /**
     * Prüft ob die Eingabe als Note an der HTWG zulässig ist.
     * @param grade die Note als String
     * @return wenn zulässig <code>true</code>;
     */
    public static boolean isCorrect(String grade) {
        boolean is4or5 = false;

        if (grade.length() != 3) {
            return false;
        }

        grade = grade.replace(',', '.');
        if (grade.charAt(1) != '.') {
            return false;
        }

        char pre = grade.charAt(0);
        char sub = grade.charAt(2);

        if (!(Character.isDigit(pre) || Character.isDigit(sub))) {
            return false;
        }

        switch (pre) {
        case '1':
        case '2':
        case '3':
            break;
        case '4':
        case '5':
            is4or5 = true;
            break;
        default:
            return false;
        }

        switch (sub) {
        case '0':
            break;
        case '3':
        case '7':
            if (is4or5) {
                return false;
            }
            break;
        default:
            return false;
        }

        return true;
    }

    /**
     * Konvertiert die Note als String zu einem Double-Typ um.
     * @param grade true = 1.0 | 1.3 | 1.7 | 2.0 | 2.3 | 2.7 | 3.0 | 3.3 | 3.7 | 4.0 | 5.0
     * @return Konvertiert die Eingabe der Note
     */
    public static double toDouble(String grade) {
        if (!Grades.isCorrect(grade)) {
            throw new IllegalArgumentException();
        }

        grade = grade.replace(',', '.');

        return Double.parseDouble(grade);
    }

    /**
     * Wandelt den Double-Typ in einen String mit nur einer Nachkommastelle.
     * @param grade Note als double
     * @return Note als String
     */
    public static String toString(double grade) {
        if (grade > SCHLECHTESTE || grade < BESTE) {
            throw new IllegalArgumentException();
        }
        return String.format("%.1f", grade);
    }

    /**
     * Prüft ob die Note als Bestanden gilt.
     * @param grade die Note
     * @return gibt true zurück, wenn die die Note besser als 5.0 ist
     */
    public static boolean isPassed(double grade) {
        return grade < Grades.SCHLECHTESTE;
    }

    /**
     * Prüft ob die Note als Bestanden gilt.
     * @param toTest die Note zu testenden
     * @param curBetter die Note aktuell bessere
     * @return gibt true zurück, wenn die die Note besser als 5.0 ist
     */
    public static double isBetter(double toTest, double curBetter) {
        if (toTest < curBetter) {
            return toTest;
        }
        return curBetter;
    }

    /**
     * Prüft ob die Note als Bestanden gilt.
     * @param toTest die Note zu testenden
     * @param curWorse die Note aktuell schlechtere
     * @return gibt true zurück, wenn die die Note besser als 5.0 ist
     */
    public static double isWorse(double toTest, double curWorse) {
        if (toTest > curWorse) {
            return toTest;
        }
        return curWorse;
    }
}
