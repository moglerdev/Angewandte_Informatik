package aufgabe08;

import java.util.Map;
import java.util.Set;

public class Var implements Expression, Comparable<Object> {
    private final String name;

    public Var(String v) {
        this.name = v;
    }

    @Override
    public Double eval(Map<String, Double> el) {
        return el.get(this.name);
    }

    @Override
    public Set<Var> getVars() {
        return Set.of(this);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof String) return this.name.compareTo((String) o);
        if (o instanceof Var) return this.name.compareTo(((Var) o).name);
        throw new UnsupportedOperationException();
    }
}
