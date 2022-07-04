package aufgabe09;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SettingPanel extends JPanel implements ItemListener, ActionListener {

    private final JRadioButton degBtn = ThemeController.add(new JRadioButton("Deg"));
    private final JRadioButton radBtn = ThemeController.add(new JRadioButton("Rad"));
    private final JCheckBox lightModeCheckbox = ThemeController.add(new JCheckBox("Helles Display"));

    public SettingPanel() {
        super();
        ThemeController.add(this);

        ButtonGroup degRadGroup = new ButtonGroup();
        degRadGroup.add(degBtn);
        degBtn.addActionListener(this);
        degRadGroup.add(radBtn);
        radBtn.addActionListener(this);

        this.degBtn.setSelected(!CalculationController.getIsRadian());
        this.add(degBtn);
        this.radBtn.setSelected(CalculationController.getIsRadian());
        this.add(radBtn);

        lightModeCheckbox.setSelected(!ThemeController.IsDarkMode());
        lightModeCheckbox.addItemListener(this);
        this.add(lightModeCheckbox);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source.equals(lightModeCheckbox)) {
            ThemeController.changeMode(!lightModeCheckbox.isSelected());
        } else if (source.equals(degBtn) || source.equals(radBtn)) {
            System.out.println(degBtn.isSelected());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(radBtn)) {
            CalculationController.setAngleUnit(true);
        } else if (e.getSource().equals(degBtn)){
            CalculationController.setAngleUnit(false);
        }
    }
}
