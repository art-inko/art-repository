package objects;


import java.util.Objects;

public class stShip {        // Класс статистических кораблей, нужны для определения ранен/убил ли корабль и дальнейшего окружения его точками
    int X1;
    int X2;
    int Y1;
    int Y2;
    boolean isHorizontal;
    int size;
    int lives;

    public stShip(int x1, int x2, int y1, int y2, boolean isHorizontal, int size) {
        X1 = x1;
        X2 = x2;
        Y1 = y1;
        Y2 = y2;
        this.isHorizontal = isHorizontal;
        this.size = size;
        this.lives = size;
    }

    public stShip() {
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


    public void surroundWithDots(int size, Field field) {
        if (X1 > 1 & X2 < 10 & Y1 > 1 & Y2 < 10) {
            if (isHorizontal) {                     //точки для горизонтального корабля
                for (int i = Y1 - 1; i <= Y2 + 1; i++) {
                    field.setFieldCell(X1 - 1, i, "[*]");
                    field.setFieldCell(X1 + 1, i, "[*]");
                    field.setFieldCell(X1, Y1 - 1, "[*]");
                    field.setFieldCell(X1, Y2 + 1, "[*]");
                }
            } else {                                //точки для вертикального корабля
                for (int i = X1 - 1; i <= X2 + 1; i++) {
                    field.setFieldCell(i, Y1 - 1, "[*]");
                    field.setFieldCell(i, Y1 + 1, "[*]");
                    field.setFieldCell(X1 - 1, Y1, "[*]");
                    field.setFieldCell(X2 + 1, Y1, "[*]");
                }
            }
        }
        if (X1 == 1 || X2 == 10 || Y1 == 1 || Y2 == 10) {
            if (isHorizontal) {
                if (X1 == 1 & Y1 > 1 & Y2 < 10) {
                    for (int i = Y1 - 1; i <= Y2 + 1; i++) {
                        field.setFieldCell(X1 + 1, i, "[*]");
                        field.setFieldCell(X1, Y1 - 1, "[*]");
                        field.setFieldCell(X1, Y2 + 1, "[*]");
                    }
                }
                if (X1 == 10 & Y1 > 1 & Y2 < 10) {
                    for (int i = Y1 - 1; i <= Y2 + 1; i++) {
                        field.setFieldCell(X1 - 1, i, "[*]");
                        field.setFieldCell(X1, Y1 - 1, "[*]");
                        field.setFieldCell(X1, Y2 + 1, "[*]");
                    }
                }
                if (Y1 == 1 & X1 > 1 & X2 < 10) {
                    for (int i = Y1; i <= Y2 + 1; i++) {
                        field.setFieldCell(X1 - 1, i, "[*]");
                        field.setFieldCell(X1 + 1, i, "[*]");
                        field.setFieldCell(X1, Y2 + 1, "[*]");
                    }
                }
                if (Y2 == 10 & X1 > 1 & X2 < 10) {
                    for (int i = Y1 - 1; i <= Y2; i++) {
                        field.setFieldCell(X1 - 1, i, "[*]");
                        field.setFieldCell(X1 + 1, i, "[*]");
                        field.setFieldCell(X1, Y1 - 1, "[*]");
                    }
                }
                if (X1 == 1 & Y1 == 1) {

                    for (int i = Y1; i <= Y2 + 1; i++) {
                        field.setFieldCell(X1 + 1, i, "[*]");
                        field.setFieldCell(X1, Y2 + 1, "[*]");
                    }
                }
                if (X1 == 1 & Y2 == 10) {

                    for (int i = Y1 - 1; i <= Y2; i++) {
                        field.setFieldCell(X1 + 1, i, "[*]");
                        field.setFieldCell(X1, Y1 - 1, "[*]");
                    }
                }
                if (X1 == 10 & Y1 == 1) {
                    for (int i = Y1; i <= Y2 + 1; i++) {
                        field.setFieldCell(X1 - 1, i, "[*]");
                        field.setFieldCell(X1, Y2 + 1, "[*]");
                    }
                }

                if (X1 == 10 & Y2 == 10) {
                    for (int i = Y1 - 1; i <= Y2; i++) {
                        field.setFieldCell(X1 - 1, i, "[*]");
                        field.setFieldCell(X1, Y1 - 1, "[*]");
                    }
                }
            } else {
                if (Y1 == 1 & X1 > 1 & X2 < 10) {

                    for (int i = X1 - 1; i <= X2 + 1; i++) {
                        field.setFieldCell(i, Y1 + 1, "[*]");
                        field.setFieldCell(X1 - 1, Y1, "[*]");
                        field.setFieldCell(X2 + 1, Y1, "[*]");
                    }
                }
                if (Y1 == 10 & X1 > 1 & X2 < 10) {
                    for (int i = X1 - 1; i <= X2 + 1; i++) {
                        field.setFieldCell(i, Y1 - 1, "[*]");
                        field.setFieldCell(X1 - 1, Y1, "[*]");
                        field.setFieldCell(X2 + 1, Y1, "[*]");
                    }
                }
                if (X1 == 1 & Y1 > 1 & Y2 < 10) {
                    for (int i = X1; i <= X2 + 1; i++) {
                        field.setFieldCell(i, Y1 - 1, "[*]");
                        field.setFieldCell(i, Y1 + 1, "[*]");
                        field.setFieldCell(X2 + 1, Y1, "[*]");
                    }
                }
                if (X2 == 10 & Y1 > 1 & Y2 < 10) {
                    for (int i = X1 - 1; i <= X2; i++) {
                        field.setFieldCell(i, Y1 - 1, "[*]");
                        field.setFieldCell(i, Y1 + 1, "[*]");
                        field.setFieldCell(X1 - 1, Y1, "[*]");
                    }
                }
                if (X1 == 1 & Y1 == 1) {
                    for (int i = X1; i <= X2 + 1; i++) {
                        field.setFieldCell(i, Y1 + 1, "[*]");
                        field.setFieldCell(X2 + 1, Y1, "[*]");
                    }
                }
                if (X1 == 1 & Y1 == 10) {
                    for (int i = X1; i <= X2 + 1; i++) {
                        field.setFieldCell(i, Y1 - 1, "[*]");
                        field.setFieldCell(X2 + 1, Y1, "[*]");
                    }
                }
                if (X2 == 10 & Y1 == 1) {

                    for (int i = X1 - 1; i <= X2; i++) {
                        field.setFieldCell(i, Y1 + 1, "[*]");
                        field.setFieldCell(X1 - 1, Y1, "[*]");
                    }
                }
                if (X2 == 10 & Y1 == 10) {
                    for (int i = X1 - 1; i <= X2; i++) {
                        field.setFieldCell(i, Y1 - 1, "[*]");
                        field.setFieldCell(X1 - 1, Y1, "[*]");

                    }
                }
            }
        }
    }
}