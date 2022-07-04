/*
 * class Evaluator
 * repl-Schleife: lese von der Konsole eine Ziele und
 * werte sie als arithmetischen Ausdruck aus.
 * Da tokenizer String-Konstante zurÃ¼ckliefert, reicht
 * GleichheitsprÃ¼fung mit == aus (siehe z.B. shift-Methode).
 *
 * Ihr Name:
 * Datum:
 */
package aufgabe03;

import java.util.Scanner;
import static aufgabe03.Tokenizer.*;
import java.lang.Math;

/**
 * Klasse zum Auswerten von arithmetischen AusdrÃ¼cken.
 */
public class Evaluator {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static Object[] stack = new Object[20];		// Stack
    private static int top = -1;	    			// Index des obersten Kellerelements
    private static Object token;					// Aktuelles Token
    private static Tokenizer tokenizer;				// Zerlegt String-Eingabe in Tokens

    /**
     * Wertet expr als arithmetischen Ausdruck aus.
     *
     * @param expr Arthmetischer Ausdruck als String
     * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
     */
    public static Double eval(String expr) {
        // Dollar in leeren Stack ablegen:
        top = -1;
        stack[++top] = DOLLAR;

        // expr in Tokens zerlegen und erstes Token abholen:

        tokenizer = new Tokenizer(expr);
        token = tokenizer.nextToken();

        while (token != null) {
            // Ihr Code:
                if(!shift()) {
                    if(!reduce()){
                        if(!accept()){
                            return null;
                        } else {
                            return (Double) stack[top];
                        }
                    }

                } else {
                    token = tokenizer.nextToken();
                }
            // ...
        }
        return null;
    }

    private static boolean shift() {
        if (stack[top] == DOLLAR && (token == KL_AUF || isVal(token))) {		// Regel 1 der Parser-Tabelle
            doShift();
            return true;
        } // Ihr Code:
        else if (isOp(stack[top]) && (token == KL_AUF || isVal(token))) {
            doShift();
            return true;
        } else if (stack[top] == KL_AUF && (token == KL_AUF || isVal(token))) {
            doShift();
            return true;
        } else if(top > 0 &&stack[top - 1] == DOLLAR && isVal(stack[top]) && isOp(token)) {
            doShift();
            return true;
        } else if(top > 0 && stack[top - 1] == KL_AUF && isVal(stack[top]) && (token == KL_ZU || isOp(token))) {
            doShift();
            return true;
        } else if(top > 1 && isVal(stack[top - 2]) && isOp(stack[top - 1]) && isVal(stack[top]) && (isOp(token))) {
            if(((token == MULT || token == POWER) && stack[top - 1] == PLUS)) {
                doShift();
                return true;
            } else return false;
        }
        // ...
            return false;
    }

    private static void doShift() {
        // Ihr Code:
        stack[++top] = token;
        // ... 
    }

    private static boolean isOp(Object o) {
        return (o == PLUS || o == MULT || o == POWER);
    }

    private static boolean isVal(Object o) {
        return o instanceof Double;
    }

    private static boolean reduce() {
        // Ihr Code:
        if(top > 1 && stack[top - 2] == KL_AUF && isVal(stack[top - 1]) && stack[top] == KL_ZU && (token == KL_ZU || isOp(token) || token == DOLLAR)) {
            doReduceKlValKl();
            return true;
        } else if (top > 1 && isVal(stack[top - 2]) && isOp(stack[top - 1]) && isVal(stack[top]) && (token == KL_ZU || token == DOLLAR)) {
            doReduceValOpVal();
            return true;
        } else if(top > 1 && isVal(stack[top - 2]) && isOp(stack[top - 1]) && isVal(stack[top]) && (isOp(token))) {
            if(((token == MULT || token == POWER) && stack[top - 1] == PLUS)) {
                return false;
            } else {
                doReduceValOpVal();
                return true;
            }
        }
        // ...
        return false;
    }

    private static void doReduceKlValKl() {
        // Ihr Code:
        stack[top] = null;
        stack[top - 2] = stack[top - 1];
        stack[top - 1] = null;
        top += -2;
        // ...
    }

    private static void doReduceValOpVal() {
        // Ihr Code:
        double val1;
        double val2;
        double val3;
        String op;

        val1 = (double) stack[top];
        val2 = (double) stack[top - 2];
        op = stack[top - 1].toString();

        if(op == MULT) {
            val3 = val1 * val2;
        } else if(op == PLUS) {
            val3 = val1 + val2;
        } else if(op == POWER) {
            val3 = Math.pow(val2, val1);
        } else {
            val3 = 0;
        }

        stack[top - 2] = val3;
        stack[top] = null;
        stack[top - 1] = null;
        top += - 2;

        // ...
    }

    private static boolean accept() {
        // Ihr Code:
        if(top > 0 && stack[top - 1] == DOLLAR && isVal(stack[top]) && token == DOLLAR) {
            return true;
        }
        // ...
        return false;
    }

    /**
     * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
     * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
     */
    public static void repl() {
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + ">> ");

        while (in.hasNextLine()) {
            String line = in.nextLine();
            // Ihr Code:
            if(line == "end"){
                System.out.println("bye");
                break;
            }
            if(line.equals("end")){
                System.out.println("bye");
                break;
            }
            if(eval(line) == null){
                System.out.println("!!! error");
            } else {
                System.out.println(eval(line));
            }
            // ...
            System.out.print(ANSI_BLUE + ">> ");
        }


    }

    /**
     * Testprogramm.
     *
     * @param args wird nicht benutzt.
     */
    public static void main(String[] args) {
        // Zum Testen, spÃ¤ter auskommentieren:
        String s1 = "1+2";
        String s2 = "2^10+5";
        String s3 = "5+2^10";
        String s4 = "(2+3*4+4)^2";
        String s5 = "(2+3*4+4))*2";
        String s6 = "2+3**4";
        String s7 = "2^2^3";
        String s8 = "2^2*5";
        String s9 = "1+(2+(3+(4+(5+6))))";
        String s10 = "1+2+3+4+5+6";

        System.out.println(eval(s1));	// 3.0
        System.out.println(eval(s2));	// 1029.0
        System.out.println(eval(s3));	// 1029.0
        System.out.println(eval(s4));	// 324.0
        System.out.println(eval(s5));	// null; Syntaxfehler
        System.out.println(eval(s6));	// null; Syntaxfehler
        System.out.println(eval(s7));	// 64.0
        System.out.println(eval(s8));	// 20.0
        System.out.println(eval(s9));	// 21.0
        System.out.println(eval(s10));	// 21.0

       repl();
    }
}