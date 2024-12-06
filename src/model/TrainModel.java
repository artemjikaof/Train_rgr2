package model;

import java.util.Timer;
import java.util.TimerTask;

public class TrainModel {
    public enum State {WHITE, RED}

    private State state = State.WHITE;
    private boolean redToggle = false;
    private boolean whiteToggle = true;
    private int trainX = 0;
    private final int speed = 3;

    private Timer timer;

    public TrainModel() {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateState();
            }
        }, 0, 500);
    }

    public int getTrainX() {
        return trainX;
    }

    public boolean isWhiteOn() {
        return state == State.WHITE && whiteToggle;
    }

    public boolean isRedLeftOn() {
        return state == State.RED && redToggle;
    }

    public boolean isRedRightOn() {
        return state == State.RED && !redToggle;
    }

    public void moveTrain() {
        trainX += speed;
        if (trainX > 800) trainX = -200;
    }

    private void updateState()  { // сделать чтобы работало через наблюдатель, т.е нужен другой класс для этого и другой для отрисовки поезда
        moveTrain();
        int trainNose = trainX + 200;
        int trainEnd = trainX;

        if (trainNose < 250) {
            state = State.WHITE;
        } else if (trainNose >= 250 && trainEnd <= 450) {
            state = State.RED;
        } else if (trainEnd > 450) {
            state = State.WHITE;
        }

        if (state == State.RED) {
            redToggle = !redToggle;
        } else if (state == State.WHITE) {
            whiteToggle = !whiteToggle;
        }
    }
}
