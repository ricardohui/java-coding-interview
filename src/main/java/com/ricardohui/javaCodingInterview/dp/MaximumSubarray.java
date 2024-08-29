package com.ricardohui.javaCodingInterview.dp;

public class MaximumSubarray {
  public static int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      
      int maxSum = nums[0];
      int currentSum = nums[0];
      
      for (int i = 1; i < nums.length; i++) {
          currentSum = Math.max(nums[i], currentSum + nums[i]);
          maxSum = Math.max(maxSum, currentSum);
      }
      
      return maxSum;
  }

  public static void main(String[] args) {
      // Unit tests
      int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
      int[] test2 = {1};
      int[] test3 = {5, 4, -1, 7, 8};
      int[] test4 = {-1, -2, -3, -4};
      
      System.out.println("Test 1: " + (maxSubArray(test1) == 6 ? "PASSED" : "FAILED"));
      System.out.println("Test 2: " + (maxSubArray(test2) == 1 ? "PASSED" : "FAILED"));
      System.out.println("Test 3: " + (maxSubArray(test3) == 23 ? "PASSED" : "FAILED"));
      System.out.println("Test 4: " + (maxSubArray(test4) == -1 ? "PASSED" : "FAILED"));
  }
}