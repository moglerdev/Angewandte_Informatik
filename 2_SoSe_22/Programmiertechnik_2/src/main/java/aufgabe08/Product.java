package aufgabe08;

import java.util.Map;

public class Product extends CompoundExpression {
    public Product(Expression a, Expression b) {
        super(a, b);

    }

    @Override
    public Double eval(Map<String, Double> el) {
        return this.left.eval(el) * this.right.eval(el);
    }

    @Override
    public String toString() {
        return this.toString("*");
    }
}
