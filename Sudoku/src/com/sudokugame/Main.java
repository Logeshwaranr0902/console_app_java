package com.sudokugame;

public class Main {

    public static void main(String[] args) {
        int[][] board = {
            {0, 2, 0, 0, 0, 3, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 8, 0},
            {0, 0, 0, 0, 8, 4, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 9},
            {2, 0, 0, 0, 0, 0, 0, 7, 1},
            {4, 3, 8, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 3, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 5, 0, 6}
        };
        Sudokugame newgame = new Sudokugame(board);
        newgame.printBoard();
        newgame.solveSudoku();
        System.out.println("-------------------------------------------");
        newgame.printBoard();

    }
}
