package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Clase que gestiona un conjunto de fechas en las que se ha cumplido un hábito.
 * Permite marcar, desmarcar fechas y contar días completados en rangos específicos.
 * @author Edgar Esparza
 */

public class DayList implements Serializable {
    // Attributes
    private Set<LocalDate> daysCompleted;

    /**
     * Constructor por defecto que inicializa la colección de días completados vacía.
     */
    public DayList() {
        this.daysCompleted = new HashSet<>();
    }

    // ---------- Methods -------------------------------------------------------------------------------------------

    /**
     * Añade una fecha dada a la lista de días completados.
     * @param date
     */
    public void check(LocalDate date) {
        daysCompleted.add(date);
    }

    /**
     * Elimina una fecha dada de la lista de días completados.
     * @param date
     */
    public void uncheck(LocalDate date) {
        daysCompleted.remove(date);
    }

    /**
     * Comprueba si una fecha dada se encuentra en la lista de días completados.
     * @param date
     * @return boolean
     */
    public boolean isChecked(LocalDate date) {
        return daysCompleted.contains(date);
    }

    /**
     * Getter de la lista de días completados.
     * @return versión inmutable de la lista de días completados
     */
    public Set<LocalDate> getAllDaysCompleted() {
        return Collections.unmodifiableSet(this.daysCompleted);
    }

    /**
     * Recuento de cuantos días en los que se ha completado un hábito en el mes actual.
     * @return días completados en este mes
     */
    public int countThisMonth() {
        // Variables
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        // Method
        return count(firstDayOfMonth, today);
    }

    /**
     * Recuento de días en los que se ha completado un hábito en un intervalo de tiempo
     * incluyendo la fecha inicial y la final.
     * @param start
     * @param end
     * @return
     */
    public int count(LocalDate start, LocalDate end) {
        // Variables
        int counter = 0;

        // Method
        for (LocalDate date : daysCompleted) {
            if (!date.isBefore(start) && !date.isAfter(end))
                    counter++;
        }

        return counter;
    }

    /**
     * Vacía completamente la lista de días completados.
     */
    public void clear() {
        daysCompleted.clear();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();

        for (LocalDate date : daysCompleted) {
            text.append(date).append("\n");
        }

        return text.toString();
    }
}
