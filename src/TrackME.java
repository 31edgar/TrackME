import model.HabitManager;
import view.MainFrame;
import controller.MainController;

public class TrackME {
    public static void main(String[] args) {
        // 1. Crear el modelo
        HabitManager model = new HabitManager();

        // 2. Crear la vista
        MainFrame view = new MainFrame();

        // 3. Crear el controlador, pasando vista y modelo
        MainController controller = new MainController(model, view);

        // 4. Mostrar la ventana
        view.setVisible(true);
    }
}
