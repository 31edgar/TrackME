package view;

import model.HabitManager;
import model.Theme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryFrame extends JDialog{
    private JComboBox comboBox1;
    private JPanel historyPane;
    private JTextPane historyTextPane;
    private JLabel mainTitle;
    private JLabel textLabel;

    public HistoryFrame(JFrame parent, HabitManager habitManager) {
        super(parent);
        setContentPane(historyPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - History check");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());
    }

    public void setTextPane(String text) {
        historyTextPane.setText(text);
    }

    public int getSelectedIndex() {
        return comboBox1.getSelectedIndex();
    }

    public void addComboboxListener(ActionListener l) {
        comboBox1.addActionListener(l);
    }

    public void applyTheme(Theme theme) {
        // Title
        mainTitle.setForeground(theme.getPrimaryColor());
        textLabel.setForeground(theme.getPrimaryColor());

        // Buttons
        comboBox1.setForeground(theme.getSecondaryColor());
        comboBox1.setBackground(theme.getPrimaryColor());

        // Panel
        historyPane.setBackground(theme.getBackgroundColor());
        historyTextPane.setBackground(theme.getBackgroundColor());
        historyTextPane.setForeground(theme.getTextColor());

        this.repaint();
    }
}
