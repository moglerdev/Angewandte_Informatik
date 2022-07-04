package aufgabe08;

import java.util.Map;
import java.util.Set;

public interface Expression {
    /**
     * ine Methode eval, um einen Ausdruck wie e1 = a*a + b*b auswerten zu können. Dazu wird
     * eine Map (java.util.Map) übergeben, die jeder Variablen einen double-Wert zuordnet. Z.B. wird
     * mit der Variablenbelegung a = 3.0 und b = 4.0 der Ausdruck e1 zu 25.0 ausgewertet.
     */
    public Double eval(Map<String, Double> el);

    /**
     * Eine Methode getVars, die alle Variablen eines Ausdrucks als Set (java.util.Set) zurückliefert.
     * Z.B. ergibt sich beim Ausdruck a*a + b*b die Variablenmenge {a, b}.
     */
    public Set<Var> getVars();

    /**
     * Überschreiben Sie die Methode toString, so dass vollständig geklammerte Ausdrücke als
     * Strings erzeugt werden. Bei e1 bzw. e2 ergeben sich die Strings "((a * b)) + (b * b))" bzw.
     * "((n * (n + 1)) / 2)".
     */
    public String toString();
}
