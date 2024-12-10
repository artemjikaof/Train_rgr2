import model.TrainModel;
import controller.TrainController;
import view.TrainView;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // модель
        TrainModel model = new TrainModel();

        // отрисовка
        TrainView view = new TrainView(model);

        // контроллер
        TrainController controller = new TrainController(model);

        // Окно с названием
        JFrame frame = new JFrame("Train-rgr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(view);
        frame.setVisible(true);
    }
}
