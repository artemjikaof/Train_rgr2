import model.TrainModel;
import view.TrainView;
import controller.TrainController;

public class Main {
    public static void main(String[] args) {
        TrainModel model = new TrainModel();
        TrainView view = new TrainView(model);
        new TrainController(model, view);
    }
}
