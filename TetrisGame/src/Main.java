
public class Main {

    public static void main(String[] args) {
        TetrisBoard newBoard = new TetrisBoard(14, 22);
        newBoard.printBoard(newBoard.getBoard());

        while (true) {
            String shapes[] = {"S", "L", "T", "SQ", "Z", "ML", "I"};
            String letter = shapes[Function.randomNumber()];
            char[][] shape = Shapes.getShape(letter);
            TetrisGame newGame = new TetrisGame(shape, newBoard.getBoard());
            if (newGame.isGameEnd()) {
                System.out.println("The Game is over");
                break;
            }
            newGame.start();
        }
    }
}
