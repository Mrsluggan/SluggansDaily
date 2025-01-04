import javax.swing.*;
import java.awt.*;

public class WindowHandler {


    private JFrame frame;
    private JLabel header;
    private JPanel middlePart;
    private JLabel buttonPanel;

    private JLabel hours;
    private JLabel minutes;
    private JLabel secounds;


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public WindowHandler() {
        loadWinow();
    }

    private void loadWinow() {
        frame = new JFrame("TimeClock");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 1));
        header = new JLabel("TimeClock", JLabel.CENTER);


        middlePart = new JPanel(new GridLayout(1, 3));
        hours = new JLabel("0 hours", JLabel.CENTER);
        minutes = new JLabel("0 minutes", JLabel.CENTER);
        secounds = new JLabel("0 seconds", JLabel.CENTER);
        middlePart.add(hours);
        middlePart.add(minutes);
        middlePart.add(secounds);


        buttonPanel = new JLabel("", JLabel.CENTER);
        buttonPanel.setLayout(new FlowLayout());
        frame.add(header);
        frame.add(middlePart);
        frame.add(buttonPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);

    }

    public void updateTimer(int elepsedTime) {
        hours.setText(String.valueOf(elepsedTime / 3600) + " hours");
        minutes.setText(String.valueOf( (elepsedTime / 60) % 60 ) + " minutes");
        secounds.setText(String.valueOf((elepsedTime % 60))+ " seconds");

    }


    public JLabel getHours() {
        return hours;
    }

    public void setHours(JLabel hours) {
        this.hours = hours;
    }

    public JLabel getMinutes() {
        return minutes;
    }

    public void setMinutes(JLabel minutes) {
        this.minutes = minutes;
    }

    public JLabel getSecounds() {
        return secounds;
    }

    public void setSecounds(JLabel secounds) {
        this.secounds = secounds;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getHeader() {
        return header;
    }

    public void setHeader(JLabel header) {
        this.header = header;
    }

    public JLabel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JLabel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JPanel getMiddlePart() {
        return middlePart;
    }

    public void setMiddlePart(JPanel middlePart) {
        this.middlePart = middlePart;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Dimension screenSize) {
        this.screenSize = screenSize;
    }
}
