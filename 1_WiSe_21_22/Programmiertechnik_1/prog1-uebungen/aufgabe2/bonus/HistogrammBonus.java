// HistogrammBonus.java
package aufgabe2.bonus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HistogrammBonus liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author Christopher Mogler
 * @version 02.11.2021
 */
@SuppressWarnings("magicnumber")
public final class HistogrammBonus {
    private HistogrammBonus() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    private static final int MAX_LINE_LENGTH = 50;

    /**
     * Zeichnet das Histogramm Horizontal.
     * @param numbersMap Nummer Map, die ausgegeben werden soll.
     * @param n Die Sprünger einzelner Zahlen
     * @param maxSize die größte Länge einer Liste der numbersMap
     * @param minSize die kleinste Länge einer Liste der numbersMap
     * @param isCutting soll die Ausgabe zugeschnietten werden?
     */
    public static void drawHorizontal(Map<Integer, Integer[]>  numbersMap, int n, int maxSize, int minSize, boolean isCutting) {
        for (int o = 1; o < 7; ++o) {
            Integer[] oA = numbersMap.get(o);

            if (oA != null) {
                for (int num = (isCutting ? minSize - 1 : 0); num < oA.length; num += n) {
                    System.out.printf("%d", oA[num]);
                }

                System.out.printf(" (%d)%n", oA.length);
            }
        }
    }

    /**
     * Zeichnet das Histogramm Vertikal.
     * @param numbersMap Nummer Map, die ausgegeben werden soll.
     * @param n Die Sprünger einzelner Zahlen
     * @param maxSize die größte Länge einer Liste der numbersMap
     * @param minSize die kleinste Länge einer Liste der numbersMap
     * @param isCutting ob der Wert gecuttet werden soll
     */
    public static void drawVertical(Map<Integer, Integer[]>  numbersMap, int n, int maxSize, int minSize, boolean isCutting) {

        for (int i = (isCutting ? minSize - 1 : 0); i < maxSize; i = i + n) {

            for (Map.Entry<Integer, Integer[]> entry : numbersMap.entrySet()) {
                Integer[] numbers = entry.getValue();

                if (numbers.length > i) {
                    System.out.printf("%d \t", numbers[i]);
                } else {
                    System.out.printf("\t");
                }
            }

            System.out.printf("(%d)%n", i + 1);
        }
    }

    /**
     * Zeichnet das Histogramm.
     * @param numbers für die Ausgabe
     * @param isVertical Soll es Vertikal gezeichnet werden, anstatt Horizontal
     * @param isCutting Soll es gekürzt werden
     */
    public static void drawHistogramm(ArrayList<Integer> numbers, boolean isVertical, boolean isCutting) {
        Map<Integer, Integer[]> outMap = new HashMap<Integer, Integer[]>();
        ArrayList<Integer> outNrList = new ArrayList<Integer>();

        Integer[] outTmpNrList;
        int maxSize = 0;
        int minSize = numbers.size();

        for (int i = 1; i < 7; ++i) {
            outNrList.clear();

            for (int k = 0; k < numbers.size(); ++k) {
                int nr = numbers.get(k);
                if (nr == i) {
                    outNrList.add(nr);
                }
            }

            if (maxSize < outNrList.size()) {
                maxSize = outNrList.size();
            }
            if (minSize > outNrList.size()) {
                minSize = outNrList.size();
            }

            if (outNrList.size() > 0) {
                outTmpNrList = new Integer[outNrList.size()];
                outNrList.toArray(outTmpNrList);
                outMap.put(i, outTmpNrList);
            }
        }

        int n = maxSize / MAX_LINE_LENGTH + 1;

        System.out.printf("Histrogramm: %d %n", maxSize);

        if (isVertical) {
            drawVertical(outMap, n, maxSize, minSize, isCutting);
        } else {
            drawHorizontal(outMap, n, maxSize, minSize, isCutting);
        }
    }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {

        boolean isCutting = false;
        boolean isVertical = false;

        for (String arg : args) {
            if (arg.equals("-CUT")) { 
                isCutting = true;
            }
            if (arg.equals("-VERTICAL")) {
                isVertical = true;
            }
        }

        /* (1) hier ein Feld von Zaehlern definieren */
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //---------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D/Strg-Z):");

        while (EINGABE.hasNextInt()) {
            int number = EINGABE.nextInt();

            /* (2) hier Anweisungen fuer das
                         Pruefen und Zaehlen der Eingabe schreiben */

            if (number < 1 || number > 7) {
                System.out.printf("Falsche Eingabe wird ingoriert: %s%n", number);
            } else {
                numbers.add(number);
            }
        }

        //------------------------------------------------ Histogramm ausgeben

        /* (3) hier Anweisungen fuer die Histogrammausgabe schreiben */
        drawHistogramm(numbers, isVertical, isCutting);
    }
}

