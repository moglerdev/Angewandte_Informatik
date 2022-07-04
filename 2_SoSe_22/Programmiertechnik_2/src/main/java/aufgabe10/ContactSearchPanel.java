package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

public class ContactSearchPanel extends GroupPanel {

    private final JComboBox<String> selectSearch;
    private final JTextField editName = new JTextField();
    private final JTextField editAddOn = new JTextField();
    private final String[] methods = {"Alle", "Exakte Suche", "Prefix Suche", "Löschen"};
    private void handleUpdate(ActionEvent e) {
        var t = selectSearch.getSelectedIndex();
        var name = editName.getText();
        var addOn = editAddOn.getText();
        boolean noFounds = false;
        switch (methods[t]) {
            case "Alle" -> ContactController.filterContacts((c) -> true);
            case "Exakte Suche" -> {
                var i = ContactController.filterContacts((contact -> Objects.equals(contact.getName(), name)
                        && Objects.equals(contact.getAddOn(), addOn)));
                noFounds = i <= 0;
            }
            case "Prefix Suche" -> {
                var i = ContactController.filterContacts((contact -> !name.isEmpty() && contact.getName().startsWith(name) ||
                        !addOn.isEmpty() && contact.getAddOn().startsWith(addOn)));
                noFounds = i <= 0;
            }
            case "Löschen" -> {
                if (! ContactController.deleteContact(name, addOn) ) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Kontakt konnte nicht gelöscht werden!",
                            "Fehler",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
        if (noFounds) {
            JOptionPane.showMessageDialog(
                    this,
                    "Es wurden keine Kontakt mit diesen Kriterien gefunden!",
                    "Warnung",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        System.out.println(t);
    }

    public ContactSearchPanel() {
        super("Suchen / Löschen");

        ArrayList<String> s = new ArrayList<>();

        // NAME
        var labelName = new JLabel("Name");
        this.add(labelName, 0, 0);
        this.add(editName, 1, 0, 1);

        // ZUSATZ
        var labelAddOn = new JLabel("Zusatz");
        this.add(labelAddOn, 0, 1);
        this.add(editAddOn, 1, 1, 1);

        // SEARCH METHOD
        selectSearch = new JComboBox<>(methods);
        GridBagConstraints c = this.crateConstraints();
        c.gridheight = 2;
        c.gridy = 0;
        c.gridx = 3;
        c.insets = new Insets(0, 10, 0, 10);
        this.add(selectSearch, c);

        // ANWENDEN
        var btnAdd = new JButton("Anwenden");
        c.gridheight = 2;
        c.gridx = 4;
        c.insets = new Insets(0, 10, 0, 10);
        btnAdd.addActionListener(this::handleUpdate);
        this.add(btnAdd, c);
    }
}
