package controller;

import model.TrainModel;
import view.TrainView;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainController {
    private TrainModel model;
    private TrainView view;

    public TrainController(TrainModel model, TrainView view) {
        this.model = model;
        this.view = view;

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.moveTrain();
            }
        });
        timer.start();
    }
}
