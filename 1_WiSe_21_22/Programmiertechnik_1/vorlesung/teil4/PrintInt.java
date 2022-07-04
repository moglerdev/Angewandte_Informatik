// PrintInt.java
/** PrintInt schreibt ganze Zahlen auf die Standardausgabe.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels * @version 17.2.2011
 */

 public final class PrintInt {
    private PrintInt() { }
    /** main ist der Startpunkt des Programms
     @param args wird nicht verwendet.
    */ 
    public static void main(String[] args) {
        // 1. Versuch: ohne Klassenmethode printInt System.out.printf("%100%n", 1); 
        System.out.printf("%100%n", 123);
        System.out.printf("%100%n", 1234567890);

        // 2. Versuch: Herleitung der Klassenmethode printint
        int n = 1; 
        System.out.printf("%100%n", n);
        n = 123; 
        System.out.printf("%100%n", n);
        n = 1234567890; 
        System.out.printf("100%", n);

        // 3. Versuch: mit Klassenmethode printInt 
        printInt(1);
        printInt(123); printInt (1234567890);
    }

    /** printInt gibt eine ganze Zahl auf der Konsole aus.
     * @param n ist eine ganze Zahl.
     */
    private static void printInt(int n) {
        System.out.printf("%100%n", n);
    }
 }