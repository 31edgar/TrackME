package view;

import model.Theme;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JButton markAllDoneButton;
    private JButton showHistoryButton;
    private JCheckBox cbHabit0;
    private JCheckBox cbHabit1;
    private JCheckBox cbHabit2;
    private JCheckBox cbHabit3;
    private JCheckBox cbHabit4;
    private JCheckBox cbHabit5;
    private JCheckBox cbHabit6;
    private JCheckBox cbHabit7;
    private JButton renameHabitsButton;
    private JPanel willyrexPanel;
    private JButton themesButton;
    private JLabel textLabel;

    public MainFrame() {
        // Window adjustments
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Main menu");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());

    }

    // Checkbox getters
    public boolean isHabit0Selected() {
        return cbHabit0.isSelected();
    }
    public boolean isHabit1Selected() {
        return cbHabit1.isSelected();
    }
    public boolean isHabit2Selected() {
        return cbHabit2.isSelected();
    }
    public boolean isHabit3Selected() {
        return cbHabit3.isSelected();
    }
    public boolean isHabit4Selected() {
        return cbHabit4.isSelected();
    }
    public boolean isHabit5Selected() {
        return cbHabit5.isSelected();
    }
    public boolean isHabit6Selected() {
        return cbHabit6.isSelected();
    }
    public boolean isHabit7Selected() {
        return cbHabit7.isSelected();
    }

    // Checkbox setters
    public void setHabit0Selected(boolean selected) {
        cbHabit0.setSelected(selected);
    }
    public void setHabit1Selected(boolean selected) {
        cbHabit1.setSelected(selected);
    }
    public void setHabit2Selected(boolean selected) {
        cbHabit2.setSelected(selected);
    }
    public void setHabit3Selected(boolean selected) {
        cbHabit3.setSelected(selected);
    }
    public void setHabit4Selected(boolean selected) {
        cbHabit4.setSelected(selected);
    }
    public void setHabit5Selected(boolean selected) {
        cbHabit5.setSelected(selected);
    }
    public void setHabit6Selected(boolean selected) {
        cbHabit6.setSelected(selected);
    }
    public void setHabit7Selected(boolean selected) {
        cbHabit7.setSelected(selected);
    }

    public void setCheckboxText(int index, String text) {
        switch (index) {
            case 0 -> cbHabit0.setText(text);
            case 1 -> cbHabit1.setText(text);
            case 2 -> cbHabit2.setText(text);
            case 3 -> cbHabit3.setText(text);
            case 4 -> cbHabit4.setText(text);
            case 5 -> cbHabit5.setText(text);
            case 6 -> cbHabit6.setText(text);
            case 7 -> cbHabit7.setText(text);
        }

    }

    // Adding listeners methods
    public void addCB0listener(ActionListener l) {
        cbHabit0.addActionListener(l);
    }
    public void addCB1listener(ActionListener l) {
        cbHabit1.addActionListener(l);
    }
    public void addCB2listener(ActionListener l) {
        cbHabit2.addActionListener(l);
    }
    public void addCB3listener(ActionListener l) {
        cbHabit3.addActionListener(l);
    }
    public void addCB4listener(ActionListener l) {
        cbHabit4.addActionListener(l);
    }
    public void addCB5listener(ActionListener l) {
        cbHabit5.addActionListener(l);
    }
    public void addCB6listener(ActionListener l) {
        cbHabit6.addActionListener(l);
    }
    public void addCB7listener(ActionListener l) {
        cbHabit7.addActionListener(l);
    }

    public void addMarkAllDoneListener(ActionListener l) {
        markAllDoneButton.addActionListener(l);
    }
    public void addThemesListener(ActionListener l) {
        themesButton.addActionListener(l);
    }

    public void addShowHistoryListener(ActionListener l) {
        showHistoryButton.addActionListener(l);
    }
    public void addRenameHabitsListener(ActionListener l) {
        renameHabitsButton.addActionListener(l);
    }

    // Applying a theme
    public void applyTheme(Theme theme) {
        // Title
        mainTitle.setForeground(theme.getPrimaryColor());
        textLabel.setForeground(theme.getPrimaryColor());

        // Checkboxes
        cbHabit0.setFont(theme.getFont());
        cbHabit0.setForeground(theme.getTextColor());
        cbHabit0.setBackground(theme.getBackgroundColor());
        cbHabit1.setFont(theme.getFont());
        cbHabit1.setForeground(theme.getTextColor());
        cbHabit1.setBackground(theme.getBackgroundColor());
        cbHabit2.setFont(theme.getFont());
        cbHabit2.setForeground(theme.getTextColor());
        cbHabit2.setBackground(theme.getBackgroundColor());
        cbHabit3.setFont(theme.getFont());
        cbHabit3.setForeground(theme.getTextColor());
        cbHabit3.setBackground(theme.getBackgroundColor());
        cbHabit4.setFont(theme.getFont());
        cbHabit4.setForeground(theme.getTextColor());
        cbHabit4.setBackground(theme.getBackgroundColor());
        cbHabit5.setFont(theme.getFont());
        cbHabit5.setForeground(theme.getTextColor());
        cbHabit5.setBackground(theme.getBackgroundColor());
        cbHabit6.setFont(theme.getFont());
        cbHabit6.setForeground(theme.getTextColor());
        cbHabit6.setBackground(theme.getBackgroundColor());
        cbHabit7.setFont(theme.getFont());
        cbHabit7.setForeground(theme.getTextColor());
        cbHabit7.setBackground(theme.getBackgroundColor());

        // Buttons
        markAllDoneButton.setBackground(theme.getPrimaryColor());
        markAllDoneButton.setForeground(theme.getSecondaryColor());
        themesButton.setBackground(theme.getPrimaryColor());
        themesButton.setForeground(theme.getSecondaryColor());
        renameHabitsButton.setBackground(theme.getPrimaryColor());
        renameHabitsButton.setForeground(theme.getSecondaryColor());
        showHistoryButton.setBackground(theme.getPrimaryColor());
        showHistoryButton.setForeground(theme.getSecondaryColor());

        // Panel
        mainPanel.setBackground(theme.getBackgroundColor());
        willyrexPanel.setBackground(theme.getBackgroundColor());

        this.repaint();
    }
}
