import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class WindowHandler {

    JFrame frame;
    JPanel outputPanel;
    JPanel inPutPanel;
    JPanel buttonPanel;


    JTextArea inputArea;
    JTextArea outputArea;

    String input;
    String output;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public WindowHandler() {
        loadGUI();
    }


    private void handleTextArea() {

        outputArea = new JTextArea(30, 30);
        outputArea.setMargin(new Insets(10, 10, 10, 10));
        outputArea.setEditable(false);
        outputPanel.add(outputArea);
    }


    private void handleInput() {

        inputArea = new JTextArea(30, 30);
        inputArea.setMargin(new Insets(10, 10, 10, 10));
        inPutPanel.add(inputArea);


    }

    public void handleInputText() {

    }

    public void handlePrintOutput(List<String[]> listOfCharecters) {
        output = "";
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < listOfCharecters.size(); y++) {
                output += listOfCharecters.get(y)[x];
            }
            output += "\n";

        }
        System.out.print(output);
        outputArea.setText(output);
    }

    private void loadGUI() {
        frame = new JFrame("text To ASCII");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        outputPanel = new JPanel(new GridLayout(2, 1));
        outputPanel.add(new JLabel("Här kommer texten komma", JLabel.CENTER));
        handleTextArea();
        frame.add(outputPanel);


        inPutPanel = new JPanel(new GridLayout(2, 1));
        inPutPanel.add(new JLabel("Här kommer texten komma", JLabel.CENTER));
        handleInput();
        frame.add(inPutPanel);

        frame.add(buttonPanel = new JPanel());


        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(800, 800);
        frame.setLocation(x, y);
        frame.setVisible(true);

    }


}
