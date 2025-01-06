import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWindow {

    private JFrame frame;
    private JLabel header;
    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JPanel[][] cellGridArray;
    private JPanel cellGrid;

    private int cols;
    private int rows;

    GameLogicHandler gameLogicHandler;

    public GameWindow() {
        loadUi();
        for (int i = 0; i < 3; i++) {
            updateScreen(1+i, 2+i);

        }
    }


    private void loadUi() {

        frame = new JFrame("Sluggans Game of Life");
        frame.setLayout(new GridLayout(3, 1));

        header = new JLabel("Welcome to Sluggans Game of life", JLabel.CENTER);
        gamePanel = new JPanel(new GridLayout(30, 30));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cellGridArray = new JPanel[cols][rows];


        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                cellGrid = new JPanel();
                cellGrid.setBackground(Color.black);
                cellGrid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                cellGridArray[x][y] = cellGrid;
                gamePanel.add(cellGrid);
            }
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(header);
        frame.add(gamePanel);
        handleButtons();
        frame.add(buttonPanel);
        frame.setSize(700, 1500);
        frame.setVisible(true);


    }


    private void updateScreen(int x, int y) {


        JPanel cell = cellGridArray[x][y];
        cell.setBackground(Color.GREEN);

        cellGridArray[x][y] = cell;

    }


    private void handleButtons() {
        buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("stop");
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
    }

    public JPanel getCellGrid() {
        return cellGrid;
    }

    public void setCellGrid(JPanel cellGrid) {
        this.cellGrid = cellGrid;
    }

    public JPanel[][] getCellGridArray() {
        return cellGridArray;
    }

    public void setCellGridArray(JPanel[][] cellGridArray) {
        this.cellGridArray = cellGridArray;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(JPanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public JLabel getHeader() {
        return header;
    }

    public void setHeader(JLabel header) {
        this.header = header;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
