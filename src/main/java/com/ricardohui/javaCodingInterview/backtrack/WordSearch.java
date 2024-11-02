package com.ricardohui.javaCodingInterview.backtrack;
class WordSearch {
  public boolean wordSearch(char[][] grid, String word) {
      if (grid == null || grid.length == 0 || word == null || word.isEmpty()) {
          return false;
      }
      
      int rows = grid.length;
      int cols = grid[0].length;
      
      // Search for word starting from each cell
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              if (grid[i][j] == word.charAt(0) && dfs(grid, i, j, word, 0)) {
                  return true;
              }
          }
      }
      return false;
  }
  
  private boolean dfs(char[][] board, int row, int col, String word, int index) {
      // Base case: if we've matched all characters
      if (index == word.length()) {
          return true;
      }
      
      // Check boundaries and character match
      if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
          board[row][col] != word.charAt(index)) {
          return false;
      }
      
      // Mark cell as visited
      char temp = board[row][col];
      board[row][col] = '#';
      
      // Check all four directions
      boolean found = dfs(board, row + 1, col, word, index + 1) ||
                     dfs(board, row - 1, col, word, index + 1) ||
                     dfs(board, row, col + 1, word, index + 1) ||
                     dfs(board, row, col - 1, word, index + 1);
      
      // Restore the cell
      board[row][col] = temp;
      
      return found;
  }

  public static void main(String[] args) {
      // Test case 1: Basic word search
      char[][] board1 = {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'}
      };
      String word1 = "ABCCED";
      WordSearch solution = new WordSearch();
      boolean result1 = solution.wordSearch(board1, word1);
      System.out.println("Test 1 - Word 'ABCCED': " + (result1 ? "PASS" : "FAIL"));
      assert result1;

      // Test case 2: Word not present
      String word2 = "ABCB";
      boolean result2 = solution.wordSearch(board1, word2);
      System.out.println("Test 2 - Word 'ABCB': " + (!result2 ? "PASS" : "FAIL"));
      assert !result2;

      // Test case 3: Single character board
      char[][] board2 = {{'A'}};
      String word3 = "A";
      boolean result3 = solution.wordSearch(board2, word3);
      System.out.println("Test 3 - Single char board: " + (result3 ? "PASS" : "FAIL"));
      assert result3;

      // Test case 4: Empty board
      char[][] board3 = {};
      String word4 = "A";
      boolean result4 = solution.wordSearch(board3, word4);
      System.out.println("Test 4 - Empty board: " + (!result4 ? "PASS" : "FAIL"));
      assert !result4;

      // Test case 5: Longer word with backtracking
      char[][] board4 = {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'E', 'S'},
          {'A', 'D', 'E', 'E'}
      };
      String word5 = "ABCESEEEFS";
      boolean result5 = solution.wordSearch(board4, word5);
      System.out.println("Test 5 - Complex path: " + (result5 ? "PASS" : "FAIL"));
      assert result5;

      System.out.println("All tests passed!");
  }
}