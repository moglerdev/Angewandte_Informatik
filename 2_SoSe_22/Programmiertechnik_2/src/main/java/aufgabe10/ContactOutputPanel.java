package aufgabe10;

import javax.swing.*;
import java.awt.*;

public class ContactOutputPanel extends GroupPanel {

    public ContactOutputPanel() {
        super("Output");

        var text = ContactController.initOutputField(new JTextArea());
        text.setEditable(false);

        var scrollPanel = new JScrollPane(text);
        this.add(scrollPanel, 0, 0, 1, 1, GridBagConstraints.BOTH);

    }
}
