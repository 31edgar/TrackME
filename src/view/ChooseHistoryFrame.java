package view;

import model.HabitManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseHistoryFrame extends JDialog{
    private JButton byHabitButton;
    private JButton byDateButton;
    private JPanel choosingPane;

    private HabitManager habitManager;

    public ChooseHistoryFrame(JFrame parent, HabitManager habitManager) {
        super(parent);

        setContentPane(choosingPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Choose");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());

        this.habitManager = habitManager;

        setupListeners(parent, habitManager);
    }

    private void setupListeners(JFrame parent, HabitManager habitManager) {
        byHabitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryFrame historyFrame = new HistoryFrame(parent, habitManager);
                historyFrame.setVisible(true);
                dispose();
            }
        });

        byDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarFrame calendarFrame = new CalendarFrame(parent, habitManager);
                calendarFrame.setVisible(true);
                dispose();
            }
        });
    }
}
