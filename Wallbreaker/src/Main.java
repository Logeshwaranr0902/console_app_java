
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WallBreaker newGame = new WallBreaker(10, 6, 3, 2, 1);
        WallBreaker.fillingMatrix();
        WallBreaker.fillBricks();
        WallBreaker.printMatrix();
        // WallBreaker.printBricks();
        Scanner s = new Scanner(System.in);

        do {
            WallBreaker.startGame();
            System.out.println("Enter any letters to continue or 'E' to exit ");
            char value = s.next().toUpperCase().charAt(0);
            if (value == 'E') {
                break;
            }
        } while (true);

    }
}
