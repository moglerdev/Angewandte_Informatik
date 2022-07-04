package aufgabe07;

import aufgabe04.card.BlackCard;
import aufgabe04.card.Card;
import aufgabe04.card.RedCard;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class QuickSort_Test {

    private static long timeBegin;
    private static void startTimer() {
        timeBegin = System.nanoTime();
    }

    private static void printElapsedTime() {
        long timeB = System.nanoTime();
        System.out.printf("Elapsed time: %.4fms%n", (timeB - timeBegin) / (1000.0 * 1000.0));
    }

    private static <T extends Comparable<T>> void runHybridQuicksort(T[] data, boolean withThreeMedian, T[] arraySortList) {
        System.out.printf("%s%n---------------------%n",
                withThreeMedian ? "Hybrides QuickSort mit 3-Median" : "Hybrides QuickSort");

        System.out.printf("%n%s zufällige Spielkarten%n", data.length);
        startTimer();
        QuickSort.quicksort(data, withThreeMedian);
        printElapsedTime();

        for (int i = arraySortList.length - 1; i > 0; --i) {
            if (!arraySortList[i].equals(data[i])) {
                System.out.println("FEHLER!");
                throw new RuntimeException();
            }
        }

        System.out.printf("%n%s sortierte Spielkarten%n", data.length);
        startTimer();
        QuickSort.quicksort(data, withThreeMedian);
        printElapsedTime();

        for (int i = arraySortList.length - 1; i > 0; --i) {
            if (!arraySortList[i].equals(data[i])) {
                System.out.println("FEHLER!");
                throw new RuntimeException();
            }
        }
    }

    private static <T extends Comparable<T>> void runArraySort(T[] data) {
        System.out.printf("Arrays.sort%n---------------------%n");
        System.out.printf("%n%s zufällige Spielkarten%n", data.length);
        startTimer();
        Arrays.sort(data);
        printElapsedTime();

        System.out.printf("%n%s sortierte Spielkarten%n", data.length);
        startTimer();
        Arrays.sort(data);
        printElapsedTime();
    }

    public static void main(String[] args) {
        try {
            testKafkaDerProzess();
        } catch (Exception e) {
            System.out.print(e);
        }

        /*
        System.out.println("\n-----------------------------------------------------------------------------\n100.000\n");
        testCards(100000);
        System.out.println("\n-----------------------------------------------------------------------------\n200.000\n");
        testCards(200000);
        */
    }


    private static void testCards(int max) {
        System.out.println("START Cards");
        Card[] cardList = new Card[max];

        Random rand = new Random();
        for (int i = 0; i < cardList.length; i++) {
            Card c;
            if (rand.nextInt() % 2 == 0) {
                c = new RedCard();
            } else {
                c = new BlackCard();
            }
            cardList[i] = c;
        }

        var tmp = cardList.clone();

        runArraySort(cardList);

        runHybridQuicksort(tmp, false, cardList);
        for(int i = tmp.length - 2; i > 0; --i) {
            if (tmp[i].compareTo(tmp[i + 1]) > 0) {
                System.out.println("\nFehler!");
                break;
            }
        }

        System.out.println();
        runHybridQuicksort(cardList.clone(), true, cardList);

        System.out.println("END Cards");
        System.out.println();
    }

    private static void testInteger(int max) {
        System.out.println("START Integer");
        Integer[] myArray = new Integer[max];
                //{ 100, 23123, 23123123, 213, 123333, 213, 123213123, 213, 23 };

        int printLen = Math.min(myArray.length, 200);
        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = (int) (Math.random() * max);
            if(printLen > i) {
                System.out.printf("%s ", myArray[i]);
            }
        }


        System.out.println();
        QuickSort.quicksort(myArray, false);
        System.out.println();

        for (int i = 0; i < printLen; ++i) {
            if (i > 0 && Objects.equals(myArray[i - 1], myArray[i])) {
                System.out.print("*");
            }else {
                System.out.printf(" %s", myArray[i]);
            }
        }
        System.out.println();
        boolean failed = false;
        for (int i = myArray.length - 2; i > 0; --i) {
            if (myArray[i] > myArray[i + 1]) {
                System.out.printf("FEHLER POS %d | %d > %d", i, myArray[i], myArray[i + 1]);
                failed = true;
                break;
            }
        }
        if (!failed) {
            System.out.println("Keine Fehler!");
        }

        System.out.println();
        System.out.println("END Integer");
    }

    private static void testKafkaDerProzess() throws IOException  {
        System.out.println("START Kafka der Prozess");

        LineNumberReader in = new LineNumberReader(new FileReader("./assets/Kafka_Der_Prozess.txt"));
        String line;

        ArrayList<String> word = new ArrayList<>();

        // Text einlesen und Häufigkeiten aller Wörter bestimmen:
        while ((line = in.readLine()) != null) {
            String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
            for (String w: wf) {
                if (w.length() == 0 || w.length() == 1)
                    continue;
                //System.out.println(w);
                word.add(w);
            }
        }
        var t = word.toArray(new String[0]);
        QuickSort.quicksort(t, false);

        System.out.println("END Kafka der Prozess");
        System.out.println();
    }
}
