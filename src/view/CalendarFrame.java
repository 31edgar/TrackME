package view;

import model.HabitManager;
import model.Theme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.Month;

public class CalendarFrame extends JDialog {
    private JPanel calendarPane;
    private JTable table1;
    private JComboBox comboBox1;
    private JTextPane textPane1;
    private JLabel mainTitle;
    private JLabel textLabel;
    private JPanel tablePane;


    public CalendarFrame(JFrame parent) {
        super(parent);

        setContentPane(calendarPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Calendar");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());
    }


    // -----------------------------------------------------------------------------------

    public void setTextPane1(String text) {
        textPane1.setText(text);
    }

    public void addComboBoxListener(ActionListener l) {
        comboBox1.addActionListener(l);
    }

    public void addTable1Listener(MouseAdapter l) {
        table1.addMouseListener(l);
    }


    public void t1SetModel(DefaultTableModel model) {
        table1.setModel(model);
    }

    public TableModel t1getModel() {
        return table1.getModel();
    }

    public int t1RowAtPoint(java.awt.Point p) {
        return table1.rowAtPoint(p);
    }

    public int t1RColAtPoint(java.awt.Point p) {
        return table1.columnAtPoint(p);
    }

    public DefaultTableModel getModel(Object[][] data) {
        return new DefaultTableModel(data, new String[]{"L", "M", "X", "J", "V", "S", "D"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
    }

    public void comboBoxSetSelectedIndex(int index) {
        comboBox1.setSelectedIndex(index);
    }

    public int comboBoxGetSelectedIndex() {
        return comboBox1.getSelectedIndex();
    }

    public void applyTheme(Theme theme) {
        // Title
        mainTitle.setForeground(theme.getPrimaryColor());
        textLabel.setForeground(theme.getPrimaryColor());

        // Combobox
        comboBox1.setForeground(theme.getSecondaryColor());
        comboBox1.setBackground(theme.getPrimaryColor());

        // Table
        tablePane.setBackground(theme.getPrimaryColor());
        tablePane.setForeground(theme.getSecondaryColor());

        // Panel
        calendarPane.setBackground(theme.getBackgroundColor());
        textPane1.setBackground(theme.getPrimaryColor());
        textPane1.setForeground(theme.getSecondaryColor());
        tablePane.setBackground(theme.getBackgroundColor());

        this.repaint();
    }
}
