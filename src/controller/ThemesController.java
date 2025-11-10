package controller;

import model.HabitManager;
import view.MainFrame;
import view.ThemeFrame;

import java.io.IOException;

public class ThemesController {
    private HabitManager model;
    private ThemeFrame themeFrame;
    private MainFrame parent;

    public ThemesController(MainFrame parent, HabitManager model, ThemeFrame view) {
        this.model = model;
        this.themeFrame = view;
        this.parent = parent;


        setupListeners();
    }

    private void setupListeners() {
        themeFrame.addDarkButtonListener(e -> {
            try {
                applyTheme("Dark");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        themeFrame.addLightButtonListener(e -> {
            try {
                applyTheme("Light");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void applyTheme(String themeName) throws IOException {
        model.themeManager.setCurrentTheme(themeName);
        System.out.println(model.themeManager.getCurrentTheme().getName());
        parent.applyTheme(model.themeManager.getCurrentTheme());
        themeFrame.applyTheme(model.themeManager.getCurrentTheme());

        model.save();
    }
}
