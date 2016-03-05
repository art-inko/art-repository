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

            if (X < 1 || X > 11) {
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
        if (field1.getField(w, q).equals("[" + r + "]") | field1.getField(w, q).equals("[ ]")) {
//        if (field1.getField(w, q).equals("[*]")) {
            return true;
        } else {
            return false;
        }
    }            // Проверяем попали или нет

    public void makeShoot(Field field1, Field field2, int w, int q, String r) {
//        boolean isOK = false;
//        while (!isOK) {
        if (field1.getField(w, q).equals("[" + r + "]")) {
            field1.setFieldCell(w, q, "[X]");
            field2.setFieldCell(w, q, "[X]");
//                isOK = true;
        } else if (field1.getField(w, q).equals("[ ]")) {
            field1.setFieldCell(w, q, "[*]");
            field2.setFieldCell(w, q, "[*]");
//                isOK = true;
        }
    }  // Если попали делаем выстрел, заменяем ячейку в поле


    public int smartX(int oldX) {
        int newX = 0;
        while (newX > 10 || newX < 1) {
            Random rand = new Random();
            int temp = rand.nextInt(2);
            if (temp == 1) {
                newX = oldX + 1;
            } else {
                newX = oldX - 1;
            }
        }
        return newX;
    }

    public int smartY(int oldY) {
        int newY = 0;
        while (newY > 10 || newY < 1) {
            Random rand = new Random();
            int temp = rand.nextInt(2);
            if (temp == 1) {
                newY = oldY + 1;
            } else {
                newY = oldY - 1;
            }
        }
        return newY;
    }


//    public String smartCompShoot(int X, int Y, Field field) {
//        System.out.println(" old X = " + X + " old Y = " + Y);
//        int qwe = 0;
//        int temp = new Random().nextInt(4);
//        switch (temp) {
//            case 0:
//                qwe = X - 1;
//            case 1:
//                qwe = X + 1;
//            case 2:
//                qwe = Y - 1;
//            case 3:
//                qwe = Y + 1;
//        }
//        if (qwe < 1 || qwe > 10) {
//            while (qwe < 1 || qwe > 10) {
//                temp = new Random().nextInt(4);
//                switch (temp) {
//                    case 0:
//                        X = X - 1;
//                        break;
//                    case 1:
//                        X = X + 1;
//                    case 2:
//                        Y = Y - 1;
//                    case 3:
//                        Y = Y + 1;
//                }
//                System.out.println(" new X = " + qwe + " new X = " + qwe);
//            }
//        }
//        return field.getField(X, Y);
//    }

//    public int smartCompShootY(int Y) {
//        System.out.println("Y = " + Y);
//        int qwe = 0;
//        int temp = new Random().nextInt(2);
//        switch (temp) {
//            case 0:
//                qwe = Y - 1;
//                break;
//            case 1:
//                qwe = Y + 1;
//        }
//        if (qwe < 1 || qwe > 10) {
//            while (qwe < 1 || qwe > 10) {
//                temp = new Random().nextInt(2);
//                switch (temp) {
//                    case 0:
//                        qwe = Y - 1;
//                        break;
//                    case 1:
//                        qwe = Y + 1;
//                }
//                System.out.println("old Y =" + Y + " new Y = " + qwe);
//            }
//        }
//        System.out.println("комп подбирает Y рядом с предыдущим выстрелом");
//        return qwe;
//    }
}

