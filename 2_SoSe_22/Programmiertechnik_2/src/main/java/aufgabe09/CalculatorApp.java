package aufgabe09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalculatorApp extends JFrame implements ActionListener, ItemListener {

    public CalculatorApp() {
        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
        ThemeController.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        var inputPanel = new InputPanel();
        mainPanel.add(inputPanel);

        var settingPanel = new SettingPanel();
        mainPanel.add(settingPanel);

        var operatorPanel = new OperatorPanel();
        mainPanel.add(operatorPanel);

        var clearPanel = new JPanel();
        mainPanel.add(clearPanel);
        clearPanel.setLayout(new GridLayout(1, 1));

        var clearBtn = ThemeController.add(new JButton("Clear"));
        clearBtn.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(10, 0, 10, 0),
                        BorderFactory.createLineBorder(Color.gray)
                ));
        CalculationController.addOperatorBtn(clearBtn, CalculationController.Operators.CLEAR);
        clearPanel.add(clearBtn);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame calculatorApp = new CalculatorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("itemStateChanged");
    }
}
