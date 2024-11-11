
public class Options {

    static char[][] rotateLeft(char mat[][]) {

        char rotated[][] = new char[mat[0].length][mat.length];
        for (int col = mat[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < mat.length; row++) {

                rotated[mat[0].length - col - 1][row] = mat[row][col];
            }
        }
        return rotated;
    }

    static char[][] rotateRight(char mat[][]) {

        char rotated[][] = new char[mat[0].length][mat.length];
        for (int row = mat.length - 1; row >= 0; row--) {
            for (int col = 0; col < mat[0].length; col++) {
                rotated[col][mat.length - row - 1] = mat[row][col];
            }
        }
        return rotated;
    }

    public static void moveLeft(char[][] shape, char[][] playableGrid, int startRowPos, int startColPos) {
        Function.spawn(shape, playableGrid, startColPos, startRowPos);
    }

    public static void moveDown(char[][] shape, char[][] playableGrid, int startRowPos, int startColPos) {
        Function.spawn(shape, playableGrid, startColPos, startRowPos);
    }

    public static void moveRight(char[][] shape, char[][] playableGrid, int startRowPos, int startColPos) {
        Function.spawn(shape, playableGrid, startColPos, startRowPos);
    }

    public static void fix(char[][] shape, char[][] playableGrid, int startRowPos, int startColPos) {
        Function.spawn(shape, playableGrid, startColPos, startRowPos);
    }

}
