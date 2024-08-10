package com.ricardohui.javaCodingInterview.dp;
public class StairClimb {

  // Function to calculate the number of ways to climb n steps
  public static int climbStairs(int n) {
    // initialize a lookup table and fill in the indexes for the base cases of 1 and 2 jumps
    int[] result = new int[3+n];
    result[1] = 1;
    result[2] = 2;

    // iterate over the lookup table and add the two previous values from the lookup table to fill the next index
    for (int i = 3; i <=n; i++) {
        result[i] = result[i-1] + result[i-2];
    }


    // return the nth index value from the lookup table, which is the number of ways to climb n stairs



      return result[n];
  }

  public static void main(String[] args) {
      // Test cases
      testClimbStairs(1, 1);
      testClimbStairs(2, 2);
      testClimbStairs(3, 3);
      testClimbStairs(4, 5);
      testClimbStairs(5, 8);
      testClimbStairs(10, 89);

      System.out.println("All tests passed.");
  }

  // Helper method to test the climbStairs function
  private static void testClimbStairs(int n, int expected) {
      int result = climbStairs(n);
      if (result != expected) {
          throw new AssertionError("Test failed for n = " + n + ": expected " + expected + ", but got " + result);
      }
  }
}
