package aufgabe08;

import java.util.Map;
import java.util.Set;

public class Constant implements Expression, Comparable<Constant> {
    public final Double value;

    public Constant(Double value) {
        this.value = value;
    }

    @Override
    public Double eval(Map<String, Double> el) {
        return this.value;
    }

    @Override
    public Set<Var> getVars() {
        return Set.of();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public int compareTo(Constant o) {
        return this.value.compareTo(o.value);
    }
}
