// Increment.java

/**
 * Increment testet den Operator ++.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author Christopher Mogler
 * @version 03.11.2021
 */
public final class Increment {
    private Increment() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet
     */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        int i = 1;
        System.out.println(++i);
        System.out.println(i++);
        System.out.println(i);

        // das gleiche ohne Kurzschreibweise ++:
        i = 1;
        i = i + 1; System.out.println(i);
        System.out.println(i); i = i + 1;
        System.out.println(i);

        // mehrfache Anwendung funktioniert nicht (++ ist nur auf Variablen anwendbar, nicht auf Werte)
        // System.out.println(++++i);
        // System.out.println(i+++++);
        // System.out.println(++i+++);
        // System.out.println((++i)++);

        double d = 1.2;
        ++d;
        System.out.println(d); // 2.2

        char c = 'a';
        ++c;
        System.out.println(c); // b
    }
}