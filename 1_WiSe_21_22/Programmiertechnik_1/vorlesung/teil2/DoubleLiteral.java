// DoubleLiteral.java

/**
 * DoubleLiteral zeigt die Ausgabe von Gleitkommaliteralen auf der Konsole.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author Christopher Mogler
 * @version 21.20.2021
*/
public final class DoubleLiteral {
    private DoubleLiteral() { }
    /**
    * main ist der Startpunkt des Programms.
    * @param args wird nicht verwendet.
    */
    @SuppressWarnings("magicnumber")
    public static void main(String[] args) {
        //Check:OFF: MagicNumber
        double magicNumberFirst = (1e-30 + 1e30) - 1e30;
        double magicNumberSecond = 1e-30 + (1e30 - 1e30);

        double firstNumber = 12.3456789;
        double secondNumber = 1234567.89;

        System.out.println(magicNumberFirst);
        System.out.println(magicNumberSecond);

        System.out.println(firstNumber);
        System.out.println(secondNumber);

        System.out.printf("%f%n", firstNumber);
        System.out.printf("%f%n", secondNumber);

        System.out.printf("%e%n", firstNumber);
        System.out.printf("%e%n", secondNumber);
        //Check:ON: MagicNumber
    }
}