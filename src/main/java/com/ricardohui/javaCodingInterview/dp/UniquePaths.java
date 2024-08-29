package com.ricardohui.javaCodingInterview.dp;

public class UniquePaths {
  public static int uniquePaths(int m, int n) {
    int[][] lookup = new int[m][n];

    for (int i = 0; i < m; i++) {
      lookup[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      lookup[0][i] = 1;
    }

    int i = 1;
    while (i < m) {
      int j = 1;
      while (j < n) {
        lookup[i][j] = lookup[i-1][j] + lookup[i][j-1];
        j++;
      }
      i++;
    }

    
    return lookup[m-1][n-1];
  }

  public static void main(String[] args) {
      // Unit tests
      assert uniquePaths(3, 7) == 28 : "Test case 1 failed";
      assert uniquePaths(2, 2) == 2 : "Test case 2 failed";
      assert uniquePaths(7, 3) == 28 : "Test case 3 failed";
      assert uniquePaths(3, 3) == 6 : "Test case 4 failed";
      assert uniquePaths(1, 1) == 1 : "Test case 5 failed";
      
      System.out.println("All test cases passed!");
  }
}