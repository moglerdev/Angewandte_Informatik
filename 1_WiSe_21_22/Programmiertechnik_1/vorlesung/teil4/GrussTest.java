// GrussTest.java

import de.htwg.ain.prog1.teil4.Gruss;
import static de.htwg.ain.prog1.teil4.Gruss.hallo;

/**
 * GrussTest zeigt die Benutzung einer Klasse aus einem Paket.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 13.2.2019
 */
public final class GrussTest {
    private GrussTest() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        de.htwg.ain.prog1.teil4.Gruss.hallo();
        Gruss.hallo(); // moeglich wegen import
        hallo(); // moeglich wegen import static
    }
}

