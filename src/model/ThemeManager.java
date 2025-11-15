package model;

import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class ThemeManager implements Serializable {
    private HashMap<String, Theme> themes = new HashMap<>();
    private Theme currentTheme;

    public ThemeManager() {
        setupThemes();
        if (currentTheme == null) {
            setCurrentTheme("Light");
        }
    }

    // todo ESTO ROMPE EL PATRON MVC
    public void applyTheme(JDialog dialog) {
        setupThemes();

        if (dialog instanceof HistoryFrame historyFrame) {
            historyFrame.applyTheme(currentTheme);
        }
        else if (dialog instanceof CalendarFrame calendarFrame) {
            calendarFrame.applyTheme(currentTheme);
        }
        else if (dialog instanceof ChooseHistoryFrame chooseHistoryFrame) {
            chooseHistoryFrame.applyTheme(currentTheme);
        }
        else if (dialog instanceof HabitNameChangingFrame habitNameChangingFrame) {
            habitNameChangingFrame.applyTheme(currentTheme);
        }
        else if (dialog instanceof ThemeFrame themeFrame) {
            themeFrame.applyTheme(currentTheme);
        }
    }

    public void addTheme(Theme theme) {
        themes.put(theme.getName(), theme);
    }

    public Theme getTheme(String name) {
        return themes.get(name);
    }

    public Collection<Theme> getAllThemes() {
        return themes.values();
    }

    public Theme getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(String themeName) {
        Theme theme = themes.get(themeName);
        if (theme != null) {
            this.currentTheme = theme;
        } else {
            System.err.println("Tema '" + themeName + "' no encontrado. No se cambia el tema.");
        }
    }


    private void setupThemes() {
        addTheme(new Theme(
                "Light",
                new Color(43, 43, 43),
                new Color(238, 238, 238),
                new Color(238, 238, 238),
                new Color(40, 40, 40),
                new Font("Segoe UI", Font.PLAIN, 14)
        ));

        addTheme(new Theme(
                "Dark",
                new Color(238, 238, 238),
                new Color(43, 43, 43),
                new Color(43, 43, 43),
                new Color(238, 238, 238),
                new Font("Segoe UI", Font.PLAIN, 14)
        ));

        addTheme(new Theme(
                "Nordic",
                new Color(39, 41, 53),
                new Color(238, 238, 238),
                new Color(76,86,106),
                new Color(238, 238, 238),
                new Font("Segoe UI", Font.PLAIN, 14)
        ));

        addTheme(new Theme(
                "Forest",
                new Color(34,49,29),
                new Color(238, 238, 238),
                new Color(79, 103, 74),
                new Color(238, 238, 238),
                new Font("Segoe UI", Font.PLAIN, 14)
        ));

    }
}
