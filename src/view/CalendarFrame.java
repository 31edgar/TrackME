package view;

import model.HabitManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;

public class CalendarFrame extends JDialog {
    private JPanel calendarPane;
    private JTable table1;
    private JComboBox comboBox1;
    private JTextPane textPane1;

    HabitManager habitManager;

    public CalendarFrame(JFrame parent, HabitManager habitManager) {
        super(parent);

        setContentPane(calendarPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("TrackMe! - Calendar");

        ImageIcon logo = new ImageIcon(".//.//.//media/favicon-32x32.png");
        setIconImage(logo.getImage());

        this.habitManager = habitManager;

        setupListeners();
        setCalendar();
    }

    private Month getSelectedMonth() {
        int index = comboBox1.getSelectedIndex();

        switch (index) {
            case 0:
                break;
            case 1:
                return Month.JULY;
            case 2:
                return Month.AUGUST;
            case 3:
                return Month.SEPTEMBER;
            case 4:
                return Month.OCTOBER;
            case 5:
                return Month.NOVEMBER;
            case 6:
                return Month.DECEMBER;
        }

        return Month.JANUARY;
    }

    private void setupListeners() {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCalendar();
            }
        });

        // Listener made by @nis4273 on GitHub
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int dayNum;
                Month month;
                LocalDate date;

                int row = table1.rowAtPoint(evt.getPoint());
                int col = table1.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {

                    dayNum = (int) table1.getModel().getValueAt(row, col);
                    month = getSelectedMonth();
                    date = LocalDate.of(2025, month, dayNum);

                    textPane1.setText(habitManager.getHabitsInADay(date));
                }
            }
        });
    }

    private void setCalendar() {
        int index = comboBox1.getSelectedIndex();

        Object[][] july = {
                {"", 1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12, 13},
                {14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27},
                {28, 29, 30, 31}
        };

        Object[][] august = {
                {"", "", "", "", 1, 2, 3},
                {4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31}
        };

        Object[][] septemberAndDecember = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {21, 22, 23, 24, 25, 26, 27},
                {28, 29, 30}
        };

        Object[][] october = {
                {"", "", 1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26},
                {27, 28, 29, 30, 31}
        };

        Object[][] november = {
                {"", "", "", "", "", 1, 2},
                {3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23},
                {24, 25, 26, 27, 28, 29, 30}
        };

        String[] columnNames = {"L", "M", "X", "J", "V", "S", "D"};
        Object[][] data = {};

        switch (index) {
            case 0:
                break;
            case 1:
                data = july;
                break;
            case 2:
                data = august;
                break;
            case 3, 6:
                data = septemberAndDecember;
                break;
            case 4:
                data = october;
                break;
            case 5:
                data = november;
                break;
        }

        table1.setModel(new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
    }
}
