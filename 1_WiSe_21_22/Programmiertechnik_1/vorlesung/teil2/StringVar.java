// StringVar.java

/**
 * StringVar zeigt den Umgang mit Variablen vom Typ String.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author Christopher Mogler
 * @version 03.11.2021
 */
public final class StringVar {
    private StringVar() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        String a = "Hello";
        String b = new String("Hello");
        String c = a + b;

        System.out.println(a == "Hallo");
        System.out.println(b == "Hallo");

        System.out.println(a == b);
        System.out.println(a == b.intern());

        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b) == 0);
        System.out.println(a.compareTo(c) < 0);
    }
}