package view;

import model.TrainModel;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TrainView extends JPanel implements Observer {
    private final TrainModel model;

    public TrainView(TrainModel model) {
        this.model = model;
        model.addObserver(this); // Подписка на изменения модели
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawRoad(g);
        drawTrafficLight(g);
        drawTrain(g);
    }

    private void drawRoad(Graphics g) {
        // Дорога
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 325, 800, 50);

        //Переезд
        g.setColor(Color.BLACK);
        g.fillRect(350, 325, 100, 50);

        // Черта означающая контрольное расстояние до переезда
        g.setColor(Color.RED);
        g.fillRect(250, 325, 10, 50);
    }

    private void drawTrafficLight(Graphics g) {
        // корпус светофора
        g.setColor(Color.BLACK);
        g.fillRect(330, 80, 150, 150);

        // светло-голубой сигнал
        g.setColor(model.isWhiteOn() ? Color.CYAN : Color.GRAY);
        g.fillOval(380, 100, 50, 50);

        // красные сигналы
        g.setColor(model.isRedLeftOn() ? Color.RED : Color.GRAY);
        g.fillOval(350, 160, 50, 50); // Левый красный

        g.setColor(model.isRedRightOn() ? Color.RED : Color.GRAY);
        g.fillOval(410, 160, 50, 50); // Правый красный
    }

    // Поезд
    private void drawTrain(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(model.getTrainX(), 300, 200, 50);

        g.setColor(Color.BLACK);
        g.fillOval(model.getTrainX() + 20, 340, 30, 30);
        g.fillOval(model.getTrainX() + 150, 340, 30, 30);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint(); // Перерисовка при изменении модели
    }
}
