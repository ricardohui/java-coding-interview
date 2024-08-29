package com.ricardohui.javaCodingInterview.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
  public static boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) {
      return false;
    }
    int halfSum = sum / 2;
    boolean[][] lookup = new boolean[nums.length][1 + halfSum];
    for (int i = 0; i < nums.length; i++) {
      lookup[i][0] = true;
    }
    
    
     int i = 1, j = 1;
     while (i < nums.length) {
      int currentNum = nums[i];
      while (j <= halfSum) {
        if(currentNum <= j){
          lookup[i][j] = lookup[i-1][j-currentNum] || lookup[i-1][j];
        }
      j++;
      }
    j=1; // missed this!! or move the declaration of j = 1 into the while i scope
    i++; 
    }

    for (int j2 = 0; j2 < lookup.length; j2++) {
      for (int k = 0; k < lookup[j2].length; k++) {
        System.out.print(lookup[j2][k]+ " ");
      }
      System.out.println("");
    }

      return lookup[nums.length - 1][halfSum];
  }
  
  public static void main(String[] args) {
      // Test cases
      int[][] testCases = {
          {1, 3, 7, 3},
          // {1, 2, 3, 5},
          // {1, 2, 5},
          // {1, 2, 3, 4, 5, 6, 7},
          // {1, 1, 1, 1},
          // {100, 100, 100, 100, 100, 100, 100, 100, 100},
          // {1, 3, 4}
      };
      
      for (int i = 0; i < testCases.length; i++) {
          boolean result = canPartition(testCases[i]);
          System.out.print("Test case " + (i + 1) + ": ");
          printArray(testCases[i]);
          System.out.println(" - Can be partitioned: " + result);
      }
  }
  
  private static void printArray(int[] arr) {
      System.out.print("[");
      for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i]);
          if (i < arr.length - 1) {
              System.out.print(", ");
          }
      }
      System.out.print("]");
  }
}