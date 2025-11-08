package controller;

import model.HabitManager;
import view.CalendarFrame;
import view.ChooseHistoryFrame;
import view.HistoryFrame;
import view.MainFrame;

public class ChooseHistoryFrameController {
    private MainFrame parent;
    private ChooseHistoryFrame view;
    private HabitManager model;

    public ChooseHistoryFrameController(MainFrame parent, ChooseHistoryFrame view, HabitManager model) {
        this.parent = parent;
        this.view = view;
        this.model = model;

        setupListeners();
    }

    private void setupListeners() {
        view.addByHabitListener(e -> showHistoryFrame());
        view.addByDateListener(e -> showCalendarFrame());
    }

    private void showHistoryFrame() {
        HistoryFrame historyFrame = new HistoryFrame(parent, model);
        HistoryFrameController controller = new HistoryFrameController(parent, historyFrame, model);
        historyFrame.setVisible(true);
        view.dispose();
    }

    private void showCalendarFrame() {
        CalendarFrame calendarFrame = new CalendarFrame(parent, model);
        calendarFrame.setVisible(true);
        view.dispose();
    }
}
