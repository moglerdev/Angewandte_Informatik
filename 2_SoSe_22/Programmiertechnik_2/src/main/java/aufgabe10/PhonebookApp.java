package aufgabe10;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class PhonebookApp extends JFrame {

    public PhonebookApp() {
        super();
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new DimensionUIResource(720, 720));

        initMenu();

        Container pane = this.getContentPane();
        GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 0;

        c.gridx = 0;
        c.gridy = 0;
        pane.add(new ContactEditPanel(), c);

        c.gridx = 0;
        c.gridy = 1;
        pane.add(new ContactSearchPanel(), c);

        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(new ContactOutputPanel(), c);
    }

    private void readContactsHandler(ActionEvent e) {
        System.out.println("Read");
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            var file = fileChooser.getSelectedFile();
            try {
                var i = ContactController.loadContacts(file);
                if (i <= 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Es wurden keine Kontakte geladen!",
                            "Warnung",
                            JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    System.out.printf("Es wurden %d Kontakte geladen!%n", i);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Beim lesen der Datei ist ein Fehler aufgetreten!",
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void save(@Nullable File file) {
        if (ContactController.saveContacts(file)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Kontakte wurden gespeichert!",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Kontakte konnte nicht gespeichert werden!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void saveContactsHandler(ActionEvent e) {
        System.out.println("Save");
        save(null);
    }

    private void saveContactsNewHandler(ActionEvent e) {
        System.out.println("Save New");
        var fileChooser = new JFileChooser("./");
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            var file = fileChooser.getSelectedFile();
            save(file);
        }

        //ContactController.saveContacts(null);
    }

    private void closeAppHandler(ActionEvent e) {
        System.out.println("Close");

        dispose();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Datei");
        fileMenu.setMnemonic(KeyEvent.VK_ALT);
        menuBar.add(fileMenu);

        JMenuItem readMenu = new JMenuItem("Telefon Buch lesen...");
        readMenu.addActionListener(this::readContactsHandler);
        readMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(readMenu);

        JMenuItem saveMenu = new JMenuItem("Telefon speichern...");
        saveMenu.addActionListener(this::saveContactsHandler);
        saveMenu.setMnemonic(KeyEvent.VK_S);
        fileMenu.add(saveMenu);

        JMenuItem saveNewMenu = new JMenuItem("Telefon speichern unter...");
        saveNewMenu.addActionListener(this::saveContactsNewHandler);
        saveNewMenu.setMnemonic(KeyEvent.VK_S);
        fileMenu.add(saveNewMenu);
        fileMenu.addSeparator();

        JMenuItem closeMenu = new JMenuItem("Telefon Buch beenden...");
        closeMenu.addActionListener(this::closeAppHandler);
        closeMenu.setMnemonic(KeyEvent.VK_X);
        fileMenu.add(closeMenu);
    }

    public static void main(String[] args) {
        var app = new PhonebookApp();
        app.pack();
        app.setVisible(true);
    }
}
