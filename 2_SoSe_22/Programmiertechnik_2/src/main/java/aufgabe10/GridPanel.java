package aufgabe10;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    public GridBagConstraints crateConstraints() {
        final GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 10, 0, 10);
        return c;
    }

    public Component add(@NotNull Component comp, int x, int y) {
        return this.add(comp, x, y, 0);
    }

    public Component add(@NotNull Component comp, int x, int y, double wx) {
        return this.add(comp, x, y, wx, 0);
    }

    public Component add(@NotNull Component comp, int x, int y, double wx, double wy) {
        return add(comp, x, y, wx, wy, GridBagConstraints.HORIZONTAL);
    }

    public Component add(@NotNull Component comp, int x, int y, double wx, double wy, int fill) {
        var c = crateConstraints();
        c.weightx = wx;
        c.weighty = wy;
        c.gridx = x;
        c.gridy = y;
        c.fill = fill;
        super.add(comp, c);
        return comp;
    }

    public GridPanel() {
        super();
        this.setLayout(new GridBagLayout());
    }
}
