package aufgabe6;

import java.util.Comparator;

/** Grade ist die Klasse für die Noten. */
public final class Grade implements Comparator<Grade> {
    /**
     * Prüft ob String ein Integer ist.
     * @param s zu prüfender String
     * @return true == String ist ein Integer
    */
    public static boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), 10) < 0) {
                return false;
            }
        }
        return true;
    }

    /** Die Best möglichste Note. */
    public static final Grade BEST = new Grade(10);
    /** Die Schlechtest möglichste Note. */
    public static final Grade WORST = new Grade(50);
    /** Die Note die man benötigt um zu bestehen. */
    public static final Grade PASSED = new Grade(40);

    /**
     * Prüft ob die Eingabe als Note an der HTWG zulässig ist.
     * @param grade die Note als String
     * @return wenn zulässig<code>true</code>;
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
     * Prüft ob die Eingabe als Note an der HTWG zulässig ist.
     * @param grade die Note als int
     * @return wenn zulässig <code>true</code>;
     */
    public static boolean isCorrect(int grade) {
        if (BEST != null && WORST != null) {
            if (grade < BEST.intValue() || grade > WORST.intValue()) {
                return false;
            }
        }
        int pre = grade / 10;
        int sub = grade - (pre * 10);

        if (sub != 0 && sub != 3 && sub != 7) {
            return false;
        }

        if (pre > 3 && sub != 0) {
            return false;
        }

        return true;
    }

    /**
     * Konvertiert die Note als String zu einem Grade-Typ um.
     * @param grade true = 1.0 | 1.3 | 1.7 | 2.0
     *  | 2.3 | 2.7 | 3.0 | 3.3 | 3.7 | 4.0 | 5.0
     * @return Konvertiert die Eingabe der Note
     */
    public static Grade valueOf(String grade) {
        if (grade.isEmpty()) {
            throw new IllegalArgumentException("unzulaessige Note");
        }

        if (isInteger(grade)) {
            return valueOf(Integer.parseInt(grade));
        }

        if (!Grade.isCorrect(grade)) {
            throw new IllegalArgumentException("unzulaessige Note");
        }

        grade = grade.replace(',', '.');

        return valueOf(Double.parseDouble(grade));
    }

    /**
     * Konvertiert die Note als double zu einem Grade-Typ um.
     * @param grade double
     * @return Konvertiert die Eingabe der Note
     */
    public static Grade valueOf(double grade) {
        return valueOf((int) (grade * 10));
    }

    /**
     * Konvertiert die Note als int zu einem Grade-Typ um.
     * @param grade bspw. 10 = 1.0
     * @return Konvertiert die Eingabe der Note
     */
    public static Grade valueOf(int grade) {
        return new Grade(grade);
    }

    /**
     * Berechnet den Durchschnitt von zwei Noten.
     * @param firstGrade erste Note
     * @param secondGrade zweite Note
     * @return Grade mit dem Durchschnitt
     */
    public static Grade valueOf(Grade firstGrade, Grade secondGrade) {
        return new Grade((firstGrade.intValue() + secondGrade.intValue()) / 2);
    }

    /* END OF STATIC. */

    /* START OF INS. VARIABLES */
    private int gradeValue = 10;
    /* END OF INS. VARIABLES  */

    /* START OF CONSTRUCTORS */
    /**
     * Konstruktor für Grade.
     * @param grade prüft ob der Int als Note gültig ist
     */
    public Grade(int grade) {
        if (!isCorrect(grade)) {
            throw new IllegalArgumentException("unzulaessige Note");
        }
        this.gradeValue = grade;
    }
    /* END OF CONSTRUCTORS */

    /* START OF CLASS METHODS */
    /**
     * konvertiert die Note von Int zu double.
     * @return Note als double
     */
    public double toDouble() {
        return this.gradeValue / 10.0;
    }

    /**
     * ob Bestand.
     * @return bestanden == true
     */
    public boolean isPassed() {
        return PASSED.intValue() >= this.gradeValue;
    }

    /**
     * ob es die bestmöglichste Note ist.
     * @return bestmöglichste Note == true
     */
    public boolean isBest() {
        return BEST.intValue() == this.gradeValue;
    }

    /**
     * gibt die Note als Int zurück.
     * @return Note als Int
     */
    public int intValue() {
        return this.gradeValue;
    }

    /* START OF OVERRIDE */
    /**
     * Grade to String.
     * @return String der Note
     */
    @Override
    public String toString() {
        return String.format("%.1f", this.toDouble());
    }

    /**
     * Vergleicht zwei Note ob besser (-1), gleich (0) oder schlechter (1).
     * @param first vergleich
     * @param second zu vergleichen
     * @return (die erste Note ist) besser (-1),
     *  gleich (0), schlechter (1) (als die zweite)
     */
    @Override
    public int compare(Grade first, Grade second) {
        if (first.intValue() < second.intValue()) {
            return -1;
        } else if (first.intValue() > second.intValue()) {
            return 1;
        }
        return 0;
    }

    /**
     * Vergleicht ob die gleichen Wert besitzen (see Grade.hashCode).
     * @param toTest zu testende Objekt,
     *  es wird geprüft ob es ein Grade Typ ist.
     * @return ob die Objekte gleichen Typ und gleiche Werte besitzen
     */
    @Override
    public boolean equals(Object toTest) {
        if (toTest == null || toTest.getClass() != this.getClass()) {
            return false;
        }
        return ((Grade) toTest).hashCode() == this.hashCode();
    }

    /**
     * Rechnet einen HashCode über Note aus und gibt diesen als Int zurück.
     * @return Errechnete Hashcode über Subject und Note.
     */
    @Override
    public int hashCode() {
        return 31 * gradeValue;
    }
    /* END OF OVERRIDE */

    /* END OF CLASS METHODS */
}
