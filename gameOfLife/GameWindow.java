import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private JFrame frame;
    private JLabel header;
    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JPanel[][] cellGridArray;

    private int cols = 30;
    private int rows = 30;

    GameLogicHandler newGameLogic = new GameLogicHandler(rows, cols);

    public GameWindow() {
        loadUi();
        updateScreen(newGameLogic.getCellArray());
    }

    private void loadUi() {
        frame = new JFrame("Sluggans Game of Life");
        frame.setLayout(new BorderLayout());

        header = new JLabel("Welcome to Sluggans Game of Life", JLabel.CENTER);
        gamePanel = new JPanel(new GridLayout(rows, cols));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cellGridArray = new JPanel[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.BLACK);
                cell.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                cellGridArray[x][y] = cell;
                gamePanel.add(cell);
            }
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(header, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        handleButtons();
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    private void updateScreen(Cell[][] cellArray) {
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                JPanel cell = cellGridArray[x][y];
                if (cellArray[x][y].isAlive()) {
                    cell.setBackground(Color.GREEN);
                } else {
                    cell.setBackground(Color.BLACK);
                }
            }
        }
    }

    private void handleButtons() {
        buttonPanel = new JPanel();

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> updateScreen(newGameLogic.updateGame()));
        buttonPanel.add(startButton);

        JButton stopButton = new JButton("Stop");
        buttonPanel.add(stopButton);
    }


}
