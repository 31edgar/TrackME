package model;

import java.io.*;
import java.time.LocalDate;

public class HabitManager implements Serializable {
    // Attributes
    public Habit habit0, habit1, habit2, habit3, habit4, habit5, habit6, habit7;
    private LocalDate today;
    public ThemeManager themeManager;

    // Builder
    public HabitManager() {
        today = LocalDate.now();
        HabitSetup();
        this.themeManager = new ThemeManager();
    }

    // Methods
    public ThemeManager getThemeManager() {
        return themeManager;
    }

    public void setThemeManager(ThemeManager themeManager) {
        this.themeManager = themeManager;
    }

    public LocalDate getToday() {
        return this.today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public String listToString(int num) {
        return switch (num) {
            case 0 -> "Select a habit and check your progress!";
            case 1 -> habit0.listToString();
            case 2 -> habit1.listToString();
            case 3 -> habit2.listToString();
            case 4 -> habit3.listToString();
            case 5 -> habit4.listToString();
            case 6 -> habit5.listToString();
            case 7 -> habit6.listToString();
            case 8 -> habit7.listToString();
            default -> "";
        };
    }

    public String getHabitsInADay(LocalDate day) {
        StringBuilder habits = new StringBuilder();

        if (habit0.isDayChecked(day)) habits.append("Skincare\n");
        if (habit1.isDayChecked(day)) habits.append("日本語\n");
        if (habit2.isDayChecked(day)) habits.append("Driving license\n");
        if (habit3.isDayChecked(day)) habits.append("Coding\n");
        if (habit4.isDayChecked(day)) habits.append("Workout\n");
        if (habit5.isDayChecked(day)) habits.append("No soda\n");
        if (habit6.isDayChecked(day)) habits.append("Eat clean\n");
        if (habit7.isDayChecked(day)) habits.append("Running");

        return habits.toString();
    }

    private void HabitSetup() {
        habit0 = new Habit("Skincare");
        habit0.setDescription("To follow your skincare routine.");

        habit1 = new Habit("Japanese");
        habit1.setDescription("To study japanese.");

        habit2 = new Habit("Driving license");
        habit2.setDescription("To study for your driving test.");

        habit3 = new Habit("Coding");
        habit3.setDescription("To code something (like this project).");

        habit4 = new Habit("Workout");
        habit4.setDescription("To follow your workout routine.");

        habit5 = new Habit("No soda");
        habit5.setDescription("To not drink any soda");

        habit6 = new Habit("Eating clean");
        habit6.setDescription("To eat clean.");

        habit7 = new Habit("Running");
        habit7.setDescription("To run");
    }

    public Habit getHabit(int id) {
        return switch (id) {
            case 0 -> habit0;
            case 1 -> habit1;
            case 2 -> habit2;
            case 3 -> habit3;
            case 4 -> habit4;
            case 5 -> habit5;
            case 6 -> habit6;
            case 7 -> habit7;
            default -> null;
        };
    }

    public void checkToday(int num) {
        switch(num) {
            case 0:
                habit0.checkDay(today);
                break;
            case 1:
                habit1.checkDay(today);
                break;
            case 2:
                habit2.checkDay(today);
                break;
            case 3:
                habit3.checkDay(today);
                break;
            case 4:
                habit4.checkDay(today);
                break;
            case 5:
                habit5.checkDay(today);
                break;
            case 6:
                habit6.checkDay(today);
                break;
            case 7:
                habit7.checkDay(today);
                break;
        }

        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void uncheckToday(int num) {
        switch(num) {
            case 0:
                habit0.uncheckDay(today);
                break;
            case 1:
                habit1.uncheckDay(today);
                break;
            case 2:
                habit2.uncheckDay(today);
                break;
            case 3:
                habit3.uncheckDay(today);
                break;
            case 4:
                habit4.uncheckDay(today);
                break;
            case 5:
                habit5.uncheckDay(today);
                break;
            case 6:
                habit6.uncheckDay(today);
                break;
            case 7:
                habit7.uncheckDay(today);
                break;
        }

        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkAllDoneToday() {
        habit0.checkDay(today);
        habit1.checkDay(today);
        habit2.checkDay(today);
        habit3.checkDay(today);
        habit4.checkDay(today);
        habit5.checkDay(today);
        habit6.checkDay(today);
        habit7.checkDay(today);

        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(".//.//.//savefiles/habitManager.json");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);

        oos.close();
        fos.close();
    }

    public static HabitManager load() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(".//.//.//savefiles/habitManager.json");
        ObjectInputStream ois = new ObjectInputStream(fin);

        return (HabitManager) ois.readObject();
    }
}
