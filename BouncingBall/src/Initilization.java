
public class Initilization {

    private static char[][] matrix;
    private static int rows;
    private static int cols;
    private static int pos;

    public Initilization(int row, int col, int pos) {
        matrix = new char[row][col];
        Initilization.rows = row;
        Initilization.cols = col;
        Initilization.pos = pos;
        initialMatrix();
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public static void initialMatrix() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
                    matrix[row][col] = '*';
                } else if (row == rows - 2 && col == pos) {
                    matrix[row][col] = 'B';
                } else {
                    matrix[row][col] = '_';
                }
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
