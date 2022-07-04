package aufgabe6;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
 * Ist dafür zuständig das Ergebnis in eine HTML Datei zuschreiben.
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public final class HtmlFormatter {
    private HtmlFormatter() { }
    private static final String NOT_PASSED_CSS_CLASS
        = "not_passed";
    private static final String TEMPLATE_FILE
        = "aufgabe6/assets/template.min.html";

    /**
     * Schreibt den formatierten HTML String in die
     *  referenzierte <code>output</code> variable.
     * @param output PrintWriter wird benötigt für den output
     * @param name Der Name des Studenten
     * @param ratingList die Leistungen des Studenten
     * @throws IOException wenn Datei nicht gefunden wurde.
     */
    public static void write(
        PrintWriter output,
        String[] name,
        RatingList ratingList)
        throws IOException {

        String htmlRatingList = "";
        String type = "";
        String grade = "";

        File templateFile = new File(TEMPLATE_FILE);

        for (Rating rating : ratingList) {
            grade = rating.getGradeInWords();

            if (rating.isGraded()) {
                type = "S";
                grade += " (" + rating.getGrade() + ")";
            } else {
                type = "L";
            }
            htmlRatingList += "<tr"
                + " class='"
                + (!rating.isPassed() ? NOT_PASSED_CSS_CLASS : "")
                + "'>"
                + "<td>" + rating.getSubject() + "</td>"
                + "<td>" + type + "</td>"
                + "<td>" + grade + "</td></tr>";
        }

        Scanner r = new Scanner(templateFile);
        String data = r.nextLine()
            .replace("{{ name }}", String.join(" ", name))
            .replace("{{ ratingList }}", htmlRatingList);

        output.write(data);
        r.close();
    }
}
