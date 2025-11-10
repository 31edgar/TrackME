package view;

import model.Theme;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ThemeFrame extends JDialog {
    private JLabel mainTitle;
    private JLabel textLabel;
    private JButton lightButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton darkButton;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JPanel themePanel;


    public ThemeFrame(JFrame parent) {
        super(parent);
        setContentPane(themePanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Theme changing frame");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());
    }

    public void addLightButtonListener(ActionListener l) {
        lightButton.addActionListener(l);
    }

    public void addDarkButtonListener(ActionListener l) {
        darkButton.addActionListener(l);
    }

    public void applyTheme(Theme theme) {
        // Title
        mainTitle.setForeground(theme.getPrimaryColor());
        textLabel.setForeground(theme.getPrimaryColor());

        // Buttons
        lightButton.setBackground(theme.getPrimaryColor());
        lightButton.setForeground(theme.getSecondaryColor());
        darkButton.setBackground(theme.getPrimaryColor());
        darkButton.setForeground(theme.getSecondaryColor());
        button2.setBackground(theme.getPrimaryColor());
        button2.setForeground(theme.getSecondaryColor());
        button3.setBackground(theme.getPrimaryColor());
        button3.setForeground(theme.getSecondaryColor());
        button4.setBackground(theme.getPrimaryColor());
        button4.setForeground(theme.getSecondaryColor());
        button6.setBackground(theme.getPrimaryColor());
        button6.setForeground(theme.getSecondaryColor());
        button7.setBackground(theme.getPrimaryColor());
        button7.setForeground(theme.getSecondaryColor());
        button8.setBackground(theme.getPrimaryColor());
        button8.setForeground(theme.getSecondaryColor());

        // Panel
        themePanel.setBackground(theme.getBackgroundColor());

        this.repaint();
    }
}
