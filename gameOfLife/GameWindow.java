import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

    private JFrame frame;
    private JLabel header;
    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JPanel[][] cellGridArray;
    private int cols = 30;
    private int rows = 30;
    private boolean[][] isCell = new boolean[rows][cols];
    private Timer gameTimer;

    GameLogicHandler newGameLogic = new GameLogicHandler(rows, cols);

    public GameWindow() {
        loadUi();
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
                JButton cellButton = new JButton();
                cellButton.setOpaque(false);
                cellButton.setContentAreaFilled(false);
                cellButton.setBorderPainted(false);
                int finalX = x;
                int finalY = y;
                cellButton.addActionListener(e -> {
                    if (cell.getBackground().equals(Color.black)) {
                        cell.setBackground(Color.GREEN);
                        isCell[finalX][finalY] = true;
                    } else {
                        cell.setBackground(Color.BLACK);
                        isCell[finalX][finalY] = false;
                    }
                });
                cell.add(cellButton);
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
        startButton.addActionListener(e -> {
            newGameLogic.setUpGame(isCell);
            startGameLoop();
        });
        buttonPanel.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stopGameLoop());
        buttonPanel.add(stopButton);
    }

    private void startGameLoop() {
        if (gameTimer != null && gameTimer.isRunning()) {
            return; // Avoid multiple timers running
        }
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] updatedCells = newGameLogic.updateGame();
                updateScreen(updatedCells);
            }
        });
        gameTimer.start();
    }

    private void stopGameLoop() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }


}
