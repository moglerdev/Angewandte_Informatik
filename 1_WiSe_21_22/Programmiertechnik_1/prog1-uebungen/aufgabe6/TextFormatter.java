package aufgabe6;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ist dafür zuständig das Ergebnis in eine TXT Datei zuschreiben.
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public final class TextFormatter {
    private TextFormatter() { }

    /**
     * Schreibt den formatierten TXT String in die
     * referenzierte <code>output</code> variable.
     * @param output PrintWriter wird benötigt für den output
     * @param name Der Name des Studenten
     * @param ratingList die Leistungen des Studenten
     * @throws IOException sollte die Datei nicht erstellt werden können
     */
    public static void write(
        PrintWriter output,
        String[] name,
        RatingList ratingList)
        throws IOException {
        String placeholder = new String(
            new char[Subjects.getMaxLengthOfSubject()])
                .replace('\0', ' ');

        String tableRatingList = "Notenspiegel für " + String.join(" ", name)
            + "\r\nFach" + placeholder + "Art\t\tNote";
        tableRatingList += "\r\n" + new String(
            new char[tableRatingList.length()])
                .replace('\0', '-') + "\r\n" + "\r\n";

        String type = "";
        String grade = "";

        final int bufferLength = 4;

        for (Rating rating : ratingList) {
            placeholder = new String(
                new char[bufferLength + Subjects.getMaxLengthOfSubject()
                    - rating.getSubject().length()]).replace('\0', ' ');
            grade = rating.getGradeInWords();



            if (rating.isGraded()) {
                type = "L";
                grade += " (" + rating.getGrade() + ")";
            } else {
                type = "S";
            }
            tableRatingList += rating.getSubject()
                + placeholder + type
                + "\t\t" + grade + "\r\n";
        }

        output.write(tableRatingList);
    }
}
