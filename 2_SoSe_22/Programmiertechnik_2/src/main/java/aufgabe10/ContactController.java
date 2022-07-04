package aufgabe10;

import org.jetbrains.annotations.Nullable;

import javax.swing.text.JTextComponent;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public final class ContactController {
    private static JTextComponent field;
    private static String fileName;

    private static class Item {
        boolean visible = true;
        final Contact contact;

        public Item(Contact contact) {
            this.contact = contact;
        }

        @Override
        public String toString() {
            return this.contact.toString();
        }
    }

    private static HashMap<String, Item> contacts = new HashMap<>();

    private static void drawOutput() {
        StringBuilder builder = new StringBuilder();

        contacts.forEach((x, ci) -> {
            if (ci.visible) {
                builder.append(ci);
                builder.append("\n");
            }
        });

        field.setText(builder.toString());
    }

    private static String getKey(String name, String addOn) {
        return name + ";" + addOn;
    }
    private static void add(Contact c) {
        contacts.put(getKey(c.getName(), c.getAddOn()), new Item(c));
    }

    private ContactController() { }

    public static int loadContacts (File fs) throws IOException {
        contacts = new HashMap<>();
        fileName = fs.getAbsolutePath();
        var in = new Scanner(fs);
        while (in.hasNextLine()) {
            var l = in.nextLine();
            if (!l.isEmpty()) add(new Contact(l));
        }

        drawOutput();

        return contacts.size();
    }

    public static boolean saveContacts (@Nullable File fs) {
        File _fs = fs == null ? new File(fileName) : fs;

        try(FileWriter myObj = new FileWriter(_fs)) {
            StringBuilder builder = new StringBuilder();
            contacts.forEach((x, b) -> {
                builder.append(b.contact.toString(";"));
                builder.append("\n");
            });

            myObj.write(builder.toString());
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }

    public static int filterContacts (Function<Contact, Boolean> lam) {
        AtomicInteger founded = new AtomicInteger();

        contacts.replaceAll((k, v) -> {
            if (lam.apply(v.contact)) {
                founded.addAndGet(1);
                v.visible = true;
            } else {
                v.visible = false;
            }
            return v;
        });

        drawOutput();
        return founded.get();
    }

    public static JTextComponent initOutputField(JTextComponent f) {
        field = f;
        f.setText("");
        f.setEditable(false);
        return f;
    }

    public static void addContact(Contact contact) {
        add(contact);
        drawOutput();
    }

    public static boolean deleteContact(String name, String addOn) {
        if (contacts.remove(getKey(name, addOn)) != null) {
            drawOutput();
            return true;
        }
        return false;
    }
}
