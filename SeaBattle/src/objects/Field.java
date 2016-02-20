package objects;

/**
 * Created by Алька on 23.11.2015.
 */

public class Field {

    String field[][] = new String[11][11];
//    Field playerField = new Field();
//    Field PCField = new Field();

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

    public void setShips() {
        Ship ship = new Ship();
        int temp = 1;
        for (int size = 4; size > 0; size--) {
            for (int i = 0; i < temp; i++) {
//                System.out.println(size);
                do {
                    if (ship.canSetShip(size, field)) {
//                        System.out.println("печатаем");
//                        System.out.println();
                        for (int j = 0; j < size; j++) { // расстановка самого корабля работает
                            field[ship.X1 + j * ship.dx][ship.Y1 + j * ship.dy] = "[H]";
                        }
                        //printField();
                        break;
                    } else {
//                        System.out.println("не печатаем");
//                        System.out.println();
                    }
                }
                while (true);
            }
            temp++;
        }
    }

    public String getField(int x, int y) {
        return (field[x][y]);
    }

    public void setField(String[][] field) {
        this.field = field;
    }
}




