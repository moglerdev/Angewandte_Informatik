// StringSort.java
/**
 * StringSort gibt seine Komandozeileargumente aufsteigend sortiert aus.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4
 * @author H. Drachenfels
 * @version 12.8.2010
 */

 public final class StringSort {
    private StringSort() { }

    /**
     * main ist der Startpunkt des Programms.
    * @param args wird nicht verwendet 
    */
    public static void main(String[] args) {
        java.util.Arrays.sort(args);

        for (String s: args) {
            System.out.println(s);
        }
    }
 }