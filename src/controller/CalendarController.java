package controller;

import model.HabitManager;
import view.CalendarFrame;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.Month;

public class CalendarController {
    private HabitManager model;
    private CalendarFrame view;

    public CalendarController(HabitManager model, CalendarFrame view) {
        this.model = model;
        this.view = view;

        setupListeners();
        setCalendar(false);
    }

    private void setCalendar(Boolean byIndex) {
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

        Object[][] data = {};


        if (byIndex) {
            int index = view.comboBoxGetSelectedIndex();

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

        } else {
            LocalDate localDate = LocalDate.now();

            switch(localDate.getMonthValue()) {
                case 11:
                    data = november;
                    view.comboBoxSetSelectedIndex(5);
                    break;
                case 12:
                    data = septemberAndDecember;
                    view.comboBoxSetSelectedIndex(6);
                    break;
            }
        }

        view.t1SetModel(view.getModel(data));
    }

    private void setupListeners() {
        view.addComboBoxListener(e -> setCalendar(true));
        view.addTable1Listener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int dayNum;
                Month month;
                LocalDate date;

                int row = view.t1RowAtPoint(evt.getPoint());
                int col = view.t1RColAtPoint(evt.getPoint());

                if (row >= 0 && col >= 0) {
                    dayNum = (int) view.t1getModel().getValueAt(row, col);
                    month = getSelectedMonth();
                    date = LocalDate.of(2025, month, dayNum);

                    view.setTextPane1(model.getHabitsInADay(date));

                }
            }
        });
    }

    private Month getSelectedMonth() {
        int index = view.comboBoxGetSelectedIndex();

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
}
