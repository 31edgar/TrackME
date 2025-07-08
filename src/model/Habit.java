package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class Habit implements Serializable {
    // Attributes
    private String name;
    private String description;
    private DayList dayList;
    private String color;

    /**
     * Constructor por defecto
     */
    public Habit(String name) {
        this.name = name;
        this.dayList = new DayList();
    }

    // Getters & Setters ------------------------------------------------------------------------------------------

    /**
     * Devuelve el nombre del hábito.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del hábito.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve la descripción del hábito.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambia la descripción del hábito.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve el color asignado al hábito.
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Cambia el color del hábito.
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve un String con los días en los que se ha cumplido el hábito seleccionado.
     * @return
     */
    public String listToString() {
        return dayList.toString();
    }

    // Other methods -----------------------------------------------------------------------------------------------

    /**
     * Marca un día como cumplido.
     * @param date
     */
    public void checkDay(LocalDate date) {
        dayList.check(date);
    }

    /**
     * Desmarca un día como no cumplido.
     * @param date
     */
    public void uncheckDay(LocalDate date) {
        dayList.uncheck(date);
    }

    /**
     * Indica si un día está marcado como cumplido.
     * @param date
     * @return boolean
     */
    public boolean isDayChecked(LocalDate date) {
        return dayList.isChecked(date);
    }

    /**
     * Cuenta los días completados en el mes actual.
     * @return
     */
    public int countCompletedThisMonth() {
        return dayList.countThisMonth();
    }

    /**
     * Cuenta los días completados en un rango de fechas.
     * @param start
     * @param end
     * @return
     */
    public int countCompletedBetween(LocalDate start, LocalDate end) {
        return dayList.count(start, end);
    }

    /**
     * Limpia todos los días marcados como cumplidos.
     */
    public void clearProgress() {
        dayList.clear();
    }

    /**
     * Devuelve la colección (inmutable) de días completados.
     * @return
     */
    public Set<LocalDate> getCompletedDays() {
        return dayList.getAllDaysCompleted();
    }

}
