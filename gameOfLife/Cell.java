public class Cell {

    private int x;
    private int y;
    private boolean alive;
    private int neigbours;
    public Cell(int x,int y,boolean alive){
        this.x = x;
        this.y = y;
        this.neigbours = 0;
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNeigbours() {
        return neigbours;
    }

    public void setNeigbours(int neigbours) {
        this.neigbours = neigbours;
    }
}
