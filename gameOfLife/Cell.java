public class Cell {

    private int x;
    private int y;
    private boolean alive;
    private int neigboursAlive;
    private int neigboursDead;



    public Cell(int x,int y,boolean alive){
        this.x = x;
        this.y = y;
        this.neigboursAlive = neigboursAlive;
        this.neigboursDead = neigboursDead;
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

    public int getNeigboursAlive() {
        return neigboursAlive;
    }

    public void setNeigboursAlive(int neigboursAlive) {
        this.neigboursAlive = neigboursAlive;
    }

    public int getNeigboursDead() {
        return neigboursDead;
    }

    public void setNeigboursDead(int neigboursDead) {
        this.neigboursDead = neigboursDead;
    }
}
