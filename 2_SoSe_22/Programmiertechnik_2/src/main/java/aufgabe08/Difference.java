package aufgabe08;

import java.util.Map;

public class Difference extends CompoundExpression {
    public Difference(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public Double eval(Map<String, Double> el) {
        return this.left.eval(el) - this.right.eval(el);
    }

    @Override
    public String toString() {
        return this.toString("-");
    }
}
