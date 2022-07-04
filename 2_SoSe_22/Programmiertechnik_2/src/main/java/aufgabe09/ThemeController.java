package aufgabe09;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public final class ThemeController {
    private ThemeController() { }

    private static boolean isDarkMode = true;
    public static boolean IsDarkMode() {
        return isDarkMode;
    }

    private static final Color darkModeBackground = new Color(54, 54, 54, 255);
    private static final Color darkModeForeground = new Color(243, 243, 243, 255);

    private static final Color lightModeBackground = darkModeForeground;
    private static final Color lightModeForeground = darkModeBackground;

    private static class ComponentTheme {
        final Component component;
        Color backgroundColor;
        Color foregroundColor;
        boolean isStaticColor = false;

        public ComponentTheme(Component com, Color fg, Color bg) {
            this.component = com;
            setColors(fg, bg, false);
        }

        public void setIsStaticColor(boolean isStaticColor) {
            this.isStaticColor = isStaticColor;
        }

        public void setColors(Color fg, Color bg, boolean isStatic) {
            if (isStaticColor) return;
            this.isStaticColor = isStatic;
            this.component.setForeground(fg);
            this.foregroundColor = fg;
            this.component.setBackground(bg);
            this.backgroundColor = bg;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ComponentTheme that = (ComponentTheme) o;

            return Objects.equals(component, that.component);
        }

        @Override
        public int hashCode() {
            return component != null ? component.hashCode() : 0;
        }
    }
    private static final ArrayList<ComponentTheme> components = new ArrayList<>();

    public static Color getForegroundColor() {
        return isDarkMode ? darkModeForeground : lightModeForeground;
    }

    public static Color getBackgroundColor() {
        return isDarkMode ? darkModeBackground : lightModeBackground;
    }

    public static <T extends Component> T add(T component) {
        var _comp = new ComponentTheme(component,
                getForegroundColor(),
                getBackgroundColor());

        components.add(_comp);

        if (component instanceof JTextComponent) {
            ((JTextComponent) component).setCaretColor(Color.gray);
            if (((JTextComponent) component).isEditable()) {
                ((JTextComponent) component).setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createEmptyBorder(10, 5, 10, 5),
                                BorderFactory.createLineBorder( Color.gray)));
            }
        }
        else if (component instanceof JButton) {
            ((JButton) component).setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createEmptyBorder(5, 5, 5, 5),
                            BorderFactory.createLineBorder(Color.gray)
                    )
            );
        }

        return component;
    }

    public static void changeMode(boolean darkMode) {
        if (isDarkMode != darkMode) {
            isDarkMode = darkMode;
            if (isDarkMode) {
                changeColors(darkModeForeground, darkModeBackground);
            } else {
                changeColors(lightModeForeground, lightModeBackground);
            }
        }
    }

    private static void changeColors(Color foreground, Color background) {
        for (var c : components) {
            c.setColors(foreground, background, false);
        }
    }

    public static void setStaticColor(Component component, Color foreground, Color background) {
        for (var c : components) {
            if (c.component.equals(component)){
                c.setColors(foreground, background, true);
            }
        }
    }

    public static void removeStaticColor(Component component) {
        for (var c : components) {
            if (c.component.equals(component)){
                c.setIsStaticColor(false);
                c.setColors(getForegroundColor(), getBackgroundColor(), false);
            }
        }
    }
}
