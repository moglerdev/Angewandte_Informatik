package aufgabe08;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public abstract class CompoundExpression implements Expression {
    protected final Expression left;
    protected final Expression right;

    public CompoundExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Set<Var> getVars() {
        Set<Var> res = new TreeSet<>();
        res.addAll(this.right.getVars());
        res.addAll(this.left.getVars());
        return res;
    }

    public String toString(String operator) {
        return "(" + this.left.toString() + " " + operator + " " + this.right.toString() + ")";
    }
}
