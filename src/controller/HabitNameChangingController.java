package controller;

import model.HabitManager;
import view.HabitNameChangingFrame;
import view.MainFrame;

public class HabitNameChangingController {
    private MainFrame parent;
    private HabitNameChangingFrame view;
    private HabitManager model;

    public HabitNameChangingController(MainFrame parent, HabitNameChangingFrame view, HabitManager model) {
        this.parent = parent;
        this.view = view;
        this.model = model;

        setupListeners();
        updateTextFields();
    }

    private void setupListeners() {
        view.addConfirmButtonListener(e -> confirm());
        view.addCancelButtonListener(e -> cancel());
    }

    private void updateTextFields() {
        for (int i=0; i<8; i++) {
            view.setTextOnTextField(i, model.getHabit(i).getName());
        }
    }



    private void confirm() {
        for (int i=0; i < 8; i++) {
            String newName = view.getTextFromTextField(i);
            model.getHabit(i).setName(newName);
        }

        try {
            model.save();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        for (int i=0; i<8; i++) {
            parent.setCheckboxText(i, model.getHabit(i).getName());
        }

        view.dispose();
    }

    private void cancel() {
        view.dispose();
    }
}
