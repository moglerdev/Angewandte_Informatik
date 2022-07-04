// Rating.java
package aufgabe6;

/**
 * Leistung kapselt ein Fach mit Note als Entit&auml;t.
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public abstract class Rating {
    private final String subject;

    /**
     * initialisiert die Fachnote mit einem Namen.
     * <p>
     * Wirft eine Ausnahme <code>IllegalArgumentException</code>, wenn das Fach
     * laut {@link Subjects#isValid} nicht zul&auml;ssig ist.</p>
     * @param subject der Fachname
     */
    protected Rating(String subject) {
        if (!Subjects.isValid(subject)) {
            throw new IllegalArgumentException("unzulaessiges Fach " + subject);
        }

        this.subject = subject;
    }

    /**
     * liefert den Namen des Fachs.
     * @return den Fachnamen
     */
    public final String getSubject() {
        return this.subject;
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
    public String getGrade() {
        assert !isGraded() : this.getClass().getName()
                               + " muss getGrade() ueberschreiben";
        return "";
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
    public String getGradeInWords() {
        if (isPassed()) {
            return "bestanden";
        }

        return "nicht bestanden";
    }

    /**
     * fragt ab, ob das Fach bestanden ist.
     * Wenn {@link #isBestGrade} <code>true</code> zur&uuml;ckgibt,
     * h&auml;ngt es vom Notensystem der Unterklasse ab,
     * welche Noten als bestanden und welche als nicht bestanden gelten.
     * @return <code>true</code>, wenn bestanden, sonst <code>false</code>
     */
    public abstract boolean isPassed();

    /**
     * fragt ab, ob das Fach benotet oder unbenotet ist.
     * <p>
     * Darf nur <code>true</code> liefern, wenn die Methoden
     * {@link #getGrade} und {@link #getGradeInWords}
     * so &uuml;berschreiben sind, dass sie eine Note liefern.</p>
     * @return <code>true</code>, wenn benotet, sonst <code>false</code>
     */
    public abstract boolean isGraded();

    /**
     * fragt ab, ob das Fach bestnote ist.
     * @return <code>true</code>, wenn bestnote ist, sonst <code>false</code>
     */
    public abstract boolean isBestGrade();
}

