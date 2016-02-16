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
    }

    public boolean coordIsOK(int size) {
        getShipPlaceAndOrientation(size);
        if (X2 > 10 || Y2 > 10) {
            System.out.println("Вторые координаты больше 10");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkSurround(int size, String field[][]) {
        if (coordIsOK(size)) {
            int counter = 0;
            if (X1 > 1 & X2 < 10 & Y1 > 1 & Y2 < 10) {
                for (int i = 0; i < size; i++) {          // проверка места под сам корабль
                    if (!Objects.equals(field[X1 + i * dx][Y1 + i * dy], "[ ]")) {
                        System.out.println("Место под корабль занято");
                        break;
                    }
                    if (i == size - 1) {
                        counter++;
                    }
                }
                if (isHorizontal) {
                    int temp1 = 0;
                    for (int i = Y1 - 1; i <= Y2 + 1; i++) {

                        System.out.println("X1= " + X1 + " X2= " + X2 + " Y1= " + Y1 + " Y2= " + Y2);
                        System.out.println("Проверяем следующие места " + field[X1 - 1][i] + " " + field[X1 + 1][i] + " " + field[X1][Y1 - 1] + " " + field[X1][Y1 + 1]);
                        if ((Objects.equals(field[X1 - 1][i], "[ ]")) && (Objects.equals(field[X1 + 1][i], "[ ]")) && (Objects.equals(field[X1][Y1 - 1], "[ ]")) && (Objects.equals(field[X1][Y1 + 1], "[ ]"))) {
                            System.out.println("проверка проходит хорошо");
                            temp1++;
                        } else {
                            System.out.println("Проверка окружения не пройдена, рядом есть корабли");
                            break;
                        }
                        if (temp1 == size + 2) {
                            counter++;
                        }
                    }
                } else {
                    int temp2 = 0;
                    for (int i = X1 - 1; i <= X2 + 1; i++) {
                        System.out.println("X1= " + X1 + " X2= " + X2 + " Y1= " + Y1 + " Y2= " + Y2);
                        System.out.println("Проверяем следующие места " + " " + field[i][Y1 - 1] + " " + field[i][Y1 + 1] + " " + field[X1 - 1][Y1] + " " + field[X1 + 1][Y1]);
                        if ((Objects.equals(field[i][Y1 - 1], "[ ]")) && (Objects.equals(field[i][Y1 + 1], "[ ]")) && (Objects.equals(field[X1 - 1][Y1], "[ ]")) && (Objects.equals(field[X1 + 1][Y1], "[ ]"))) {
                            System.out.println("проверка проходит хорошо");
                            temp2++;
                        } else {
                            System.out.println("Проверка окружения не пройдена, рядом есть корабли");
                            break;
                        }
                        if (temp2 == size + 2) {
                            counter++;
                        }
                    }
                }
            }
            if (counter == 2) {
                return true;
            } else return false;
        }
        return checkSurround(size, field);
    }
}


//    public boolean checkCoord(int size) {   //метод проверки подойдут ли координаты
//        boolean marker = false;             //какой нибудь маркер показывающий что пока все плохо.
//        if (dx == 1) {                      //если корабль вертикальный (т.е. dx==1 то проверяем, помещается ли он по длине в Х,
//            if (X1 <= (11 - size)) {         //если Х меньше то все хорошо}
//                marker = true;              //если нет то продолжаем
//            }
//
//        } else {                            //если корабль горизонтальный (т.е. dу==1 то проверяем, помещается ли он по длине в У,
//            if (Y1 <= (11 - size)) {
//                marker = true;
//            }
//        }
//        return marker;
//
//    }

//    public boolean checkSurround(int size, String field[][]) {
//        getShipPlaceAndOrientation();
//        boolean surroundOK = false;
//
//        if (checkCoord(size)) {
//            int counter = 0;
//            if (X1 > 1 & X1 < 10 & Y1 > 1 & Y1 < 10) {          // проверка места под сам корабль
//                for (int i = 0; i < size; i++) {
//                    if (!Objects.equals(field[X1 + i * dx][Y1 + i * dy], "[ ]")) {
//                        System.out.println("Место под корабль занято");
//                        break;
//                    }
//                    if (i == size - 1) {
//                        counter++;
//                    }
//                }
//                for (int i = 0; i < size; i++) {            // проверка сверху для горизонтальных/слева для вертикальных
//                    if (!Objects.equals(field[X1 + i * dx - dy][Y1 + i * dy - dx], "[ ]")) {
//                        System.out.println("Проверку окружения НЕ прошел");
//                        break;
//                    }
//                    if (i == size - 1) {
//                        counter++;
//                    }
//                }
//                for (int i = 0; i < size; i++) {            // проверка слева
//                    if (!Objects.equals(field[X1 + i * dx + dy][Y1 + i * dy + dx], "[ ]")) {
//                        System.out.println("Проверку окружения НЕ прошел");
//                        break;
//                    }
//                    if (i == size - 1) {
//                        counter++;
//                    }
//                }
//                for (int i = 0; i < size; i++) {            // проверка сверху
//                    if (!Objects.equals(field[X1 + i * dy - dx][Y1 + i * dx - dy], "[ ]")) {
//                        System.out.println("Проверку окружения НЕ прошел");
//                        break;
//                    }
//                    if (i == size - 1) {
//                        counter++;
//                    }
//                }
//                for (int i = 0; i < size; i++) {            // проверка слева
//                    if (!Objects.equals(field[X1 + i * dy + dx][Y1 + i * dx + dy], "[ ]")) {
//                        System.out.println("Проверку окружения НЕ прошел");
//                        break;
//                    }
//                    if (i == size - 1) {
//                        counter++;
//                    }
//                }
//
//                //Нужна проверка углов, чтобы нее соприкасались по углам
//
//                if (counter == 5) {
//                    surroundOK = true;
//                    System.out.println("Окружение нормальное");
//                }
//            }
//        }
//        return surroundOK;
//    }






