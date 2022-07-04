package aufgabe6;


/**
 * Fächer.
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public final class Subjects {
    private Subjects() { }

    private static final String[] SUBJECTS = {
        "Programmiertechnik 1",
        "Softwaremodelierung",
        "Mathematik 1",
        "Digitaltechnik"
    };

    /**
     * Prüft ob das angegebene Fach an der HTWG AIN 1 existiert.
     * @param subject Fachname was geprüft werden soll
     * @return <code>true</code> wenn das Fach
     * gültig ist, <code>false</code> wenn nicht.
     */
    public static boolean isValid(String subject) {
        for (String s : SUBJECTS) {
            if (subject.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt die Anzahl an Buchstaben zurück von
     * dem Fach mit den meisten Buchstaben.
     * @return länge des größten Fachs, nach Buchstaben
     */
    public static int getMaxLengthOfSubject() {
        int result = 0;
        for (String s : SUBJECTS) {
            if (result < s.length()) {
                result = s.length();
            }
        }
        return result;
    }
}