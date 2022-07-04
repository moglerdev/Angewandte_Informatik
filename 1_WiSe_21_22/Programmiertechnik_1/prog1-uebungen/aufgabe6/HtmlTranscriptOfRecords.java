// HtmlNotenspiegel.java
package aufgabe6;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Die Main-Klasse HtmlNotenspiegel liest die Namen von F&auml;chern
 * mit den zugeh&ouml;rigen Noten in eine verkettete Liste ein und
 * gibt dann einen Notenspiegel im HTML-Format aus.
 * Aufruf mit dem Namen der Studentin / des Studenten als Argument(e)
 * @author Christopher Mogler
 * @version 17.01.2022
 */
public final class HtmlTranscriptOfRecords {
    private HtmlTranscriptOfRecords() { }


    private static final String OUTPUT_PATH
        = "aufgabe6/output/";

    /**
     * liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Beurteilungen
     * ein und schreibt einen Notenspiegel als Datei im HTML-Format.
     * <p>
     * Jede Eingabezeile muss einen Fachnamen und eine Beurteilung enthalten.
     * Fachnamen m&uuml;ssen laut
     * {@link aufgabe6.Subjects#isValid} erlaubt sein.
     * Bei unbenoteten F&auml;chern muss die Beurteilung
     * <code>BE</code> f&uuml;r bestanden oder
     * <code>NB</code> f&uuml;r nicht bestanden lauten.
     * Bei benoteten F&auml;chern muss die Note laut
     * {@link aufgabe5.Grade#valueOf(java.lang.String, java.lang.String)}
     * erlaubt sein.
     * Der Dateinname des Notenspiegels wird aus den Argumenten gebildet.</p>
     * @param args Vorname(n) Nachname (mindestens zwei Argumente)
     * @throws IOException bei Einleseproblemen
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println(
                "Aufruf: java HtmlNotenspiegel Vorname(n) Nachname");
            System.exit(1);
        }

        RatingList ratingList = new RatingList();
        read(ratingList);
        write(args, ratingList);
    }

    /**
     * List die Leistungen über die Befehlszeile ein
     * und evaluiert sie und schreibt diese in die ref. Liste.
     * @param ratingList die referenzierte
     *  Leistungs-Liste die befüllt werden soll.
     * @throws IOException BufferedReader
     */
    private static void read(RatingList ratingList)
        throws IOException {

        System.err.println("Faecher mit Noten eingeben (Ende mit Strg-D):");
        BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = input.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) {
                continue; // Leerzeile
            }

            try {
                String[] words = line.split("\\s+");
                if (words.length < 2) {
                    throw new IllegalArgumentException(
                        "unvollstaendige Zeile " + line);
                }

                String grade = words[words.length - 1];
                String subject = line.substring(0, line.lastIndexOf(grade));

                Rating rating;
                if (grade.equals("BE")) {
                    rating = new UngradedRating(subject.trim(), true);
                } else if (grade.equals("NB")) {
                    rating = new UngradedRating(subject.trim(), false);
                } else {
                    rating = new GradedRating(subject.trim(), grade.trim());
                }

                Rating r = ratingList.insert(rating);
                if (r != null) {
                    System.out.printf(
                        "Warnung: Leistung %s wurde überschrieben."
                        + "(Doppelter Eintrag)%n",
                        r.getSubject());
                }
            } catch (IllegalArgumentException x) {
                System.err.printf("Falscheingabe ignoriert: %s%n",
                                  x.getMessage());
                continue;
            }
        }
    }

    /**
     * Schreibt die evaluierte Liste in eine HTML Datei.
     * @param name Vor- und Nachname als Array
     * @param ratingList Liste der Leistungen
     * @throws IOException Sollte eine Datei nicht gefunden werden.
     */
    private static void write(String[] name, RatingList ratingList)
        throws IOException {
        String outputFilename = OUTPUT_PATH + String.join("", name);

        try (
            PrintWriter htmlOutput
                = new PrintWriter(outputFilename + ".html", "UTF-8");
            PrintWriter txtOutput
                = new PrintWriter(outputFilename + ".txt", "UTF-8");
        ) {
            HtmlFormatter.write(htmlOutput, name, ratingList);
            TextFormatter.write(txtOutput, name, ratingList);
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: File not found: %s%n", e.getMessage());
        }
    }
}

