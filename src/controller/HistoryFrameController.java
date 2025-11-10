package controller;

import model.HabitManager;
import view.HistoryFrame;
import view.MainFrame;

public class HistoryFrameController {
    private MainFrame parent;
    private HistoryFrame view;
    private HabitManager model;

    public HistoryFrameController(MainFrame parent, HistoryFrame historyFrame, HabitManager model) {
        this.parent = parent;
        this.view = historyFrame;
        this.model = model;

        setupListeners();
        setTextPanel();

        model.themeManager.applyTheme(view);
    }

    public void setupListeners() {
        view.addComboboxListener(e -> setTextPanel());
    }

    public void setTextPanel() {
        view.setTextPane(model.listToString(view.getSelectedIndex()));
    }
}
