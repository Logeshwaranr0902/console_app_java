
import java.util.Scanner;

public class PlayGame {

    private int row;
    private int col;
    private char[][] playingArea;

    public PlayGame(int col, char[][] playingArea) {
        this.row = playingArea.length - 2;
        this.col = col;
        this.playingArea = playingArea;
    }

    public void swap(int row, int col, int nrow, int ncol) {
        char temp = playingArea[row][col];
        playingArea[row][col] = playingArea[nrow][ncol];
        playingArea[nrow][ncol] = temp;
    }

    public int start() throws InterruptedException {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a Direction L-left , R-right , U-up");
        char option = s.next().charAt(0);

        switch (option) {
            case 'L', 'R' -> {
                boolean left = true;
                boolean up = true;
                if (option == 'R') {
                    left = false;
                }
                do {

                    if (col == 1) {
                        left = false;
                    }
                    if (col == playingArea[0].length - 2) {
                        left = true;
                    }
                    if (row - 1 == 0) {
                        up = false;
                    }
                    if (left) {
                        if (up) {
                            swap(row, col, --row, --col);
                        } else {
                            swap(row, col, ++row, --col);
                        }
                    } else {
                        if (up) {
                            swap(row, col, --row, ++col);
                        } else {
                            swap(row, col, ++row, ++col);
                        }
                    }
                    Thread.sleep(500);
                    Initilization.printMatrix(playingArea);

                } while (row != playingArea.length - 2);
                return col;
            }
            case 'U' -> {
                boolean up = true;
                do {
                    if (row == 1) {
                        up = false;
                    }
                    if (up) {
                        swap(row, col, --row, col);
                    } else {
                        swap(row, col, ++row, col);
                    }
                    Thread.sleep(500);
                    Initilization.printMatrix(playingArea);
                } while (row != playingArea.length - 2);
                return col;
            }
            default ->
                System.out.println("Enter the option Correctly");
        }
        return 0;
    }
}
