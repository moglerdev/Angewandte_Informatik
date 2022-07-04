// Notenspiegel.java
package aufgabe5;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Notenspiegel liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Noten
 * in eine verkettete Liste ein und gibt dann einen Notenspiegel aus.
 * @author Christopher Mogler
 * @version 17.12.2021
 */
public final class Notenspiegel {
    private Notenspiegel() { }

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Prüft ob String ein Integer ist.
     * @param s zu prüfender String
     * @return true == String ist ein Integer
     */
    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    /**
     * Prüft ob String ein Integer ist.
     * @param s zu prüfender String
     * @param radix the radix.
     * @return true == String ist ein Integer
     */
    public static boolean isInteger(String s, int radix) {
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
            if (Character.digit(s.charAt(i), radix) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        final GradeList gradeList = new GradeList(); // leere Liste

        //--------------------------------------------- Notenspiegel einlesen
        System.err.printf(
            "Faecher mit Noten zwischen %d und %d eingeben "
            + "(Ende mit Strg-D):%n",
            Grade.BEST.intValue(), Grade.WORST.intValue());

        int maxLenSubject = 0;

        while (SCANNER.hasNextLine()) {
            String input = SCANNER.nextLine();
            String subject = null;
            Grade grade = null;

            try {
                //------------------------------------ Fach und Note einlesen

                /* (1) erst das Fach mit next() einlesen,
                             dann mit hasNextInt() pruefen,
                             ob die Note als ganze Zahl vorliegt,
                             und die Note je nachdem mit nextInt()
                             oder next() einlesen und schliesslich
                             in ein Wertobjekt verpacken */

                String[] ins = input.split(" ");
                subject = ins[0];

                if (maxLenSubject < subject.length()) {
                    maxLenSubject = subject.length();
                }

                for (int i = 1; i < ins.length && i < 3; ++i) {
                    String gr = ins[i];
                    Grade g = null;
                    if (isInteger(gr)) {
                        g = Grade.valueOf(Integer.parseInt(gr), subject);
                    } else {
                        g = Grade.valueOf(gr, subject);
                    }
                    if (grade == null) {
                        grade = g;
                    } else {
                        grade = Grade.valueOf(grade, g);
                    }
                }

                //--------------------- neue Fachnote in Notenliste eintragen

                /* (2) ein neues Fachnote-Objekt erzeugen
                             und am Listenanfang einfuegen */
                gradeList.insert(grade);

            } catch (IllegalArgumentException x) {
                System.err.printf("Eingabefehler: %s%n", x.getMessage());
                continue;
            } catch (NoSuchElementException x) {
                System.err.println("Fach ohne Note ignoriert!");
                break;
            }
        }

        //--------------------------------------------- Notenspiegel ausgeben

        /* (3) tabellarischen Notenspiegel
                     mit der Ueberschrift NOTENSPIEGEL ausgeben */

        System.out.println("\nNOTENSPIEGEL");

        for (Grade grade : gradeList) {
            System.out.println(grade.debug(maxLenSubject));
        }

    } // main
}

