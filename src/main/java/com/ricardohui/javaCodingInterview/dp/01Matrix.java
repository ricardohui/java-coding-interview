package com.ricardohui.javaCodingInterview.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
      if(mat.length==1 && mat[0].length==1) return mat;

      // iterate through the matrix and check for the non-zero elements
      
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
          if(mat[i][j] !=0){
            int min = Integer.MAX_VALUE - 1000;
            if(i-1>=0){
              min = Math.min(mat[i-1][j], min);
              }

            if(j-1 >= 0){
              min = Math.min(mat[i][j-1], min);
            }
              mat[i][j] = min+1;
          }
        }
      }
      // at each nonzero element, take the min of the element above and to its left and add 1 to the result. Now store the updated result to the current cell

      // traverse the whole matrix from the top-left element to the bottom right elemnt and update each nonzero element using the same procedure


      // next, starting from bottom right element, iterate to the top left element, looking for even shorter paths to the nearest 0

      
      // while iterating backward, take the min of the element below and to the right of the current cell and add 1. Lets call it the cell's candidate distance

       
      for (int i = mat.length-1; i >= 0; i--) {
        for (int j = mat[i].length -1; j >= 0; j--) {
          if(mat[i][j] !=0){
            int min = mat[i][j];
            int originalMin = min;
            if(i+1 < mat.length){
              min = Math.min(mat[i+1][j], min);
              }

            if(j+1 < mat[i].length){
              min = Math.min(mat[i][j+1], min);
            }
            if(originalMin != min)
              mat[i][j] = min+1;
          }
        }
      }

      // then store the min of the current cell and the candidate distance in the current cell


        return mat;
    }

    // Main method with unit tests
    public static void main(String[] args) {
        Solution solution = new Solution();


        // Test case 1: Single element matrix with 0
        int[][] singleZero = {{0}};
        assertArrayEquals(new int[][]{{0}}, solution.updateMatrix(singleZero), "Test case 1 failed: Single element 0");

        //Test case 2: Single element matrix with 0
        int[][] twoMatrix = {{0,1}, {1,1}};
        assertArrayEquals(new int[][]{{0,1},{1,2}}, solution.updateMatrix(twoMatrix), "Test case 2 failed: ");


        // Test case 4: Simple matrix
        int[][] simpleMatrix = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        int[][] expectedSimple = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 2, 1}
        };
        assertArrayEquals(expectedSimple, solution.updateMatrix(simpleMatrix), "Test case 4 failed: Simple matrix");

        // Test case 5: Complex matrix
        int[][] complexMatrix = {
            {1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
        };
        int[][] expectedComplex = {
            {2, 1, 0, 0, 1},
            {2, 1, 0, 1, 0},
            {3, 2, 1, 0, 1},
            {4, 3, 2, 1, 2},
            {5, 4, 3, 2, 3}
        };
        assertArrayEquals(expectedComplex, solution.updateMatrix(complexMatrix), "Test case 5 failed: Complex matrix");

        System.out.println("All test cases passed!");
    }

    // Helper method for assertions
    private static void assertArrayEquals(int[][] expected, int[][] actual, String message) {
        if (!Arrays.deepEquals(expected, actual)) {
            System.out.println(message);
            System.out.println("Expected: " + Arrays.deepToString(expected));
            System.out.println("Actual: " + Arrays.deepToString(actual));
            throw new AssertionError(message);
        }
    }
}