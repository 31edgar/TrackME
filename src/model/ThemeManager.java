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

    public void applyTheme(JDialog dialog) {
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
        this.currentTheme = themes.get(themeName);
    }

    private void setupThemes() {
        themes.put("Light", new Theme(
                        "Light",
                        new Color(43, 43, 43),
                        new Color(238, 238, 238),
                        new Color(238, 238, 238),
                        new Color(40, 40, 40),
                        new Font("Segoe UI", Font.PLAIN, 14)
                )
        );

        themes.put("Dark", new Theme(
                        "Dark",
                        new Color(238, 238, 238),
                        new Color(43, 43, 43),
                        new Color(43, 43, 43),
                        new Color(238, 238, 238),
                        new Font("Segoe UI", Font.PLAIN, 14)
                )
        );
    }
}
