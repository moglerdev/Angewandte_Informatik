package aufgabe09;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    public InputPanel() {
        ThemeController.add(this);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.gray, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //this.setBorder(BorderFactory.createLineBorder(Settings.FOREGROUND, 2));
        this.setLayout(new GridLayout(3, 2));

        JLabel labelOpX = ThemeController.add(new JLabel("Operand x"));
        this.add(labelOpX);
        JEditorPane textOpX = CalculationController.addField(ThemeController.add(new JEditorPane()), CalculationController.IOTypes.X);
        this.add(textOpX);

        JLabel labelOpY = ThemeController.add(new JLabel("Operand y"));
        this.add(labelOpY);
        JEditorPane textOpY = CalculationController.addField(ThemeController.add(new JEditorPane()), CalculationController.IOTypes.Y);
        this.add(textOpY);

        JLabel labelResult = ThemeController.add(new JLabel("Resultat"));
        this.add(labelResult);
        JEditorPane textResult = CalculationController.addField(ThemeController.add(new JEditorPane()), CalculationController.IOTypes.R);
        this.add(textResult);
        textResult.setBorder(
                BorderFactory.createEmptyBorder(10, 5, 10, 5));
        textResult.setEditable(false);
    }
}
