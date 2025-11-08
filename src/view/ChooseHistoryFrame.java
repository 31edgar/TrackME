package view;

import model.HabitManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseHistoryFrame extends JDialog{
    private JButton byHabitButton;
    private JButton byDateButton;
    private JPanel choosingPane;

    public ChooseHistoryFrame(JFrame parent) {
        super(parent);

        setContentPane(choosingPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Choose");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());
    }

    public void addByHabitListener(ActionListener l) {
        byHabitButton.addActionListener(l);
    }
    public void addByDateListener(ActionListener l) {
        byDateButton.addActionListener(l);
    }
}
