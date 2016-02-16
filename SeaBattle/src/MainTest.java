import java.util.Random;

public class MainTest {
    public static void main(String[] args) {


            boolean isHorizontal;

            Random rand = new Random();
            int orientation = rand.nextInt(2);
            if (orientation == 1) {
                isHorizontal = true;
            } else {
                isHorizontal = false;

            }
        System.out.println(orientation);
        }

}
