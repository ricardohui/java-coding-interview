package com.ricardohui.javaCodingInterview.backtrack;
public class SudokuSolver {
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        // Test Case 1: Solvable Sudoku Puzzle
        System.out.println("Test Case 1: Solvable Sudoku Puzzle");
        int[][] board1 = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        
        System.out.println("Initial Board:");
        printBoard(board1);
        
        if (solveSudoku(board1)) {
            System.out.println("Solved Board:");
            printBoard(board1);
            System.out.println("Board is Valid: " + isValidSudoku(board1));
        } else {
            System.out.println("Cannot solve the board!");
        }
        
        // Test Case 2: Invalid Board
        System.out.println("\nTest Case 2: Invalid Board");
        int[][] board2 = {
            {5,5,0,0,7,0,0,0,0}, // Two 5s in the first row
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        
        System.out.println("Board Validity: " + isValidSudoku(board2));
        
        // Test Case 3: Empty Board
        System.out.println("\nTest Case 3: Empty Board");
        int[][] board3 = new int[GRID_SIZE][GRID_SIZE];
        
        if (solveSudoku(board3)) {
            System.out.println("Solved Empty Board:");
            printBoard(board3);
            System.out.println("Board is Valid: " + isValidSudoku(board3));
        } else {
            System.out.println("Cannot solve the empty board!");
        }
        
        // Test Case 4: Unsolvable Board
        System.out.println("\nTest Case 4: Unsolvable Board");
        int[][] board4 = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,5} // Modified to make it unsolvable
        };
        
        if (solveSudoku(board4)) {
            System.out.println("Solved Board:");
            printBoard(board4);
        } else {
            System.out.println("Cannot solve the board - as expected!");
        }
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, col)) {
                            board[row][col] = numberToTry;
                            
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValidPlacement(int[][] board, int number, int row, int col) {
        // Check row
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number && i != col) {
                return false;
            }
        }
        
        // Check column
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == number && i != row) {
                return false;
            }
        }
        
        // Check 3x3 box
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        
        for (int i = boxStartRow; i < boxStartRow + 3; i++) {
            for (int j = boxStartCol; j < boxStartCol + 3; j++) {
                if (board[i][j] == number && i != row && j != col) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isValidSudoku(int[][] board) {
        // Check rows
        for (int row = 0; row < GRID_SIZE; row++) {
            boolean[] seen = new boolean[GRID_SIZE + 1];
            for (int col = 0; col < GRID_SIZE; col++) {
                int current = board[row][col];
                if (current != 0) {
                    if (seen[current]) return false;
                    seen[current] = true;
                }
            }
        }
        
        // Check columns
        for (int col = 0; col < GRID_SIZE; col++) {
            boolean[] seen = new boolean[GRID_SIZE + 1];
            for (int row = 0; row < GRID_SIZE; row++) {
                int current = board[row][col];
                if (current != 0) {
                    if (seen[current]) return false;
                    seen[current] = true;
                }
            }
        }
        
        // Check 3x3 boxes
        for (int box = 0; box < GRID_SIZE; box++) {
            boolean[] seen = new boolean[GRID_SIZE + 1];
            int rowOffset = (box / 3) * 3;
            int colOffset = (box % 3) * 3;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int current = board[rowOffset + i][colOffset + j];
                    if (current != 0) {
                        if (seen[current]) return false;
                        seen[current] = true;
                    }
                }
            }
        }
        
        return true;
    }

    // Utility method to print the board
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }
            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}