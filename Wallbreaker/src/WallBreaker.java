
import java.util.Scanner;

public class WallBreaker {

    private static int ballRow;
    private static int ballCol = 1;
    private static char[][] gameBoard;
    private static int[][] brickHealth;
    private static int health;
    private static int noofbrickscol;
    private static int noofbricksrow;
    private static int noofrow;
    private static int noofcol;

    public WallBreaker(int noofrow, int noofcol, int noofbricksrow, int noofbrickscol, int health) {
        WallBreaker.ballRow = noofrow - 2;
        WallBreaker.gameBoard = new char[noofrow][noofcol];
        WallBreaker.brickHealth = new int[noofbricksrow][noofbrickscol];
        WallBreaker.health = health;
        WallBreaker.noofbrickscol = noofbrickscol;
        WallBreaker.noofbricksrow = noofbricksrow;
        WallBreaker.noofrow = noofrow;
        WallBreaker.noofcol = noofcol;
    }

    public static void setBallCol(int ballCol) {
        int getBall = WallBreaker.getBallCol();
        gameBoard[noofrow - 2][getBall] = ' ';
        WallBreaker.ballCol = ballCol;
        gameBoard[noofrow - 2][ballCol] = '@';
    }

    public static int getBallCol() {
        return ballCol;
    }

    static public void fillingMatrix() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                if (row == 0 || row == gameBoard.length - 1 || col == 0 || col == gameBoard[0].length - 1) {
                    gameBoard[row][col] = '#';
                } else if (row == ballRow && col == ballCol) {
                    gameBoard[row][col] = '@';
                } else {
                    gameBoard[row][col] = ' ';
                }
            }
        }
    }

    static public void fillBricks() {
        for (int bricsRow = 0; bricsRow < brickHealth.length; bricsRow++) {
            for (int bricscol = 0; bricscol < brickHealth[0].length; bricscol++) {
                gameBoard[bricsRow + 2][bricscol + (gameBoard[0].length / 2) - (brickHealth[0].length / 2)] = 'B';
                brickHealth[bricsRow][bricscol] = health;
            }

        }
    }

    // static public void printBricks() {
    //     for (int row = 0; row < brickHealth.length; row++) {
    //         for (int col = 0; col < brickHealth[0].length; col++) {
    //             System.out.print(brickHealth[row][col] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    static public void printMatrix() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    static public boolean checkBrick(int newRow, int newCol) {

        if (gameBoard[newRow][newCol] == 'B') {
            return true;
        }
        if (newRow - 2 < noofbricksrow && newCol - (gameBoard[0].length / 2) + (brickHealth[0].length / 2) < noofbrickscol && newRow >= 2 && newCol >= (gameBoard[0].length / 2) - (brickHealth[0].length / 2)) {

            brickHealth[newRow - 2][newCol - (gameBoard[0].length / 2) + (brickHealth[0].length / 2)]--;

            if (brickHealth[newRow - 2][newCol - (gameBoard[0].length / 2) + (brickHealth[0].length / 2)] <= 0) {
                gameBoard[newRow][newCol] = ' ';
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    static public boolean move(int row, int col, int newRow, int newCol) {
        if (checkBrick(row, col)) {

            gameBoard[newRow][newCol] = '@';
            gameBoard[row][col] = 'B';
            return true;

        }
        if (checkBrick(newRow, newCol)) {

            gameBoard[newRow][newCol] = '@';
            gameBoard[row][col] = ' ';

            return true;

        } else {
            gameBoard[newRow][newCol] = '@';
            gameBoard[row][col] = ' ';

            return false;
        }

    }

    static public void startGame() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a ball position to start");
        int pos = s.nextInt();
        setBallCol(pos);
        printMatrix();
        System.out.println("Enter a Direction to shoot the Ball U- Straight , R- RightSide, L-LeftSide");
        char option = s.next().toUpperCase().charAt(0);
        boolean noBrickAtNextStep = true;
        boolean left = true;
        boolean up = true;
        boolean hitBrick = false;
        if (option == 'R') {
            left = false;
        }
        do {
            if (ballCol == 1) {
                left = false;
            }
            if (ballCol == gameBoard[0].length - 2) {
                left = true;
            }
            if (ballRow == 1) {
                up = false;
            }
            if (!hitBrick) {
                if (option == 'L' || option == 'R') {
                    if (up) {
                        if (left) {
                            hitBrick = move(ballRow, ballCol, --ballRow, --ballCol);
                        } else {
                            hitBrick = move(ballRow, ballCol, --ballRow, ++ballCol);
                        }
                    } else {
                        if (left) {
                            hitBrick = move(ballRow, ballCol, ++ballRow, --ballCol);
                        } else {
                            hitBrick = move(ballRow, ballCol, ++ballRow, ++ballCol);
                        }
                    }
                }
                if (option == 'U') {
                    if (up) {
                        hitBrick = move(ballRow, ballCol, --ballRow, ballCol);
                    } else {
                        hitBrick = move(ballRow, ballCol, ++ballRow, ballCol);
                    }

                }

            } else {
                move(ballRow, ballCol, ++ballRow, ballCol);
                hitBrick = true;
            }

            Thread.sleep(100);
            printMatrix();
        } while (ballRow != gameBoard.length - 2);

    }

}
