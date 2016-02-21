import objects.Field;

/**
 * Created by Артем on 20.02.2016.
 */
public class Game {

    public void startGame() {
        Field playerField = new Field();
        Field PCField = new Field();
        Field PCHiddenField = new Field();
        playerField.initPlayerField("[ ]");
        PCField.initPlayerField("[ ]");
        PCHiddenField.initPlayerField("[ ]");
        playerField.setShips();
        PCField.setShips();
        printDoubleField(playerField, PCHiddenField);

        // Вечный цикл до выигрыша
    }

    public void printDoubleField(Field field1, Field Field2) {
        System.out.println("            ***Поле 1го игрока***                                  ***Поле 2го игрока***  ");
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(field1.getField(i, j) + " ");
                if (j >= 10) {
                    System.out.print("          ");

                    for (int d = 0; d < 11; d++) {
                        System.out.print(Field2.getField(i, d) + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
