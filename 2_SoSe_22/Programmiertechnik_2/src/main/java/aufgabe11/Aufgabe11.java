package aufgabe11;

import aufgabe10.GroupPanel;
import aufgabe11.A.FileHelper;
import aufgabe11.B.Person;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public final class Aufgabe11 extends JFrame {
    private Aufgabe11() {
        this.setTitle("Aufgabe 11");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new DimensionUIResource(720, 480));

        var panel = this.getContentPane();
        panel.setLayout(new GridBagLayout());

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu aufgabeMenu = new JMenu("Aufgaben");
        aufgabeMenu.setMnemonic(KeyEvent.VK_ALT);
        menuBar.add(aufgabeMenu);

        JMenuItem aufgabeA = new JMenuItem("Aufgabe A / 1");
        aufgabeA.addActionListener(e -> {
            panel.removeAll();
            showA();
        });
        aufgabeA.setMnemonic(KeyEvent.VK_A);
        aufgabeMenu.add(aufgabeA);

        JMenuItem aufgabeB = new JMenuItem("Aufgabe B / 2");
        aufgabeB.addActionListener(e -> {
            panel.removeAll();
            showB();
        });
        aufgabeB.setMnemonic(KeyEvent.VK_B);
        aufgabeMenu.add(aufgabeB);
    }

    private void add(JComponent comp, int x, int y) {
        final var panel = this.getContentPane();
        final var c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = x;
        c.gridx = y;
        c.weighty = 1.0;
        c.weightx = 1.0;

        panel.add(comp, c);
    }

    private File getFileByDialog(String description, String[] extensions) {
        var fc = new JFileChooser("./");
        if (extensions != null && extensions.length > 0) {
            var fcf = new FileNameExtensionFilter(description, extensions);
            fc.setFileFilter(fcf);
        }
        if( fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) {
            return fc.getSelectedFile();
        }
        return null;
    }

    public void showA() {
        var file = this.getFileByDialog("Datei mit vielen Wörtern auswählen...", null);
        if (file == null)
            return;
        var assignment1 = new GroupPanel("Aufgabe 1");
        this.add(assignment1, 0, 0);

        var resText = new JTextArea();

        var scrollPanel = new JScrollPane(resText);
        assignment1.add(scrollPanel, 0, 0, 1.0, 1.0, GridBagConstraints.BOTH);

        int max = 100;
        StringBuilder sb = new StringBuilder();
        var ai = new AtomicInteger(0);
        FileHelper.getCountedWords(file, "[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+")
                .limit(max)
                .forEach(e -> sb.append(String.format("%d:\t%s\t%d%n", ai.addAndGet(1), e.getKey(), e.getValue())));

        resText.setText(sb.toString());
    }

    private static ArrayList<Person> getPersonsFromCSV(File csvFile) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            var res = new ArrayList<Person>();
            Random ry = new Random();
            br.lines().forEach(line -> {
                var cols = line.replaceAll("\"", "").split(",");
                if (cols.length < 2) return;
                res.add(new Person(
                        cols[0],
                        cols[1],
                        LocalDate.of(
                                ry.nextInt(2022-1969+1) + 1969,
                                ry.nextInt(11) + 1,
                                ry.nextInt(27) + 1)));
            });
            return res;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void showB() {
        var file = this.getFileByDialog("Personenliste als CSV Datei auswählen...", new String[]{"csv"});

        if (file == null)
            return;

        if (!file.getName().endsWith(".csv"))
            return;

        final Predicate<? super Person>  isOver18 = p -> Period.between(p.getBirthday(), LocalDate.now()).getYears() > 17;

        try {
            var persList = getPersonsFromCSV(file);

            if (persList == null)
                return;

            Collections.sort(persList, Person::compareTo);

            ArrayList<Person> revPersList = (ArrayList<Person>) persList.clone();
            revPersList.sort(Comparator.reverseOrder());

            var over18Birthday = new GroupPanel("Alle Geburtstage die über 18 sind");
            this.add(over18Birthday, 0, 0);
            var over18BirthdayText = new JTextArea();
            var over18BirthdayTextScrollPanel = new JScrollPane(over18BirthdayText);
            over18Birthday.add(over18BirthdayTextScrollPanel, 0, 0, 1.0, 1.0, GridBagConstraints.BOTH);

            var dL = persList.stream().filter(isOver18).map(Person::getBirthday);
            {
                var sb = new StringBuilder();
                dL.forEach(p -> sb.append(String.format("%s%n", p.toString())));
                over18BirthdayText.setText(sb.toString());
            }

            var beginsWithAAndTop3 = new GroupPanel("Menschen deren Namen mit A beginnt (Top 3)");
            this.add(beginsWithAAndTop3, 0, 1);
            var beginsWithAAndTop3Text = new JTextArea();
            var beginsWithAAndTop3TextScrollPanel = new JScrollPane(beginsWithAAndTop3Text);
            beginsWithAAndTop3.add(beginsWithAAndTop3TextScrollPanel, 0, 0, 1.0, 1.0, GridBagConstraints.BOTH);

            var eL = persList.stream()
                    .filter(p -> p.getFirstname().startsWith("A") || p.getLastname().startsWith("A"))
                    .limit(3);
            {
                var sb = new StringBuilder();
                eL.forEach(p -> sb.append(String.format("%s%n", p.toString())));
                beginsWithAAndTop3Text.setText(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        var app = new Aufgabe11();

        app.setVisible(true);
        app.pack();
    }
}
