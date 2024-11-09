package com.sudokugame;

public class Sudokugame {

    private int[][] table;
    private final int in_dim = 3;

    public Sudokugame(int[][] table) {
        this.table = table;
    }

    public void printBoard() {

        for (int i = 0; i < table.length; i++) {
            if (i % in_dim == 0) {
                System.out.println("   ");
            }

            for (int j = 0; j < table[0].length; j++) {
                if (j % in_dim == 0) {
                    System.out.print(" ");
                }
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");

        }
    }

    public boolean solveSudoku() {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(k, i, j)) {
                            table[i][j] = k;

                            if (solveSudoku() == true) {
                                return true;
                            } else {
                                table[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int k, int i, int j) {
        for (int it = 0; it < 9; it++) {
            if (table[i][it] == k) {
                return false;
            }

        }
        for (int it = 0; it < 9; it++) {
            if (table[it][j] == k) {
                return false;
            }
        }
        int row = i - (i % 3);
        int col = j - (j % 3);
        for (int it = 0; it < 3; it++) {
            for (int ite = 0; ite < 3; ite++) {
                if (table[row + it][col + ite] == k) {
                    return false;
                }
            }
        }
        return true;
    }

}
