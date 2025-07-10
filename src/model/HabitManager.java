package model;

import java.io.*;
import java.time.LocalDate;

public class HabitManager implements Serializable {
    // Attributes
    public Habit skincare, japanese, autoescuela, coding, workout, noSoda, eatClean, running;
    LocalDate today;

    // Builder
    public HabitManager() {
        today = LocalDate.now();
        HabitSetup();
    }

    // Methods
    public LocalDate getToday() {
        return this.today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public String listToString(int num) {
        return switch (num) {
            case 0 -> "Select a habit and check your progress!";
            case 1 -> skincare.listToString();
            case 2 -> japanese.listToString();
            case 3 -> autoescuela.listToString();
            case 4 -> coding.listToString();
            case 5 -> workout.listToString();
            case 6 -> noSoda.listToString();
            case 7 -> eatClean.listToString();
            case 8 -> running.listToString();
            default -> "";
        };
    }

    public String getHabitsInADay(LocalDate day) {
        StringBuilder habits = new StringBuilder();

        if (skincare.isDayChecked(day)) habits.append("Skincare\n");
        if (japanese.isDayChecked(day)) habits.append("日本語\n");
        if (autoescuela.isDayChecked(day)) habits.append("Driving license\n");
        if (coding.isDayChecked(day)) habits.append("Coding\n");
        if (workout.isDayChecked(day)) habits.append("Workout\n");
        if (noSoda.isDayChecked(day)) habits.append("No soda\n");
        if (eatClean.isDayChecked(day)) habits.append("Eat clean\n");
        if (running.isDayChecked(day)) habits.append("Running");

        return habits.toString();
    }

    private void HabitSetup() {
        skincare = new Habit("Skincare");
        skincare.setDescription("To follow your skincare routine.");

        japanese = new Habit("Japanese");
        japanese.setDescription("To study japanese.");

        autoescuela = new Habit("Driving license");
        autoescuela.setDescription("To study for your driving test.");

        coding = new Habit("Coding");
        coding.setDescription("To code something (like this project).");

        workout = new Habit("Workout");
        workout.setDescription("To follow your workout routine.");

        noSoda = new Habit("No soda");
        noSoda.setDescription("To not drink any soda");

        eatClean = new Habit("Eating clean");
        eatClean.setDescription("To eat clean.");

        running = new Habit("Running");
        running.setDescription("To run");
    }

    public void checkToday(int num) {
        switch(num) {
            case 0:
                skincare.checkDay(today);
                break;
            case 1:
                japanese.checkDay(today);
                break;
            case 2:
                autoescuela.checkDay(today);
                break;
            case 3:
                coding.checkDay(today);
                break;
            case 4:
                workout.checkDay(today);
                break;
            case 5:
                noSoda.checkDay(today);
                break;
            case 6:
                eatClean.checkDay(today);
                break;
            case 7:
                running.checkDay(today);
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
                skincare.uncheckDay(today);
                break;
            case 1:
                japanese.uncheckDay(today);
                break;
            case 2:
                autoescuela.uncheckDay(today);
                break;
            case 3:
                coding.uncheckDay(today);
                break;
            case 4:
                workout.uncheckDay(today);
                break;
            case 5:
                noSoda.uncheckDay(today);
                break;
            case 6:
                eatClean.uncheckDay(today);
                break;
            case 7:
                running.uncheckDay(today);
                break;
        }

        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkAllDoneToday() {
        skincare.checkDay(today);
        japanese.checkDay(today);
        autoescuela.checkDay(today);
        coding.checkDay(today);
        workout.checkDay(today);
        noSoda.checkDay(today);
        eatClean.checkDay(today);
        running.checkDay(today);

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
