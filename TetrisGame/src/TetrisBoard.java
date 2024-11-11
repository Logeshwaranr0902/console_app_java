
public class TetrisBoard {

    static private char[][] board;
    static private int rowInput;
    static private int colInput;

    public TetrisBoard(int rowInput, int colInput) {
        TetrisBoard.rowInput = rowInput;
        TetrisBoard.colInput = colInput;
        TetrisBoard.board = new char[rowInput][colInput];
        designBoard();
    }

    static public void designBoard() {
        for (int row = 0; row < rowInput; row++) {
            for (int col = 0; col < colInput; col++) {
                if (row == 0 || row == rowInput - 1 || col == 0 || col == colInput - 1) {
                    board[row][col] = '*';
                } else {
                    board[row][col] = ' ';
                }
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] setBoard) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = setBoard[i][j];
            }
        }

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < rowInput; i++) {
            for (int j = 0; j < colInput; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
