// IntVar.java

package aufgabe1;


/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Christopher Mogler
 * @version 19.10.2021
 */
public final class IntLiteral {
    private IntLiteral() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */

    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        //Check:OFF: MagicNumber
        System.out.println(12);
        System.out.println(012);
        System.out.println(0x12);
        System.out.printf("%x%n", 12);
        System.out.printf("%d%n", 012);
        System.out.printf("%o%n", 0x12);
        //Check:ON: MagicNumber
    }
}

