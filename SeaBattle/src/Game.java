import objects.Field;
import objects.Player;
import objects.Ship;
import objects.StShip;

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
        StShip[] playerStShips = new StShip[10];
        StShip[] compStShips = new StShip[10];          // Создаем новые экземпляры классов для игры

        playerField.initPlayerField("[ ]");
        PCField.initPlayerField("[ ]");
        PCHiddenField.initPlayerField("[ ]");           // Инициализируем пустые поля

        String W = whatIsYourFavoriteLetter();
        playerField.setShips(playerStShips, W);
        PCField.setShips(compStShips, W);
//        playerField.printStShips(playerStShips);
//        PCField.printStShips(compStShips);

        printDoubleField(playerField, PCField);

        boolean gameIsOver = false;                     // Начали игру
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
                StShip asdf = getshootedShip(playerX, playerY, compStShips);
                System.out.print("Статус выстрела игрока: ");
                if (asdf.getLives() > 0) {
                    System.out.println("Ранил");
                }
                if (asdf.getLives() == 0) {
                    System.out.println("Убил");
                }
                PCShipsLeft--;

            } else {
                System.out.println("Выстрел игрока: Мимо");
            }

            player.makeShoot(playerField, playerField, compX, compY, W);
            if (Objects.equals(playerField.getField(compX, compY), "[X]")) {
                StShip asdf = getshootedShip(compX, compY, playerStShips);
                System.out.print("Статус выстрела компьютера: ");
                if (asdf.getLives() > 0) {
                    System.out.println("Ранил");
                }
                if (asdf.getLives() == 0) {
                    System.out.println("Убил");
                }
                playerShipsLeft--;


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
        System.out.println("            ***Поле 1го игрока***                                  ***Поле 2го игрока***      ");
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(field1.getField(i, j) + " ");
                if (j >= 10) {
                    System.out.print("          ");

                    for (int d = 0; d < 11; d++) {
                        System.out.print(Field2.getField(i, d) + " ");
                    }
                    System.out.print("          ");
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

    public StShip getshootedShip(int w, int q, StShip[] stShip) {
        StShip shootedShip = new StShip();
        for (int i = 0; i < 10; i++) {
            if ((stShip[i].getY1() <= q & q <= stShip[i].getY2() & w == stShip[i].getX1()) | (stShip[i].getX1() <= w & w <= stShip[i].getX2() & q == stShip[i].getY1())) {
                shootedShip = stShip[i];
                int temp = shootedShip.getLives();
                temp--;
                shootedShip.setLives(temp);
//                System.out.println("X1 =" + shootedShip.getX1() + " Y1 =" + shootedShip.getY1() + " Size = " + shootedShip.getSize() + " Lives = " + shootedShip.getLives());
                break;
            }
        }
        return shootedShip;
    }
}






