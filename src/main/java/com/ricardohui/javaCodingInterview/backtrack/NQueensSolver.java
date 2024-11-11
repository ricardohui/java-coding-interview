package com.ricardohui.javaCodingInterview.backtrack;
import java.util.*;


public class NQueensSolver {
    public static List<int[]> solveNQueens(int n) {
        List<int[]> solutions = new ArrayList<>();
        int[] board = new int[n];
        backtrack(solutions, board, 0, n);
        return solutions;
    }

    private static void backtrack(List<int[]> solutions, int[] board, int row, int n) {
        if (row == n) {
            solutions.add(board.clone());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                backtrack(solutions, board, row + 1, n);
            }
        }
    }

    private static boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(i - row) == Math.abs(board[i] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Unit tests
        assert solveNQueens(4).size() == 2;
        assert solveNQueens(8).size() == 92;

        // Example usage
        List<int[]> solutions = solveNQueens(8);
        for (int[] solution : solutions) {
            printBoard(solution);
            System.out.println();
        }
    }

    private static void printBoard(int[] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                if (solution[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}