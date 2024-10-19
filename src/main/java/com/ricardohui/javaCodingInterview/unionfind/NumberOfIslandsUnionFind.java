package com.ricardohui.javaCodingInterview.unionfind;
import java.util.*;

public class NumberOfIslandsUnionFind {
  static class UnionFind {
      private int[] parent;
      private int[] rank;
      private int count;

      public UnionFind(int n) {
          parent = new int[n];
          rank = new int[n];
          count = 0;
          for (int i = 0; i < n; i++) {
              parent[i] = -1;
              rank[i] = 0;
          }
      }

      public void addLand(int i) {
          if (parent[i] >= 0) return;
          parent[i] = i;
          count++;
      }

      public int find(int i) {
          if (parent[i] != i) {
              parent[i] = find(parent[i]);  // Path compression
          }
          return parent[i];
      }

      public void union(int x, int y) {
          int rootX = find(x);
          int rootY = find(y);
          if (rootX != rootY) {
              if (rank[rootX] < rank[rootY]) {
                  parent[rootX] = rootY;
              } else if (rank[rootX] > rank[rootY]) {
                  parent[rootY] = rootX;
              } else {
                  parent[rootY] = rootX;
                  rank[rootX]++;
              }
              count--;
          }
      }

      public int getCount() {
          return count;
      }
  }

  public static int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) {
          return 0;
      }

      int m = grid.length;
      int n = grid[0].length;
      UnionFind uf = new UnionFind(m * n);

      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == '1') {
                  uf.addLand(i * n + j);
                  if (i > 0 && grid[i-1][j] == '1') uf.union(i * n + j, (i-1) * n + j);
                  if (j > 0 && grid[i][j-1] == '1') uf.union(i * n + j, i * n + j - 1);
              }
          }
      }

      return uf.getCount();
  }

  public static void main(String[] args) {
      // Unit tests
      char[][] grid1 = {
          {'1', '1', '1', '1', '0'},
          {'1', '1', '0', '1', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '0', '0', '0'}
      };
      int expected1 = 1;
      int result1 = numIslands(grid1);
      System.out.println("Test 1: " + (result1 == expected1 ? "PASSED" : "FAILED") +
                         " (Expected: " + expected1 + ", Got: " + result1 + ")");

      char[][] grid2 = {
          {'1', '1', '0', '0', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '1', '0', '0'},
          {'0', '0', '0', '1', '1'}
      };
      int expected2 = 3;
      int result2 = numIslands(grid2);
      System.out.println("Test 2: " + (result2 == expected2 ? "PASSED" : "FAILED") +
                         " (Expected: " + expected2 + ", Got: " + result2 + ")");

      char[][] grid3 = {{'1', '0', '1'}, {'0', '1', '0'}, {'1', '0', '1'}};
      int expected3 = 5;
      int result3 = numIslands(grid3);
      System.out.println("Test 3: " + (result3 == expected3 ? "PASSED" : "FAILED") +
                         " (Expected: " + expected3 + ", Got: " + result3 + ")");

      char[][] grid4 = {{'1'}};
      int expected4 = 1;
      int result4 = numIslands(grid4);
      System.out.println("Test 4: " + (result4 == expected4 ? "PASSED" : "FAILED") +
                         " (Expected: " + expected4 + ", Got: " + result4 + ")");

      char[][] grid5 = {{'0'}};
      int expected5 = 0;
      int result5 = numIslands(grid5);
      System.out.println("Test 5: " + (result5 == expected5 ? "PASSED" : "FAILED") +
                         " (Expected: " + expected5 + ", Got: " + result5 + ")");
  }
}