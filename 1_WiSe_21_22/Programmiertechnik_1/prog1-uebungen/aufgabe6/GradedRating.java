package aufgabe6;

/**
 * Benotete Leistung.
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public final class GradedRating extends Rating {
    private final Grade grade;

    /**
     * initialisiert die Fachnote mit einem Namen.
     * <p>
     * Wirft eine Ausnahme <code>IllegalArgumentException</code>, wenn das Fach
     * laut {@link Subjects#isValid} nicht zul&auml;ssig ist.</p>
     * @param subject der Fachname
     * @param grade Note der Leistung
     */
    public GradedRating(String subject, String grade) {
        super(subject);

        this.grade = Grade.valueOf(grade);
    }

    /**
     * liefert die Note des Fachs in numerischer Schreibweise.
     * <p>
     * Wenn {@link #isBestGrade} <code>true</code> zur&uuml;ckgibt,
     * muss die Methode in der Unterklasse so &uuml;berschrieben werden,
     * dass sie die Note in numerischer Schreibweise liefert,
     * also Strings "1,0", "1,3" usw.
     * @return leerer String &quot;&quot;
     */
    @Override
    public String getGrade() {
        return grade.toString();
    }

    /**
     * liefert die Note des Fachs in Worten.
     * <p>
     * Wenn {@link #isBestGrade} <code>true</code> zur&uuml;ckgibt,
     * muss die Methode in der Unterklasse &uuml;berschrieben werden.
     * Der geliefert String h&auml;ngt dann davon ab,
     * welches Notensystem die Unterklasse verwendet.
     * @return "bestanden", wenn {@link #isPassed} true liefert,
     *         sonst "nicht bestanden".
     */
    @Override
    public String getGradeInWords() {
        int g = grade.intValue();
        if (g > 40) {
            return "nicht ausreichend";
        } else if (g > 36) {
            return "ausreichend";
        } else if (g > 26) {
            return "befriedigend";
        } else if (g > 16) {
            return "gut";
        } else {
            return "sehr gut";
        }
    }

    /**
     * fragt ab, ob das Fach bestanden ist.
     * Wenn {@link #isBestGrade} <code>true</code> zur&uuml;ckgibt,
     * h&auml;ngt es vom Notensystem der Unterklasse ab,
     * welche Noten als bestanden und welche als nicht bestanden gelten.
     * @return <code>true</code>, wenn bestanden, sonst <code>false</code>
     */
    @Override
    public boolean isPassed() {
        return grade.isPassed();
    }

    /**
     * fragt ab, ob das Fach benotet oder unbenotet ist.
     * <p>
     * Darf nur <code>true</code> liefern, wenn die Methoden
     * {@link #getGrade} und {@link #getGradeInWords}
     * so &uuml;berschreiben sind, dass sie eine Note liefern.</p>
     * @return <code>true</code>, wenn benotet, sonst <code>false</code>
     */
    @Override
    public boolean isGraded() {
        return true;
    }

    /**
     * fragt ab, ob das Fach bestnote ist.
     * @return <code>true</code>, wenn bestnote ist, sonst <code>false</code>
     */
    @Override
    public boolean isBestGrade() {
        return Grade.BEST == grade;
    }
}
