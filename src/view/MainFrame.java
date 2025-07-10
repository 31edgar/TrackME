package view;

import model.HabitManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JButton markAllDoneButton;
    private JButton showHistoryButton;
    private JCheckBox cbSkincare;
    private JCheckBox cbAnki;
    private JCheckBox cbAutoescuela;
    private JCheckBox cbCoding;
    private JCheckBox cbWorkout;
    private JCheckBox cbNosoda;
    private JCheckBox cbEatClean;
    private JCheckBox cbRunning;

    HabitManager habitManager;
    LocalDate today;

    public MainFrame() {
        // Window adjustments
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Main menu");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());

        // HabitManager adjustments
        habitManager = new HabitManager();
        today = LocalDate.now();

        setupListeners();

        // File loading adjustments
        fileLoading();
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
        if (habitManager.skincare.isDayChecked(today)) cbSkincare.setSelected(true);
        if (habitManager.japanese.isDayChecked(today)) cbAnki.setSelected(true);
        if (habitManager.autoescuela.isDayChecked(today)) cbAutoescuela.setSelected(true);
        if (habitManager.coding.isDayChecked(today)) cbCoding.setSelected(true);
        if (habitManager.workout.isDayChecked(today)) cbWorkout.setSelected(true);
        if (habitManager.noSoda.isDayChecked(today)) cbNosoda.setSelected(true);
        if (habitManager.eatClean.isDayChecked(today)) cbEatClean.setSelected(true);
        if (habitManager.running.isDayChecked(today)) cbRunning.setSelected(true);
    }

    private void startNewDay() {
        habitManager.setToday(today);
    }

    private void setupListeners() {
        // Listeners
        cbSkincare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbSkincare.isSelected()) {
                    habitManager.checkToday(0);
                } else {
                    habitManager.uncheckToday(0);
                }
            }
        });

        cbAnki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbAnki.isSelected()) {
                    habitManager.checkToday(1);
                } else {
                    habitManager.uncheckToday(1);
                }
            }
        });

        cbAutoescuela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbAutoescuela.isSelected()) {
                    habitManager.checkToday(2);
                } else {
                    habitManager.uncheckToday(2);
                }
            }
        });

        cbCoding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbCoding.isSelected()) {
                    habitManager.checkToday(3);
                } else {
                    habitManager.uncheckToday(3);
                }
            }
        });

        cbWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbWorkout.isSelected()) {
                    habitManager.checkToday(4);
                } else {
                    habitManager.uncheckToday(4);
                }
            }
        });

        cbNosoda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbNosoda.isSelected()) {
                    habitManager.checkToday(5);
                } else {
                    habitManager.uncheckToday(5);
                }
            }
        });

        cbEatClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbEatClean.isSelected()) {
                    habitManager.checkToday(6);
                } else {
                    habitManager.uncheckToday(6);
                }
            }
        });

        cbRunning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbRunning.isSelected()) {
                    habitManager.checkToday(7);
                } else {
                    habitManager.uncheckToday(7);
                }
            }
        });

        markAllDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbSkincare.setSelected(true);
                cbAnki.setSelected(true);
                cbAutoescuela.setSelected(true);
                cbCoding.setSelected(true);
                cbWorkout.setSelected(true);
                cbNosoda.setSelected(true);
                cbEatClean.setSelected(true);
                cbRunning.setSelected(true);

                habitManager.checkAllDoneToday();
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseHistoryFrame chooseHistoryFrame = new ChooseHistoryFrame(MainFrame.this, habitManager);
                chooseHistoryFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
