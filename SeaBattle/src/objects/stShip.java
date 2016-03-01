package objects;


public class StShip {
    int X1;
    int X2;
    int Y1;
    int Y2;
    boolean isHorizontal;
    int size;
    int lives;

    public StShip(int x1, int x2, int y1, int y2, boolean isHorizontal, int size) {
        X1 = x1;
        X2 = x2;
        Y1 = y1;
        Y2 = y2;
        this.isHorizontal = isHorizontal;
        this.size = size;
        this.lives = size;
    }

    enum ShipStatus {
        alive, hurt, dead
    }

    public StShip() {
    }

    public int getX1() {
        return X1;
    }

    public void setX1(int x1) {
        X1 = x1;
    }

    public int getX2() {
        return X2;
    }

    public void setX2(int x2) {
        X2 = x2;
    }

    public int getY1() {
        return Y1;
    }

    public void setY1(int y1) {
        Y1 = y1;
    }

    public int getY2() {
        return Y2;
    }

    public void setY2(int y2) {
        Y2 = y2;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
