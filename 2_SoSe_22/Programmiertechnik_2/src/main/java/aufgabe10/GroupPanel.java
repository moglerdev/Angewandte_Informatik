package aufgabe10;

import javax.swing.*;
import java.awt.*;

public class GroupPanel extends GridPanel {
    public GroupPanel(String title) {
        super();
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        title)
        ));
    }
}
