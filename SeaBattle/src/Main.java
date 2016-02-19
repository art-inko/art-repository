import objects.Field;
import objects.Player;


/**
 * Created by Алька on 23.11.2015.
 */
public class Main {
    public static void main(String[] args) {

        Player currentPlayer = new Player();

        Field playerField = new Field();
        Field PCField = new Field();
        playerField.initPlayerField("[ ]");
        PCField.initPlayerField("[ ]");
        playerField.setShips();
        PCField.setShips();

    }
}

