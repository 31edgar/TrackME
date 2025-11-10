package controller;

import model.HabitManager;
import model.Habit;
import view.ChooseHistoryFrame;
import view.HabitNameChangingFrame;
import view.MainFrame;
import view.ThemeFrame;

import java.io.File;
import java.time.LocalDate;

public class MainController {
    private LocalDate today = LocalDate.now();
    private HabitManager habitManager;
    private MainFrame mainFrame;

    public MainController(HabitManager habitManager, MainFrame mainFrame) {
        this.habitManager = habitManager;
        this.mainFrame = mainFrame;

        fileLoading();

        setupListeners();
        updateCheckboxToday();
        updateCheckboxText();

        mainFrame.applyTheme(habitManager.getThemeManager().getCurrentTheme());
        System.out.println("Current Theme: " + habitManager.getThemeManager().getCurrentTheme().getName());
    }

    public boolean isDayChecked(LocalDate date, int habitId) {
        Habit habit = habitManager.getHabit(habitId);
        return habit.isDayChecked(date);
    }

    private void fileLoading() {
        File file = new File(".//.//.//savefiles/habitManager.json");
        if (file.exists()) {
            try {
                habitManager = HabitManager.load();
            } catch (Exception e) {
                System.out.println("Todos quieren un verso del golden boi...");
            }

            if (today.equals(habitManager.getToday())) {
                updateCheckboxToday();
            } else {
                startNewDay();
            }
        }
    }

    private void updateCheckboxToday() {
        mainFrame.setHabit0Selected(isDayChecked(today, 0));
        mainFrame.setHabit1Selected(isDayChecked(today, 1));
        mainFrame.setHabit2Selected(isDayChecked(today, 2));
        mainFrame.setHabit3Selected(isDayChecked(today, 3));
        mainFrame.setHabit4Selected(isDayChecked(today, 4));
        mainFrame.setHabit5Selected(isDayChecked(today, 5));
        mainFrame.setHabit6Selected(isDayChecked(today, 6));
        mainFrame.setHabit7Selected(isDayChecked(today, 7));
    }

    private void startNewDay() {
        habitManager.setToday(today);
    }

    private void setupListeners() {
        mainFrame.addCB0listener(e -> toggleHabit(0, mainFrame.isHabit0Selected()));
        mainFrame.addCB1listener(e -> toggleHabit(1, mainFrame.isHabit1Selected()));
        mainFrame.addCB2listener(e -> toggleHabit(2, mainFrame.isHabit2Selected()));
        mainFrame.addCB3listener(e -> toggleHabit(3, mainFrame.isHabit3Selected()));
        mainFrame.addCB4listener(e -> toggleHabit(4, mainFrame.isHabit4Selected()));
        mainFrame.addCB5listener(e -> toggleHabit(5, mainFrame.isHabit5Selected()));
        mainFrame.addCB6listener(e -> toggleHabit(6, mainFrame.isHabit6Selected()));
        mainFrame.addCB7listener(e -> toggleHabit(7, mainFrame.isHabit7Selected()));

        mainFrame.addMarkAllDoneListener(e -> markAllDone());
        mainFrame.addShowHistoryListener(e -> showHistory());
        mainFrame.addRenameHabitsListener(e -> showHabitNameChanging());
        mainFrame.addThemesListener(e -> showThemes());
    }

    public void updateCheckboxText() {
        for (int i=0; i<8; i++) {
            mainFrame.setCheckboxText(i, habitManager.getHabit(i).getName());
        }
    }

    private void toggleHabit(int index, boolean selected) {
        if (selected) habitManager.checkToday(index);
        else habitManager.uncheckToday(index);
    }

    private void markAllDone() {
        habitManager.checkAllDoneToday();
        updateCheckboxToday();
    }

    private void showHistory() {
        ChooseHistoryFrame chooseHistoryFrame = new ChooseHistoryFrame(mainFrame);
        ChooseHistoryFrameController controller = new ChooseHistoryFrameController(mainFrame, chooseHistoryFrame,  habitManager);
        chooseHistoryFrame.setVisible(true);
    }

    private void showHabitNameChanging() {
        HabitNameChangingFrame frame = new HabitNameChangingFrame(mainFrame);
        HabitNameChangingController controller = new HabitNameChangingController(mainFrame, frame, habitManager);
        frame.setVisible(true);
    }

    private void showThemes() {
        ThemeFrame frame = new ThemeFrame(mainFrame);
        ThemesController controller = new ThemesController(mainFrame, habitManager, frame);
        frame.setVisible(true);
    }
}
