package aufgabe6;

/**
 * Unbenotete Leistung.
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public final class UngradedRating extends Rating {
    private final boolean passed;

    /**
     * initialisiert die Fachnote mit einem Namen.
     * <p>
     * Wirft eine Ausnahme <code>IllegalArgumentException</code>, wenn das Fach
     * laut {@link Subjects#isValid} nicht zul&auml;ssig ist.</p>
     * @param subject der Fachname
     * @param passed Wurde die Leistung bestanden
     *  <code>"BE"</code> wenn nicht <code>"NB"</code>
     */
    public UngradedRating(String subject, boolean passed) {
        super(subject);

        this.passed = passed;
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
        return this.passed;
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
        return false;
    }


    /**
     * fragt ab, ob das Fach bestnote ist.
     * @return <code>true</code>, wenn bestnote ist, sonst <code>false</code>
     */
    @Override
    public boolean isBestGrade() {
        return false;
    }
}
