package model;

import java.util.Observable;

public class TrainModel extends Observable {
    private int trainX = 0; // Координата X поезда
    private final int speed = 20; // Скорость поезда
    private boolean whiteOn = true; // Состояние светло-голубого сигнала
    private boolean redLeftOn = false; // Состояние левого красного сигнала
    private boolean redRightOn = false; // Состояние правого красного сигнала
    private boolean toggleRed = true; // Переключатель для мигания красных огней

    private final int redMarker = 250; // Положение черты контрольного расстояния от переезда
    private final int crossingStart = 350; // Начало переезда
    private final int crossingEnd = 450; // Конец переезда
    private final int trainLength = 200; // Длина поезда

    public void updateState() {
        int trainNose = trainX + trainLength; // Нос поезда
        int trainEnd = trainX; // Конец поезда

        // Логика смены сигналов
        if (trainNose < redMarker) {
            // Поезд не пересек черту
            whiteOn = !whiteOn; // Светло-голубой мигает
            redLeftOn = false;
            redRightOn = false;
        } else if (trainNose >= redMarker && trainEnd <= crossingEnd) {
            // Поезд между чертой и переездом
            whiteOn = false; // Светло-голубой выключен
            if (toggleRed) {
                redLeftOn = true;
                redRightOn = false;
            } else {
                redLeftOn = false;
                redRightOn = true;
            }
            toggleRed = !toggleRed; // переключение состояния сигналов
        } else if (trainEnd > crossingEnd) {
            // Поезд полностью покинул переезд
            whiteOn = !whiteOn; // Светло-голубой мигает
            redLeftOn = false;
            redRightOn = false;
        }

        // Обновляем положение поезда
        trainX += speed;
        if (trainX > 800) {
            trainX = -trainLength; // Возвращаем поезд в начало
        }

        setChanged();
        notifyObservers();
    }

    public int getTrainX() {
        return trainX;
    }

    public boolean isWhiteOn() {
        return whiteOn;
    }

    public boolean isRedLeftOn() {
        return redLeftOn;
    }

    public boolean isRedRightOn() {
        return redRightOn;
    }
}
