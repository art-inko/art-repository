package objects;

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

    public void setShips(StShip[] stShips, String r) {

        Ship ship = new Ship();
        int count = 0;
        int temp = 1;
        for (int size = 4; size > 0; size--) {
            for (int i = 0; i < temp; i++) {
                do {
                    if (ship.canSetShip(size, field)) {
                        stShips[count] = new StShip(ship.X1, ship.X2, ship.Y1, ship.Y2, ship.isHorizontal, size);
//                        System.out.println("печатаем");
//                        System.out.println();
                        for (int j = 0; j < size; j++) { // расстановка самого корабля работает
                            field[ship.X1 + j * ship.dx][ship.Y1 + j * ship.dy] = "[" + r + "]";
                        }
                        break;
                    }
//                    else {
//                        System.out.println("не печатаем");
//                        System.out.println();
//                    }
                }
                while (true);
                count++;
            }
            temp++;
        }
    }

    public String getField(int x, int y) {
        return (field[x][y]);
    }

    public void setFieldCell(int x, int y, String v) {
        field[x][y] = v;
    }

    public void printStShips(StShip[] stShips) {
        for (int i = 0; i < stShips.length; i++) {
            System.out.println("корабль № " + i + " size = " + stShips[i].size + " X1 = " + stShips[i].X1 + " Y1 = " + stShips[i].Y1);
        }
        System.out.println();
    }

}




