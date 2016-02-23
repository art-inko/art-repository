package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;
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
        System.out.println("Введите координату (букву)");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println(s);
        if (s == "A" || s == "a") {
            Y = 1;
        }
        if (s == "B" || s == "b") {
            Y = 2;
        }
        if (s == "C" || s == "c") {
            Y = 3;
        }
        if (s == "D" || s == "d") {
            Y = 4;
        }
        if (s == "E" || s == "e") {
            Y = 5;
        }
        if (s == "F" || s == "f") {
            Y = 6;
        }
        if (s == "G" || s == "g") {
            Y = 7;
        }
        if (s == "H" || s == "h") {
            Y = 8;
        }
        if (s == "I" || s == "i") {
            Y = 9;
        }
        if (s == "J" || s == "j") {
            Y = 10;
        }
        return Y;
    }

    public int getPlayerShootingCoordinateX() throws IOException {
        System.out.println("Введите цифру");
        int X = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        return X;
    }

    public void makeShoot(int a, int b, Field field, String S) {
        // if ((Objects.equals(field[a][b], "[" + S + "]"))) {

        }
    }
