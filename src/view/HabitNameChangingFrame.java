package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HabitNameChangingFrame extends JDialog{
    private JPanel HabitNameChangingPanel;
    private JTextField textFieldH0;
    private JTextField textFieldH1;
    private JTextField textFieldH2;
    private JTextField textFieldH4;
    private JTextField textFieldH3;
    private JTextField textFieldH5;
    private JTextField textFieldH6;
    private JTextField textFieldH7;
    private JButton confirmButton;
    private JButton CancelButton;
    private JLabel label;

    public HabitNameChangingFrame(JFrame parent) {
        super(parent);

        setContentPane(HabitNameChangingPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Change habits names");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());
    }

    public void addConfirmButtonListener(ActionListener l) {
        confirmButton.addActionListener(l);
    }
    public void addCancelButtonListener(ActionListener l) {
        CancelButton.addActionListener(l);
    }

    public String getTextFromTextField(int index) {
        return switch (index) {
            case 0 -> textFieldH0.getText();
            case 1 -> textFieldH1.getText();
            case 2 -> textFieldH2.getText();
            case 3 -> textFieldH3.getText();
            case 4 -> textFieldH4.getText();
            case 5 -> textFieldH5.getText();
            case 6 -> textFieldH6.getText();
            case 7 -> textFieldH7.getText();
            default -> null;
        };
    }

    public void setTextOnTextField(int index, String text) {
        switch (index) {
            case 0 -> textFieldH0.setText(text);
            case 1 -> textFieldH1.setText(text);
            case 2 -> textFieldH2.setText(text);
            case 3 -> textFieldH3.setText(text);
            case 4 -> textFieldH4.setText(text);
            case 5 -> textFieldH5.setText(text);
            case 6 -> textFieldH6.setText(text);
            case 7 -> textFieldH7.setText(text);
        }
    }
}
