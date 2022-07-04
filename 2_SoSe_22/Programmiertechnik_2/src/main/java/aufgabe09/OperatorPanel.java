package aufgabe09;

import javax.swing.*;
import java.awt.*;

public class OperatorPanel extends JPanel {

    public OperatorPanel() {
        super();
        ThemeController.add(this);
        this.setLayout(new GridLayout(2, 4));
        this.setBorder(BorderFactory.createLineBorder(Color.gray));

        var addBtn = ThemeController.add(new JButton("+"));
        CalculationController.addOperatorBtn(addBtn, CalculationController.Operators.ADD);
        this.add(addBtn);
        var mulBtn = ThemeController.add(new JButton("x"));
        CalculationController.addOperatorBtn(mulBtn, CalculationController.Operators.MUL);
        this.add(mulBtn);
        var subBtn = ThemeController.add(new JButton("-"));
        CalculationController.addOperatorBtn(subBtn, CalculationController.Operators.SUB);
        this.add(subBtn);
        var divBtn = ThemeController.add(new JButton("/"));
        CalculationController.addOperatorBtn(divBtn, CalculationController.Operators.DIV);
        this.add(divBtn);
        var sinBtn = ThemeController.add(new JButton("sin"));
        CalculationController.addOperatorBtn(sinBtn, CalculationController.Operators.SIN);
        this.add(sinBtn);
        var cosBtn = ThemeController.add(new JButton("cos"));
        CalculationController.addOperatorBtn(cosBtn, CalculationController.Operators.COS);
        this.add(cosBtn);
        var powBtn = ThemeController.add(new JButton("x^y"));
        CalculationController.addOperatorBtn(powBtn, CalculationController.Operators.POW);
        this.add(powBtn);
        var logBtn = ThemeController.add(new JButton("log2"));
        CalculationController.addOperatorBtn(logBtn, CalculationController.Operators.LOG);
        this.add(logBtn);
    }
}
