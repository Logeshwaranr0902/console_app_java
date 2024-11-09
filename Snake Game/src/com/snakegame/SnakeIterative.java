package com.snakegame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeIterative {

    private char[][] snakeBoard = null;
    private Queue<Node> queue = new LinkedList<Node>();
    private Queue<Node> food = new LinkedList<Node>();

    SnakeIterative(int row, int col) {
        snakeBoard = new char[row][col];
        queue.add(new Node(0, 0));

        food.add(new Node(1, 0));
        food.add(new Node(2, 2));
        food.add(new Node(3, 4));
        food.add(new Node(5, 2));
        food.add(new Node(4, 5));

        displayFood(food.poll());
    }

    public void initiateSnake() {
        int row = 0, col = 0;
        snakeBoard[row][col] = '.';
        while (true) {
            printSnake();
            System.out.print("Enter a position : ");
            Scanner s = new Scanner(System.in);
            char direction = s.next().charAt(0);

            if (direction == 'U') {
                snakeMove(--row, col);
            }
            if (direction == 'D') {
                snakeMove(++row, col);
            }
            if (direction == 'R') {
                snakeMove(row, ++col);
            }
            if (direction == 'L') {
                snakeMove(row, --col);
            }
        }
    }

    public void snakeMove(int row, int col) {
        if (row >= 0 && row < snakeBoard.length && col >= 0 && col < snakeBoard.length) {
            queue.add(new Node(row, col));

            if (snakeBoard[row][col] != 'X') {
                Node node = queue.poll();
                int r = node.getRow();
                int c = node.getColumn();
                snakeBoard[r][c] = '\0';
            }

            if (snakeBoard[row][col] == 'X') {

                if (food.isEmpty()) {
                    moveForwardAndPrint(row, col);
                    System.out.println("Game Over!!!");
                    System.exit(0);
                }
                displayFood(food.poll());
            }

            if (snakeBoard[row][col] == '.') {
                System.out.println("Game Over!!!");
                System.exit(0);
            }

            moveForwardAndPrint(row, col);
        } else {
            System.out.println("Invalid move");
            System.exit(0);
        }
    }

    public void displayFood(Node node) {
        int r = node.getRow();
        int c = node.getColumn();
        snakeBoard[r][c] = 'X';
    }

    public void moveForwardAndPrint(int row, int col) {
        snakeBoard[row][col] = '.';
        printSnake();
    }

    public void printSnake() {
        for (char[] chars : snakeBoard) {
            for (int j = 0; j < snakeBoard[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}
