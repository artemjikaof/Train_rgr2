package controller;

import model.TrainModel;

import javax.swing.Timer;

public class TrainController {
    private final TrainModel model;

    public TrainController(TrainModel model) {
        this.model = model;
        startSimulation();
    }

    private void startSimulation() {
        Timer timer = new Timer(500, e -> model.updateState()); // Обновляем каждые 500 мс
        timer.start();
    }
}
