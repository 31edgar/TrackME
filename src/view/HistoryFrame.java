package view;

import model.HabitManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryFrame extends JDialog{
    private JComboBox comboBox1;
    private JPanel historyPane;
    private JTextPane historyTextPane;

    HabitManager habitManager;

    public HistoryFrame(JFrame parent, HabitManager habitManager) {
        super(parent);
        setContentPane(historyPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - History check");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());

        this.habitManager = habitManager;

        setupListeners(parent);
        setTextPane();
    }

    private void setTextPane() {
        historyTextPane.setText(habitManager.listToString(comboBox1.getSelectedIndex()));
    }

    private void setupListeners(JFrame parent) {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextPane();
            }
        });
    }
}
