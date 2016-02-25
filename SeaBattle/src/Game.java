import objects.Field;
import objects.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Game {

    public void startGame() throws IOException {
        Player player = new Player();
        Field playerField = new Field();
        Field PCField = new Field();
        Field PCHiddenField = new Field();
        playerField.initPlayerField("[ ]");
        PCField.initPlayerField("[ ]");
        PCHiddenField.initPlayerField("[ ]");
//      String W = whatIsYourFavoriteLetter();
        playerField.setShips();
        PCField.setShips();
        printDoubleField(playerField, PCField);

        boolean gameIsOver = false;
        int playerShipsLeft = 20;
        int PCShipsLeft = 20;
        while (!gameIsOver) {
            int playerY = player.getPlayerShootingCoordinateY();
            int playerX = player.getPlayerShootingCoordinateX();
            player.makeShoot(PCField, playerY, playerX);
            if (Objects.equals(PCField.getField(playerX, playerY), "[X]")) {
                playerShipsLeft--;
            }
            System.out.println("Осталось кораблей у игрока " + playerShipsLeft);

            int compX = player.getPCShootingCoordinate();
            int compY = player.getPCShootingCoordinate();
            player.makeShoot(playerField, compX, compY);
            if (Objects.equals(playerField.getField(compX, compY), "[X]")) {
                PCShipsLeft--;
            }
            System.out.println("Осталось кораблей у компьютера " + PCShipsLeft);
            printDoubleField(playerField, PCField);
            if (playerShipsLeft == 0 | PCShipsLeft == 0) {
                gameIsOver = true;
                System.out.println("Игра Окончена");
                if (playerShipsLeft == PCShipsLeft) {
                    System.out.println("Ничья");
                }
                if (playerShipsLeft > PCShipsLeft) {
                    System.out.println("Победил Игрок");
                } else {
                    System.out.println("Победил компььютер");
                }
            }
        }
        System.out.println("Спасибо за игру");
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

    public String whatIsYourFavoriteLetter() throws IOException {
        System.out.println("Какая Ваша любимая буква?");
        String myFavoriteLetter = (new BufferedReader(new InputStreamReader(System.in))).readLine();
//        System.out.println(myFavoriteLetter);

        return myFavoriteLetter;
    }

    public static void showStat() {
        int shoots = 0;
        int shipsLeft;
        System.out.println("выстрелов сделано: " + shoots);
    }
}




