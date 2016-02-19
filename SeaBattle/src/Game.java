/**
 * Created by Артем on 20.02.2016.
 */
public class Game {



    public void printDoubleField() {
        System.out.println("            ***Поле 1го игрока***                                  ***Поле 2го игрока***  ");
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(playerField.getField(i, j) + " ");
                if (j >= 10) {
                    System.out.print("          ");

                    for (int d = 0; d < 11; d++) {
                        System.out.print(PCField.getField(i, d) + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
