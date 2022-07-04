package aufgabe05;

public class Vector2 {
    double x;
    double y;

    Vector2 (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 vec) {
        return add(vec.x, vec.y);
    }

    public Vector2 add(double x, double y) {
        return new Vector2(this.x + x, this.y + y);
    }

    public double getDistance(Vector2 vec) {
        double x1 = Math.pow(x - vec.x, 2);
        double y1 = Math.pow(y - vec.y, 2);

        return Math.abs(Math.sqrt(x1 + y1));
    }
}
