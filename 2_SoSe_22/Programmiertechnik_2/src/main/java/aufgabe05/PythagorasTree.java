package aufgabe05;

import java.awt.*;
import java.util.Arrays;

public class PythagorasTree {
    private static final double min = 0.001;

    public static void main(String[] args) {

        Vector2 A = new Vector2(0.6, 0.05);

        StdDraw.show(0);
        StdDraw.setCanvasSize(800, 800);
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenRadius(0.002);
        //drawAbb1(A, 0, 0.16);
        drawAbb2(A,0,00.10);
        StdDraw.show(0);
    }

    static void drawAbb1(Vector2 A, double alpha, double length) {
        if (length < min) {
            StdDraw.setPenColor(StdDraw.GREEN); //Grün, beim letzten Aufruf
        } else {
            StdDraw.setPenColor(new Color(137, 99, 69));
        }

        double delta = 0.52;

        double s = length * Math.sin(alpha);
        double c = length * Math.cos(alpha);

        //Coordinates for B
        Vector2 B = new Vector2(A.x + c, A.y + s);

        //Coordinates for C
        Vector2 C = new Vector2(A.x + c - s, A.y + s + c);

        //Coordinates for D
        Vector2 D = new Vector2(A.x - s, A.y + c);

        //Coordinates for E
        double u = length * Math.cos(delta);
        double v = length * Math.sin(delta);

        Vector2 E = new Vector2(D.x + u * Math.cos(alpha + delta),
                D.y + u * Math.sin(alpha + delta));

        //Drawing Rectangles
        //StdDraw.line(A.x, A.y, B.x, B.y); //A->B
        StdDraw.line(B.x, B.y, C.x, C.y); //B->C
        //StdDraw.line(C.x, C.y, D.x, D.y); //C->D
        StdDraw.line(D.x, D.y, A.x, A.y); //D->A


        if (min < length) {
            drawAbb1(D, alpha + delta, u);
            drawAbb1(E, alpha + delta - 1.57, v);
        }
    }

    static void drawAbb2(Vector2 A, double alpha, double length) {
        double height = Math.random()*length+length;
        double beta = Math.toRadians(Math.random()*45+10);
        if (length < min) {
            StdDraw.setPenColor(StdDraw.GREEN); //Grün, beim letzten Aufruf
        } else {
            StdDraw.setPenColor(StdDraw.WHITE);
        }


        double s = length * Math.sin(alpha);
        double c = length * Math.cos(alpha);
        double r = height * Math.sin(alpha);
        double h = height * Math.cos(alpha);

        //Coordinates for B
        Vector2 B = new Vector2(A.x + c, A.y + s);

        //Coordinates for C
        Vector2 C = new Vector2(A.x + c - r, A.y + s + h);

        //Coordinates for D
        Vector2 D = new Vector2(A.x - r, A.y + h);

        //Coordinates for E
        double u = length * Math.cos(beta);
        double v = length * Math.sin(beta);

        Vector2 E = new Vector2(D.x + u * Math.cos(alpha + beta),
                D.y + u * Math.sin(alpha + beta));

        //Drawing Rectangles
        //StdDraw.line(A.x, A.y, B.x, B.y); //A->B
        StdDraw.line(B.x, B.y, C.x, C.y); //B->C
        //StdDraw.line(C.x, C.y, D.x, D.y); //C->D
        StdDraw.line(D.x, D.y, A.x, A.y); //D->A

        if (min < length) {
            drawAbb2(D, alpha + beta, u);
            drawAbb2(E, alpha + beta - 1.57, v);
        }
    }
}
