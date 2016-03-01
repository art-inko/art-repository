package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Player {
    String name;

    public void getName() {
        System.out.println("Введите имя");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println("Приветствую " + string);
    }

    public int getPlayerShootingCoordinateY() throws IOException {
        int Y = 0;
        System.out.println("Введите координату (букву от А до J)");
        while (Y == 0) {
            String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (Objects.equals(s, "A") || Objects.equals(s, "a")) {
                Y = 1;
            }
            if (Objects.equals(s, "B") || Objects.equals(s, "b")) {
                Y = 2;
            }
            if (Objects.equals(s, "C") || Objects.equals(s, "c")) {
                Y = 3;
            }
            if (Objects.equals(s, "D") || Objects.equals(s, "d")) {
                Y = 4;
            }
            if (Objects.equals(s, "E") || Objects.equals(s, "e")) {
                Y = 5;
            }
            if (Objects.equals(s, "F") || Objects.equals(s, "f")) {
                Y = 6;
            }
            if (Objects.equals(s, "G") || Objects.equals(s, "g")) {
                Y = 7;
            }
            if (Objects.equals(s, "H") || Objects.equals(s, "h")) {
                Y = 8;
            }
            if (Objects.equals(s, "I") || Objects.equals(s, "i")) {
                Y = 9;
            }
            if (Objects.equals(s, "J") || Objects.equals(s, "j")) {
                Y = 10;
            }
            if (Y == 0) {
                System.out.println("Вы ввели недопустимое значение, введите букву снова от А до J");
            }
        }
        return Y;
    }               // Получаем координату от игрока в виде буквы (Y)

    public int getPlayerShootingCoordinateX() throws IOException {
        System.out.println("Введите цифру");
        int X = 0;
        while (X == 0) {
            X = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

            if (X < 0 || X > 11) {
                System.out.println("Вы ввели недопустимое значение, введите цифру снова от 1 до 10");
                X = 0;
            }
        }
        return X;
    }               // Получаем координату от игрока в виде цифры (X)

    public int getPCShootingCoordinate() { // комп делает выстрел
        int compShoot;
        Random rand = new Random();
        compShoot = rand.nextInt(10);
        return compShoot + 1;
    }                                       // Получаем координату от компьютера в виде цифры (X, Y)

    public boolean checkShoot(Field field1, int w, int q, String r) {
//        System.out.println("X== " + w + " Y== " + q);
//        System.out.println(field1.getField(w, q)); //Ловим ошибку
        if (field1.getField(w, q).equals("[" + r + "]") | field1.getField(w, q).equals("[ ]")) {
            return true;
        } else {
            return false;
        }
    }            // Проверяем попали или нет

    public void makeShoot(Field field1, Field field2, int w, int q, String r) {
        boolean isOK = false;
        while (!isOK) {
            if (field1.getField(w, q).equals("[" + r + "]")) {
                field1.setFieldCell(w, q, "[X]");
                field2.setFieldCell(w, q, "[X]");
                isOK = true;
            } else if (field1.getField(w, q).equals("[ ]")) {
                field1.setFieldCell(w, q, "[*]");
                field2.setFieldCell(w, q, "[*]");

                isOK = true;

            }
        }
    }  // Если попали делаем выстрел, заменяем ячейку в поле
}
