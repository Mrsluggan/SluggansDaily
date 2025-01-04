import javax.swing.*;

import java.util.Date;

class TimeClock {


    private int elapsedTime;


    private boolean isRunning = false;
    private Timer timer;

    public TimeClock() {
        WindowHandler windowHandler = new WindowHandler();
        handleButtons(windowHandler);
    }

    private void displayTime(WindowHandler windowHandler) {
        elapsedTime += 1;
        windowHandler.updateTimer(elapsedTime);

    }

    private void handleButtons(WindowHandler windowHandler) {

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");

        startButton.addActionListener(e -> {
            startTimer(windowHandler);
            startButton.setEnabled(false);
        });
        stopButton.addActionListener(e -> {
            startButton.setEnabled(true);
            stopTimer();
        });
        resetButton.addActionListener(e -> {
            resetTimer(windowHandler);
            startButton.setEnabled(true);

        });
        windowHandler.getButtonPanel().add(startButton);
        windowHandler.getButtonPanel().add(stopButton);
        windowHandler.getButtonPanel().add(resetButton);

    }

    private void startTimer(WindowHandler windowHandler) {
        if (isRunning) return;

        isRunning = true;
        timer = new Timer(1000, actionEvent -> displayTime(windowHandler));
        timer.start();
    }

    private void stopTimer() {
        if (timer != null) {
            isRunning = false;
            timer.stop();
        }

    }

    private void resetTimer(WindowHandler windowHandler) {
        if (timer != null) {
            isRunning = false;
            timer.stop();
            elapsedTime = 0;
            windowHandler.updateTimer(elapsedTime);

        }
    }
}