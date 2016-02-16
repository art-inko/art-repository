package objects;

/**
 * Created by Алька on 23.11.2015.
 */

public class Field {

    String field[][] = new String[11][11];

    public void initPlayerField(String p) {
        for (int i = 0; i < 11; i++) {
            if (i == 0) {
                field[0][0] = "   ";
                field[0][1] = "A  ";
                field[0][2] = "B  ";
                field[0][3] = "C  ";
                field[0][4] = "D  ";
                field[0][5] = "E  ";
                field[0][6] = "F  ";
                field[0][7] = "G  ";
                field[0][8] = "H  ";
                field[0][9] = "I  ";
                field[0][10] = "J ";

//                for (int j = 0; j < 11; j++) {
//                    playerField[i][j] = "A";
//                    playerField[0][0] = "  ";
//                }
            } else {
                for (int j = 0; j < 11; j++)
                    if (j == 0) {
                        if (i != 10) {
                            field[i][j] = " " + String.valueOf(i);
                        } else {
                            field[i][j] = String.valueOf(i);
                        }
                    } else {
                        field[i][j] = p;
                    }
            }

        }
    }

    public void printField() {

        System.out.println("   ***Поле игрока***");
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printDoubleField() {
        System.out.println("            ***Поле 1го игрока***                                  ***Поле 2го игрока***  ");
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(field[i][j] + " ");
                if (j >= 10) {
                    System.out.print("          ");

                    for (int d = 0; d < 11; d++) {
                        System.out.print(field[i][d] + " ");
//                    System.out.print(playerField[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

//    public void placeShip() {
//
//        Ship ship1 = new Ship();
//        boolean isCurrentHorizontal = ship1.getOrientation();
////        int currentSize = ship1.getShipSize();
//        int currentSize = 1;
//        int X1;
//        int Y1;
//
//        switch (currentSize) {     //ПЕРЕКЛЮЧАТЕЛЬ
//
//            case 1:
//                X1 = ship1.getShipPlaceX(11);
//                Y1 = ship1.getShipPlaceY(11);
//                System.out.println("X1 = " + X1 + " Y1 = " + Y1);
//
//                field[X1][Y1] = "[H]";
//                ship1.surroundShipWithDots(X1, Y1, field);
//
//                break;
//
//            case 2:
//                X1 = ship1.getShipPlaceX(10);
//                Y1 = ship1.getShipPlaceY(10);
//                System.out.println("X1 = " + X1 + " Y1 = " + Y1);
//
//                if (isCurrentHorizontal == false) {
//                    field[X1][Y1] = "[H]";
//                    X1 = X1 + 1;
//                    field[X1][Y1] = "[H]";
//                } else {
//                    field[X1][Y1] = "[H]";
//                    Y1 = Y1 + 1;
//                    field[X1][Y1] = "[H]";
//                }
//                ship1.surroundShipWithDots(X1, Y1, field);
//                break;
//            case 3:
//                X1 = ship1.getShipPlaceX(9);
//                Y1 = ship1.getShipPlaceY(9);
//                System.out.println("X1 = " + X1 + " Y1 = " + Y1);
//                if (isCurrentHorizontal == false) {
//                    field[X1][Y1] = "[H]";
//                    X1 = X1 + 1;
//                    field[X1][Y1] = "[H]";
//                    X1 = X1 + 1;
//                    field[X1][Y1] = "[H]";
//                } else {
//                    field[X1][Y1] = "[H]";
//                    Y1 = Y1 + 1;
//                    field[X1][Y1] = "[H]";
//                    Y1 = Y1 + 1;
//                    field[X1][Y1] = "[H]";
//                }
//                ship1.surroundShipWithDots(X1, Y1, field);
//                break;
//            case 4:
//                X1 = ship1.getShipPlaceX(8);
//                Y1 = ship1.getShipPlaceY(8);
//                System.out.println("X1 = " + X1 + " Y1 = " + Y1);
//                if (isCurrentHorizontal == false) {
//                    field[X1][Y1] = "[H]";
//                    X1 = X1 + 1;
//                    field[X1][Y1] = "[H]";
//                    X1 = X1 + 1;
//                    field[X1][Y1] = "[H]";
//                    X1 = X1 + 1;
//                    field[X1][Y1] = "[H]";
//                } else {
//                    field[X1][Y1] = "[H]";
//                    Y1 = Y1 + 1;
//                    field[X1][Y1] = "[H]";
//                    Y1 = Y1 + 1;
//                    field[X1][Y1] = "[H]";
//                    Y1 = Y1 + 1;
//                    field[X1][Y1] = "[H]";
//                }
//                ship1.surroundShipWithDots(X1, Y1, field);
//                break;
//        }
//    }

//    public void setShips(){
//        Ship ship1=new Ship();
//        for (int i = 4; i ==0 ; i--) {
//
//        }
//    }

    public void setShips() {
        Ship ship = new Ship();
        for (int size = 4; size > 0; size--) {
            System.out.println(size);
            do {
                if (ship.checkSurround(size, field)) {
                    System.out.println("печатаем");
                    System.out.println();
                    for (int j = 0; j < size; j++) { // расстановка самого корабля работает
                        field[ship.X1 + j * ship.dx][ship.Y1 + j * ship.dy] = "[H]";
                    }
                    printField();
                    break;
                } else {
                    System.out.println("не печатаем");
                    System.out.println();
                }
            }
            while (true);
        }
    }
}

