package aufgabe04.list;

import aufgabe04.FrequencyTable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author Christopher Mogler
 * @since 30.03.2022
 */
public class LinkedListFrequencyTable_Test {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		test1();
		test2();
	}
	
	private static void test1() {
		// Test von add:
		LinkedListFrequency tab1 = new LinkedListFrequency<String>();
		tab1.add("das");
		tab1.add("ist");
		tab1.add("ein",2);
		tab1.add("Test");
		tab1.add("Test",2);
		
		System.out.println("Soll: Test:3");
		System.out.println("Ist:  " + tab1.get(0) + "\n");
		
		System.out.println("Soll: ein:2");
		System.out.println("Ist:  " + tab1.get(1) + "\n");
		
		System.out.println("Soll: 2");
		System.out.println("Ist:  " + tab1.get("ein") +  "\n");
		
		System.out.println("Soll: 1");
		System.out.println("Ist:  " + tab1.get("ist") +  "\n");
		
		System.out.println("Soll: 3");
		System.out.println("Ist:  " + tab1.get("Test") +  "\n");
		
		System.out.println("Soll: { Test:3, ein:2, ist:1, das:1, } size = 4");
		System.out.println("Ist:  " + tab1 +  "\n");
		
		System.out.println("Soll: 0");
		System.out.println("Ist:  " + tab1.get("abc") +  "\n");
		
		// Test von addAll:
		FrequencyTable tab2 = new LinkedListFrequency<String>();
		tab2.add("Test",2);
		tab2.add("das",2);
		tab2.add("ist",4);
		tab2.add("Text");
		tab2.add("kurzer");
		tab1.addAll(tab2);
		System.out.println("Soll: { ist:5, Test:5, das:3, ein:2, Text:1, kurzer:1, } size = 6");
		System.out.println("Ist:  " + tab1 +  "\n");
		
		// Test von copyMostFrequent und copyLeastFrequent:
		tab1.collectMostFrequent(tab2);
		System.out.println("Soll: { ist:5, Test:5, } size = 2");
		System.out.println("Ist:  " + tab2 +  "\n");
		tab1.collectLeastFrequent(tab2);
		System.out.println("Soll: { Text:1, kurzer:1, } size = 2");
		System.out.println("Ist:  " + tab2 +  "\n");
	}
	
	private static void test2() throws FileNotFoundException, IOException {
		FrequencyTable tab = new LinkedListFrequency<String>();

		System.out.println("START Kafka der Prozess");

		long start = System.nanoTime(); // aktuelle Zeit in nsec
		LineNumberReader in;
		in = new LineNumberReader(new FileReader("./assets/Kafka_Der_Prozess.txt"));
		String line;
		
		// Text einlesen und Häfigkeiten aller Wörter bestimmen:
		while ((line = in.readLine()) != null) {
			String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
			for (String w: wf) {
				if (w.length() == 0 || w.length() == 1)
					continue;
				//System.out.println(w);
				tab.add(w);
			}
		}
		System.out.println("END Kafka der Prozess");
		
		long end = System.nanoTime();
		double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec
		
		// Ausageb der 100 häufigsten Wörter:
		for (int i = 0; i < 100; i++) {
			if (tab.get(i) == null)
				break;
			System.out.println(tab.get(i));
		}
		in.close();
		System.out.println("");		
		System.out.println("Benötigte Zeit in msec: " + elapsedTime);
	}
}
