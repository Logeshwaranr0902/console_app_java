
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.err.println("Enter the number of rows");
        int row = s.nextInt();
        s.nextLine();
        System.err.println("Enter the number of cols");
        int col = s.nextInt();
        s.nextLine();
        System.err.println("Enter the Positon where you need to start" + "1 to " + (col - 1));
        int pos = s.nextInt();
        s.nextLine();
        if (pos < 1 || pos > col - 1) {
            System.out.println("Enter the postion properly");
            return;
        }
        Initilization newGame = new Initilization(row, col, pos);
        Initilization.printMatrix(newGame.getMatrix());
        PlayGame play = new PlayGame(pos, newGame.getMatrix());

        int position = play.start();
        System.out.println("The postion is " + position);
    }
}
