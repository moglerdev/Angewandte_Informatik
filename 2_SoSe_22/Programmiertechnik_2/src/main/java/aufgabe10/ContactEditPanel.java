package aufgabe10;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ContactEditPanel extends GroupPanel {

    private final JTextField editName = new JTextField();
    private final JTextField editAddOn = new JTextField();
    private final JTextField editTelNr = new JTextField();

    private void btnHandler(ActionEvent e) {
        var name = editName.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Es muss mindestens ein Zeichen im Name sein!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        var c = new Contact(
                name,
                editAddOn.getText(),
                editTelNr.getText());
        ContactController.addContact(c);
    }

    public ContactEditPanel() {
        super("Einfügen");

        // NAME
        var labelName = new JLabel("Name");
        this.add(labelName, 0, 0);
        this.add(editName, 1, 0, 1);

        // ZUSATZ
        var labelAddOn = new JLabel("Zusatz");
        this.add(labelAddOn, 0, 1);
        this.add(editAddOn, 1, 1, 1);

        // TELEFON NR
        var labelTelNr = new JLabel("Telefon Nr.");
        this.add(labelTelNr, 0, 2);
        this.add(editTelNr, 1, 2, 1);

        // EINFÜGEN
        var btnAdd = new JButton("Einfügen");
        btnAdd.addActionListener(this::btnHandler);
        this.add(btnAdd, 3, 1);
    }
}
