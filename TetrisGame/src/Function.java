
import java.util.Random;

public class Function {

    static public int randomNumber() {
        int number = new Random().nextInt(7);
        return number;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    static public void spawn(char[][] shape, char[][] mainBoard, int startCol, int startRow) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != ' ') {
                    mainBoard[startRow + i][startCol + j] = shape[i][j];
                }
            }
        }
    }

    public static void reset(char[][] shapeMatrix, char[][] matrix, int startRowPos, int startColPos) {
        for (int row = 0; row < shapeMatrix.length; row++) {
            for (int col = 0; col < shapeMatrix[0].length; col++) {
                if (shapeMatrix[row][col] != ' ') {
                    matrix[startRowPos + row][startColPos + col] = ' ';
                }
            }
        }
    }
}
