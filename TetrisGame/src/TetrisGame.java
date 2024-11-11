
import java.util.Scanner;

public class TetrisGame {

    private char[][] shape;
    private char[][] mainBoard;
    private int startCol;
    private int startRow;

    public TetrisGame(char[][] shape, char[][] mainBoard) {
        this.shape = shape;
        this.mainBoard = mainBoard;
        this.startCol = mainBoard[0].length / 2 - 1;
        this.startRow = 1;
    }

    public boolean isGameEnd() {
        // if the incoming shape is not able to fit in the playable grid means the game got end.
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[0].length; col++) {
                if (shape[row][col] == '*' && mainBoard[startRow + row][startCol + col] == '*') {
                    return true;
                }
            }
        }
        return false;
    }

    public void start() {
        Function.spawn(shape, mainBoard, startCol, startRow);
        TetrisBoard.printBoard(mainBoard);
        try (Scanner s = new Scanner(System.in)) {
            while (isValidDown()) {
                System.out.println("E-rotate right; Q-rotate Left; A-Move Left; S-Move Down; D-Move Right");
                String option = s.nextLine().toUpperCase();

                switch (option) {
                    case "A" -> {
                        if (!(startCol - 1 > 0)) {
                            System.out.println("cant able to move left further. ");
                            break;
                        }
                        // reseting the shape to ' ' and after moving the matrix
                        Function.reset(shape, mainBoard, startRow, startCol);
                        startCol--;
                        Options.moveLeft(shape, mainBoard, startRow, startCol);
                    }
                    case "S" -> {
                        Function.reset(shape, mainBoard, startRow, startCol);
                        startRow++;
                        Options.moveDown(shape, mainBoard, startRow, startCol);
                        // after moving down the isValidDownMove handles this case.
                    }
                    case "D" -> {
                        if (startCol + shape[0].length + 1 >= mainBoard[0].length) {
                            System.out.println("cant able to move right further. ");
                            break;
                        }
                        Function.reset(shape, mainBoard, startRow, startCol);
                        startCol++;
                        Options.moveRight(shape, mainBoard, startRow, startCol);
                    }
                    case "E" -> {
                        Function.reset(shape, mainBoard, startRow, startCol);
                        shape = Options.rotateRight(shape);
                        Options.fix(shape, mainBoard, startRow, startCol);
                    }
                    case "Q" -> {
                        Function.reset(shape, mainBoard, startRow, startCol);
                        shape = Options.rotateLeft(shape);
                        Options.fix(shape, mainBoard, startRow, startCol);
                    }
                }

                TetrisBoard.printBoard(mainBoard);
            }
        }
    }

    public boolean isValidDown() {
        for (int col = 0; col < shape[0].length; col++) {
            if (shape[shape.length - 1][col] == '*' && mainBoard[shape.length + startRow][col + startCol] == '*') {
                return false;
            }
        }
        return true;
    }

}
