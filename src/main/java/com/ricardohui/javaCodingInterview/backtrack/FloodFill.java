package com.ricardohui.javaCodingInterview.backtrack;
public class FloodFill {
  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      // If the starting pixel is already the new color, return the image as is
      if (image[sr][sc] == newColor) {
          return image;
      }
      
      // Call the helper function with the starting color
      fill(image, sr, sc, image[sr][sc], newColor);
      return image;
  }
  
  private static void fill(int[][] image, int sr, int sc, int startColor, int newColor) {
      // Check if current position is out of bounds or not the starting color
      if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || 
          image[sr][sc] != startColor) {
          return;
      }
      
      // Color the current pixel
      image[sr][sc] = newColor;
      
      // Recursively fill in all four directions
      fill(image, sr + 1, sc, startColor, newColor); // down
      fill(image, sr - 1, sc, startColor, newColor); // up
      fill(image, sr, sc + 1, startColor, newColor); // right
      fill(image, sr, sc - 1, startColor, newColor); // left
  }
  
  // Helper method to print 2D array
  private static void printImage(int[][] image) {
      for (int[] row : image) {
          for (int pixel : row) {
              System.out.print(pixel + " ");
          }
          System.out.println();
      }
      System.out.println();
  }
  
  public static void main(String[] args) {
      // Test Case 1: Basic flood fill
      System.out.println("Test Case 1: Basic flood fill");
      int[][] image1 = {
          {1, 1, 1},
          {1, 1, 0},
          {1, 0, 1}
      };
      System.out.println("Before:");
      printImage(image1);
      
      int[][] result1 = floodFill(image1, 1, 1, 2);
      System.out.println("After flood fill (sr=1, sc=1, newColor=2):");
      printImage(result1);
      
      // Verify result
      boolean test1Passed = result1[1][1] == 2 && result1[0][0] == 2 && 
                          result1[0][1] == 2 && result1[0][2] == 2 && 
                          result1[1][0] == 2 && result1[2][0] == 2;
      System.out.println("Test 1 " + (test1Passed ? "PASSED" : "FAILED"));
      
      // Test Case 2: Single pixel
      System.out.println("\nTest Case 2: Single pixel");
      int[][] image2 = {{1}};
      System.out.println("Before:");
      printImage(image2);
      
      int[][] result2 = floodFill(image2, 0, 0, 3);
      System.out.println("After flood fill (sr=0, sc=0, newColor=3):");
      printImage(result2);
      
      // Verify result
      boolean test2Passed = result2[0][0] == 3;
      System.out.println("Test 2 " + (test2Passed ? "PASSED" : "FAILED"));
      
      // Test Case 3: No change needed (same color)
      System.out.println("\nTest Case 3: No change needed (same color)");
      int[][] image3 = {
          {2, 2, 2},
          {2, 2, 2},
          {2, 2, 2}
      };
      System.out.println("Before:");
      printImage(image3);
      
      int[][] result3 = floodFill(image3, 1, 1, 2);
      System.out.println("After flood fill (sr=1, sc=1, newColor=2):");
      printImage(result3);
      
      // Verify result
      boolean test3Passed = result3[1][1] == 2 && 
                          result3[0][0] == 2 && 
                          result3[2][2] == 2;
      System.out.println("Test 3 " + (test3Passed ? "PASSED" : "FAILED"));
  }
}