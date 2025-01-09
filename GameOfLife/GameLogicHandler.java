import javax.swing.*;

public class GameLogicHandler {


    private Cell[][] cellArray;
    private int rows;
    private int cols;
    private int generation;

    public GameLogicHandler(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

    }

    public void setUpGame(boolean[][] isCell) {

        cellArray = new Cell[rows][cols];
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (isCell[x][y]){
                    cellArray[x][y] = new Cell(x, y, true);

                }else {
                    cellArray[x][y] = new Cell(x, y, false);

                }

            }
        }



    }

    public Cell[][] updateGame() {

        Cell[][] newGenerationArray = new Cell[rows][cols];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                newGenerationArray[x][y]=check(x, y);
            }
        }
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                createNewGeneration(newGenerationArray[x][y]);
            }
        }
        setGeneration(generation + 1);
        cellArray = newGenerationArray;
        return cellArray;
    }

    private Cell check(int x, int y) {
        int startPosX = Math.max(0, x - 1);
        int startPosY = Math.max(0, y - 1);
        int endPosX = Math.min(cols - 1, x + 1);
        int endPosY = Math.min(rows - 1, y + 1);
        int deadNeigbours = 0;
        int aliveNeigbours = 0;

        Cell currentCell = cellArray[x][y];
        for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
            for (int colNum = startPosY; colNum <= endPosY; colNum++) {


                if (!(rowNum == x && colNum == y) && cellArray[rowNum][colNum] != null) {

                    if (cellArray[rowNum][colNum].isAlive()) {
                        aliveNeigbours += 1;
                    } else {

                        deadNeigbours += 1;

                    }
                }
            }
        }
        currentCell.setNeigboursAlive(aliveNeigbours);
        currentCell.setNeigboursDead(deadNeigbours);
        return currentCell;


    }

    private Cell createNewGeneration(Cell currentCell) {

        if (currentCell.isAlive()){
            if (currentCell.getNeigboursAlive() <= 2){
                currentCell.setAlive(false);
            }
            if (currentCell.getNeigboursAlive() == 2 || currentCell.getNeigboursAlive() == 3 ){
                currentCell.setAlive(true);
            }
            if (currentCell.getNeigboursAlive() > 3 ){
                currentCell.setAlive(false);
            }
        }

        if (!currentCell.isAlive()){
            if (currentCell.getNeigboursAlive() == 3 ){
                currentCell.setAlive(true);
            }
        }
        return currentCell;

    }


    public Cell[][] getCellArray() {
        return cellArray;
    }

    public void setCellArray(Cell[][] cellArray) {
        this.cellArray = cellArray;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}




