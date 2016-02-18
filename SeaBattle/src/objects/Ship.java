package objects;

import java.util.Objects;
import java.util.Random;

public class Ship {
    int X1;
    int X2;
    int Y1;
    int Y2;
    int dx = 0;
    int dy = 0;
    boolean isHorizontal;

    public void getShipPlaceAndOrientation(int size) {
        this.dx = 0;
        this.dy = 0;
        Random rand = new Random();
        this.X1 = rand.nextInt(10) + 1;
        this.Y1 = rand.nextInt(10) + 1;
        int orientation = rand.nextInt(2);
        if (orientation == 0) {
            this.dx = 1;
            System.out.println("вертикальный");
            this.Y2 = Y1;
            this.X2 = X1 + size - 1;
            isHorizontal = false;
        } else {
            this.Y2 = Y1 + size - 1;
            this.X2 = X1;
            this.dy = 1;
            System.out.println("Горизонтальный");
            isHorizontal = true;
        }
        System.out.println("X1= " + X1 + " X2= " + X2 + " Y1= " + Y1 + " Y2= " + Y2);
    } //Получили координаты и ориентацию корабля

    public boolean coordIsOK(int size) {
        getShipPlaceAndOrientation(size);
        if (X2 > 10 || Y2 > 10) {
            System.out.println("Вторые координаты больше 10");
            return false;
        } else {
            System.out.println("Корабль влез на поле");
            return true;
        }
    } // Проверили влезает ли корабль на поле

    public boolean checkPlaceForShip(int size, String field[][]) {
        if (coordIsOK(size)) {
            for (int i = 0; i < size; i++) {
                if (!Objects.equals(field[X1 + i * dx][Y1 + i * dy], "[ ]")) {
                    System.out.println("Место под корабль занято");
                    break;
                }
                if (i == size - 1) {
                    return true;
                }
            }
        }
        return checkPlaceForShip(size, field);
    }// проверка места под сам корабль

    public boolean checkSurroundInsideField(int size, String field[][]) {
        if (checkPlaceForShip(size, field)) {
            boolean counter = false;
            if (X1 > 1 & X2 < 10 & Y1 > 1 & Y2 < 10) {
                if (isHorizontal) { //Проверка окружения у горизонтального корабля
                    int temp1 = 0;
                    for (int i = Y1 - 1; i <= Y2 + 1; i++) {
                        System.out.println("X1= " + X1 + " X2= " + X2 + " Y1= " + Y1 + " Y2= " + Y2);
                        System.out.println("Проверяем следующие места " + field[X1 - 1][i] + " " + field[X1 + 1][i] + " " + field[X1][Y1 - 1] + " " + field[X1][Y2 + 1]);
                        if ((Objects.equals(field[X1 - 1][i], "[ ]")) && (Objects.equals(field[X1 + 1][i], "[ ]")) && (Objects.equals(field[X1][Y1 - 1], "[ ]")) && (Objects.equals(field[X1][Y2 + 1], "[ ]"))) {
                            System.out.println("проверка проходит хорошо");
                            temp1++;
                        } else {
                            System.out.println("Проверка окружения не пройдена, рядом есть корабли");
                            break;
                        }
                        if (temp1 == size + 2) {
                            counter=true;
                        }
                    }
                } else {            //проверка окружения вертикального корабля
                    int temp2 = 0;
                    for (int i = X1 - 1; i <= X2 + 1; i++) {
                        System.out.println("X1= " + X1 + " X2= " + X2 + " Y1= " + Y1 + " Y2= " + Y2);
                        System.out.println("Проверяем следующие места " + " " + field[i][Y1 - 1] + " " + field[i][Y1 + 1] + " " + field[X1 - 1][Y1] + " " + field[X2 + 1][Y1]);
                        if ((Objects.equals(field[i][Y1 - 1], "[ ]")) && (Objects.equals(field[i][Y1 + 1], "[ ]")) && (Objects.equals(field[X1 - 1][Y1], "[ ]")) && (Objects.equals(field[X2 + 1][Y1], "[ ]"))) {
                            System.out.println("проверка проходит хорошо");
                            temp2++;
                        } else {
                            System.out.println("Проверка окружения не пройдена, рядом есть корабли");
                            break;
                        }
                        if (temp2 == size + 2) {
                            counter=true;
                        }
                    }
                }
            }
            if (counter) {
                return true;
            } else return false;
        }
        return checkSurroundInsideField(size, field);
    } //Если корабль попал внутрь поля, проверяем не пересекатеся ли


    public boolean checkPerimeter(int size, String field[][]) {
       int counter=0;
        if (X1 == 1) {
            int temp1 = 0;
            for (int i = Y1 - 1; i <= Y2 + 1; i++) {
                System.out.println("Проверяем следующие места " + field[X1 + 1][i] + " " + field[X1][Y1 - 1] + " " + field[X1][Y1 + 1]);
                if ((Objects.equals(field[X1 + 1][i], "[ ]")) && (Objects.equals(field[X1][Y1 - 1], "[ ]")) && (Objects.equals(field[X1][Y1 + 1], "[ ]"))) {
                    System.out.println("проверка проходит хорошо");
                    temp1++;
                } else {
                    System.out.println("Проверка окружения не пройдена, рядом есть корабли");
                    break;
                }
                if (temp1 == size + 1) {
                    counter++;
                }
            }
        }
        if (X1 == 10) {
            int temp1 = 0;
            for (int i = Y1 - 1; i <= Y2 + 1; i++) {
                System.out.println("Проверяем следующие места " + field[X1 + 1][i] + " " + field[X1][Y1 - 1] + " " + field[X1][Y1 + 1]);
                if ((Objects.equals(field[X1 - 1][i], "[ ]")) && (Objects.equals(field[X1][Y1 - 1], "[ ]")) && (Objects.equals(field[X1][Y1 + 1], "[ ]"))) {
                    System.out.println("проверка проходит хорошо");
                    temp1++;
                } else {
                    System.out.println("Проверка окружения не пройдена, рядом есть корабли");
                    break;
                }
                if (temp1 == size + 1) {
                    counter++;
                }
            }
        }
        return checkPerimeter(size, field);
    }
}
// Нужен метод проверки по периметру
