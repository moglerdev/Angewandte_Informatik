package aufgabe09;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public final class CalculationController {
    private CalculationController() { }

    public enum Operators {
        ADD,
        SUB,
        MUL,
        DIV,
        SIN,
        COS,
        POW,
        LOG,
        CLEAR
    }

    public enum IOTypes {
        X,
        Y,
        R
    }

    private static IO __X;
    private static IO __Y;
    private static IO __R;
    private static Operator __operator;
    private static void changeOperator(Operator op) {
        if (__operator != null) ThemeController.removeStaticColor(__operator.component);
        __operator = op;
        ThemeController.setStaticColor(
                op.component,
                new Color(183, 255, 244),
                new Color(49, 54, 126));
        switch (op.operator) {
            case SIN, COS, LOG -> {
                __Y.setValue(0);
                __Y.setIsEnabled(false);
            }
            default -> __Y.setIsEnabled(true);
        }
    }

    private static class IO implements DocumentListener {
        final IOTypes type;
        final JEditorPane component;
        private double value = 0.0;
        private boolean hasError = false;

        public IO(JEditorPane component, IOTypes type) {
            this.type = type;
            component.setText(Double.toString(value));
            component.getDocument().addDocumentListener(this);
            this.component = component;
        }

        private boolean preventEvent = false;
        public void setValue(double value) {
            this.value = value;
            preventEvent = true;
            if(Double.isInfinite(value) || Double.isNaN(value)){
                System.err.println("Double.isInfinite(value) || Double.isNaN(value)");
                setHasError(true);
            } else if(hasError) {
                setHasError(false);
            }
            component.setText(Double.toString(value));
        }

        public void setIsEnabled(boolean isEnabled) {
            component.setVisible(isEnabled);
        }

        public void setHasError(boolean hasError) {
            if (hasError) {
                ThemeController.setStaticColor(
                        component,
                        new Color(129, 0, 0),
                        new Color(192, 160, 160));
                this.hasError = true;
            } else {
                this.hasError = false;
                ThemeController.removeStaticColor(component);
            }
        }

        private void handleChange(DocumentEvent e) {
            try {
                if (preventEvent) {
                    return;
                }
                if (hasError) {
                    setHasError(false);
                }
                if (type != IOTypes.R) {
                    var str  = component.getText();
                    value = str.isEmpty() || str.equals("-") ? 0 : Double.parseDouble(str.replace(',', '.'));
                    calculate(type);
                }
            }
            catch (Exception exception) {
                System.err.println(exception.getMessage());
                setHasError(true);
            }
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (preventEvent) preventEvent = false;
            else handleChange(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (!preventEvent) handleChange(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }

    public static JEditorPane addField(JEditorPane component, IOTypes type) {
        var io = new IO(component, type);
        switch (type) {
            case X -> __X = io;
            case Y -> __Y = io;
            case R -> __R = io;
        }
        return component;
    }

    private static void calculate(@Nullable IOTypes callerType) {
        double valueX = __X.value;
        double valueY = __Y.value;
        double valueResult = __R.value;

        switch (__operator.operator) {
            case ADD -> valueResult = valueX + valueY;
            case SUB -> valueResult = valueX - valueY;
            case MUL -> valueResult = valueX * valueY;
            case DIV -> valueResult = valueX / valueY;
            case SIN -> {
                var radianValue = isRadian ? valueX : Math.toRadians(valueX);
                valueResult = Math.sin(radianValue);
                valueY = 0;
            }
            case COS -> {
                var radianValue = isRadian ? valueX : Math.toRadians(valueX);
                valueResult = Math.cos(radianValue);
                valueY = 0;
            }
            case POW -> valueResult = Math.pow(valueX, valueY);
            case LOG -> {
                valueResult = Math.log(valueX);
                valueY = 0;
            }
        }

        if (callerType != IOTypes.X) __X.setValue(valueX);
        if (callerType != IOTypes.Y) __Y.setValue(valueY);
        if (callerType != IOTypes.R) __R.setValue(valueResult);
    }

    private static class Operator implements ActionListener {
        final JButton component;
        final Operators operator;

        public Operator(JButton btn, Operators operator) {
            this.component = btn;
            this.operator = operator;
            btn.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (operator == Operators.CLEAR) {
                changeOperator(operators.get(0));
                __X.setValue(0);
                __Y.setValue(0);
                __Y.setIsEnabled(true);
                __R.setValue(0);
            } else {
                changeOperator(this);
                calculate(null);
            }
        }
    }

    private static final ArrayList<Operator> operators = new ArrayList<>();

    public static void addOperatorBtn(JButton btn, Operators operator) {
        var op = new Operator(btn, operator);
        if (__operator == null) changeOperator(op);
        operators.add(op);
    }

    private static boolean isRadian = true; // Radians wird beim Clear-Befehl nicht zurückgesetzt. Warum? Weil kein Bock xD
    public static boolean getIsRadian() { return isRadian; }
    public static void setAngleUnit(boolean setToRadian) {
        isRadian = setToRadian;
        calculate(null);
    }
}
