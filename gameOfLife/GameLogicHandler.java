import javax.swing.*;
import java.awt.*;

public class GameLogicHandler {


    private Cell[][] cellArray;
    private int rows;
    private int cols;
    private int generation;

    public GameLogicHandler() {
        setUpGame();
        printGame();
        checkNeigbour();
        updateGame();

    }


    private void printGame() {
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (cellArray[x][y].isAlive()) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" . ");
                }

            }
            System.out.println("");
        }
    }


    private void setUpGame() {
        rows = 3;
        cols = 3;
        cellArray = new Cell[rows][cols];
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (y % 2 == 1) {
                    cellArray[x][y] = new Cell(x, y, true);
                } else {
                    cellArray[x][y] = new Cell(x, y, false);
                }
            }
        }

    }

    private void checkNeigbour() {

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (cellArray[x][y].isAlive()) {
                    System.out.println("här finns en cell som lever: (" + x + ", " + y + ")");
                    check(x, y);

                } else {
                    System.out.println("här finns en cell som är död: (" + x + ", " + y + ")");
                    check(x, y);

                }

            }
        }
    }


    private void updateGame() {

        Cell[][] newGenerationArray = new Cell[rows][cols];
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {

                newGenerationArray[x][y] = check(x,y);
            }
        }
        printGame();

        cellArray = newGenerationArray;
    }

    private Cell check(int x, int y) {
        int startPosX = Math.max(0, x - 1);
        int startPosY = Math.max(0, y - 1);
        int endPosX = Math.min(cols - 1, x + 1);
        int endPosY = Math.min(rows - 1, y + 1);

        Cell currentCell = cellArray[x][y];
        for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
            for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                if (!(rowNum == x && colNum == y) && cellArray[rowNum][colNum] != null) {
                    System.out.println("cell har dessa bredvid sig: (" + rowNum + ", " + colNum + ")");
                    currentCell.setNeigbours(currentCell.getNeigbours() + 1);
                }
            }
        }
        System.out.println("Denna cell har så här många grannar" + currentCell.getNeigbours());
        return createNewGeneration(currentCell);
    }

    private Cell createNewGeneration(Cell currentCell) {

        if (currentCell.getNeigbours() <= 2) {
            currentCell.setAlive(false);
        } else if (currentCell.getNeigbours() == 3) {
            currentCell.setAlive(true);
        } else if (currentCell.getNeigbours() < 3) {
            currentCell.setAlive(false);
        } else if (currentCell.getNeigbours() == 3 && currentCell.isAlive() == false) {
            currentCell.setAlive(true);
        }
        return currentCell;

    }

}




