import objects.Field;
import objects.Player;
import objects.stShip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class Game {

    public void startGame() throws IOException {
        Player player = new Player();
        Field playerField = new Field();
        Field PCField = new Field();
        Field PCHiddenField = new Field();
        stShip[] playerStShips = new stShip[10];
        stShip[] compStShips = new stShip[10];          // Создаем новые экземпляры классов для игры

        playerField.initPlayerField("[ ]");
        PCField.initPlayerField("[ ]");
        PCHiddenField.initPlayerField("[ ]");           // Инициализируем пустые поля

        String W = whatIsYourFavoriteLetter();
        playerField.setShips(playerStShips, W);
        PCField.setShips(compStShips, W);
//        playerField.printStShips(playerStShips);
//        PCField.printStShips(compStShips);

        printDoubleField(playerField, PCField);
        boolean compHitShip = false;
        boolean gameIsOver = false;                     // Начали игру
        int playerShipsLeft = 20;
        int PCShipsLeft = 20;
        int oldPCX = 0;
        int oldPCY = 0;
        int compX = 0;
        int compY = 0;
        while (!gameIsOver) {
            int playerY = player.getPlayerShootingCoordinateY();
            int playerX = player.getPlayerShootingCoordinateX();
            if (!player.checkShoot(PCField, playerX, playerY, W)) {
                System.out.println("Вы сюда уже стреляли, введите другие координаты");
                continue;
            }
            player.makeShoot(PCField, PCHiddenField, playerX, playerY, W);          //Выстрел Игрока начинается
            if (Objects.equals(PCField.getField(playerX, playerY), "[X]")) {
                stShip asdf = getshootedShip(playerX, playerY, compStShips);
                System.out.print("Статус выстрела игрока: ");
                if (asdf.getLives() > 0) {
                    System.out.println("Ранил");
                }
                if (asdf.getLives() == 0) {
                    System.out.println("Убил");
                    asdf.surroundWithDots(asdf.getSize(), PCField);
                }
                PCShipsLeft--;
            } else {
                System.out.println("Выстрел игрока: Мимо");
            }                                                                           //Выстрел Игрока заканчивается

            if (compHitShip) {
                while (!player.checkShoot(playerField, compX, compY, W)) {
                    Random rand = new Random();
                    int temp1 = rand.nextInt(2);
                    if (temp1 == 1) {
                        compX = player.smartX(oldPCX);
                    } else {
                        compY = player.smartY(oldPCY);
                    }
                }
                System.out.println("Комп добивает");
                System.out.println("Old X = " + oldPCX + " New X = " + compX + " Old Y = " + oldPCY + " New Y = " + compY);
                player.makeShoot(playerField, playerField, compX, compY, W);            //Выстрел компа начинается
                if (Objects.equals(playerField.getField(compX, compY), "[X]")) {
                    stShip asdf = getshootedShip(compX, compY, playerStShips);
                    System.out.print("Выстрел компьютера: ");
                    if (asdf.getLives() > 0) {
                        System.out.println("Ранил снова ");
                        oldPCX = compX;
                        oldPCY = compY;
                    }
                    if (asdf.getLives() == 0) {
                        System.out.println("Убил");
                        asdf.surroundWithDots(asdf.getSize(), playerField);
                        compHitShip = false;
                    }
                    playerShipsLeft--;
                } else {
                    System.out.println("Выстрел компьютера: Мимо");
                    oldPCX = compX;
                    oldPCY = compY;
                }
            } else {
                compX = player.getPCShootingCoordinate();
                compY = player.getPCShootingCoordinate();
//            if (!player.checkShoot(playerField, compX, compY, W)) { // закомментировать
                while (!player.checkShoot(playerField, compX, compY, W)) {
                    compX = player.getPCShootingCoordinate();
                    compY = player.getPCShootingCoordinate();
                }
                player.makeShoot(playerField, playerField, compX, compY, W);            //Выстрел компа начинается
                if (Objects.equals(playerField.getField(compX, compY), "[X]")) {
                    stShip asdf = getshootedShip(compX, compY, playerStShips);
                    System.out.print("Выстрел компьютера: ");
                    if (asdf.getLives() > 0) {
                        System.out.println("Ранил");
                        compHitShip = true;
                        oldPCX = compX;
                        oldPCY = compY;
                    }
                    if (asdf.getLives() == 0) {
                        System.out.println("Убил");
                        asdf.surroundWithDots(asdf.getSize(), playerField);
                        compHitShip = false;
                    }
                    playerShipsLeft--;
                } else {
                    System.out.println("Выстрел компьютера: Мимо");
                }                                                                       //Выстрел компа заканчивается
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
    }                        // Основной игровой цикл

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
    }          // Печать двойного поля

    public String whatIsYourFavoriteLetter() throws IOException {
        System.out.println("Какая Ваша любимая буква?");
        String myFavoriteLetter = (new BufferedReader(new InputStreamReader(System.in))).readLine();
//        System.out.println(myFavoriteLetter);

        return myFavoriteLetter;
    }       // Узнали любимую букву игрока

    public stShip getshootedShip(int w, int q, stShip[] stShip) {
        objects.stShip shootedShip = new stShip();
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
    }       // После попадания проверяем по массиву с координатами кораблей ранен/убит ли корабль

}






