import objects.Field;
import objects.Player;
import objects.Ship;

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
        String W = whatIsYourFavoriteLetter();
        playerField.setShips(W);
        PCField.setShips(W);
        printDoubleField(playerField, PCField);
        boolean gameIsOver = false;
        int playerShipsLeft = 20;
        int PCShipsLeft = 20;
        while (!gameIsOver) {
            int playerY = player.getPlayerShootingCoordinateY();
            int playerX = player.getPlayerShootingCoordinateX();
            if (!player.checkShoot(PCField, playerX, playerY, W)) {
                System.out.println("Вы сюда уже стреляли, введите другие координаты");
                continue;
            }
            int compX = player.getPCShootingCoordinate();
            int compY = player.getPCShootingCoordinate();
//            if (!player.checkShoot(playerField, compX, compY, W)) { // закомментировать
            while (!player.checkShoot(playerField, compX, compY, W)) {
//                System.out.println("Комп выстрелил туда, куда уже стрелял ранее, пробует еще раз");
                compX = player.getPCShootingCoordinate();
                compY = player.getPCShootingCoordinate();
//                System.out.println("new X== " + compX + " new Y== " + compY);
            }
//            }

            player.makeShoot(PCField, PCHiddenField, playerX, playerY, W);
            if (Objects.equals(PCField.getField(playerX, playerY), "[X]")) {
                PCShipsLeft--;
                System.out.print("Выстрел игрока: ");
                shipStatus(PCField, W, playerX, playerY);
            } else {
                System.out.println("Выстрел игрока: Мимо");
            }

            player.makeShoot(playerField, playerField, compX, compY, W);
            if (Objects.equals(playerField.getField(compX, compY), "[X]")) {
                playerShipsLeft--;
                System.out.print("Выстрел компьютера: ");
                shipStatus(playerField, W, compX, compY);
            } else {
                System.out.println("Выстрел компьютера: Мимо");
            }

            System.out.println("Осталось кораблей у игрока " + playerShipsLeft);
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

    public void shipStatus(Field field, String r, int X, int Y) {

        if (X > 1 & X < 10 & Y > 1 & Y < 10) {
            if (Objects.equals(field.getField(X - 1, Y), "[" + r + "]") | Objects.equals(field.getField(X + 1, Y), "[" + r + "]") | Objects.equals(field.getField(X, Y - 1), "[" + r + "]") | Objects.equals(field.getField(X, Y + 1), "[" + r + "]")) {
                System.out.println("Ранил");
            } else {
                System.out.println("Периметр");
            }
        }
    }
}





