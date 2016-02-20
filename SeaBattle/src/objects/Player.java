package objects;

import java.util.Scanner;

/**
 * Created by Алька on 23.11.2015.
 */
public class Player {
    String name;

    public void getName() {
        System.out.println("Введите имя");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println("Приветствую " + string);
    }


    // Метод считывания координат
}

