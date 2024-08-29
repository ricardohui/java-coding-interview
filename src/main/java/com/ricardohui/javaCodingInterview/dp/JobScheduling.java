package com.ricardohui.javaCodingInterview.dp;

import java.util.*;

class Job {
    int start, end, profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class JobScheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
       int n = startTime.length;
       int lastEndTime = endTime[n-1];
       Arrays.sort(startTime);

       int[][] lookup = new int[n][1+ lastEndTime];
      lookup[0][endTime[0]] = profit[0];
      int i = 1;
      while (i < n) {
        int j = 1;
        while ( j <= lastEndTime){
          if(j==endTime[i]){
            int lastRowProfit = lookup[i-1][j];
            int currentRowProfit = profit[i] + lookup[i][startTime[i]];
            lookup[i][j] = Math.max( lastRowProfit, currentRowProfit);
          }else{

            int lastJobProfit = lookup[i-1][j];
            lookup[i][j] = lastJobProfit;
          }
          j++;
        }
        
        i++;
      }
       
      // print out the lookup table
      for (int j = 0; j < lookup.length; j++) {
        for (int j2 = 0; j2 < lookup[j].length; j2++) {
          System.out.print(lookup[j][j2]+" ");
        }
        System.out.println("");
      }

      return lookup[n-1][lastEndTime];
    }

    public static void main(String[] args) {
        // Test case 1
        int[] startTime1 = {1, 2, 2, 3};
        int[] endTime1 = {2, 5, 3, 4};
        int[] profit1 = {3, 4, 1, 2};
        int expected1 = 7;
        int result1 = jobScheduling(startTime1, endTime1, profit1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "PASSED" : "FAILED"));
        
        // Test case 2
        int[] startTime2 = {1, 2, 3, 4, 6};
        int[] endTime2 = {3, 5, 10, 6, 9};
        int[] profit2 = {20, 20, 100, 70, 60};
        int expected2 = 150;
        int result2 = jobScheduling(startTime2, endTime2, profit2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "PASSED" : "FAILED"));
        
        // Test case 3
        int[] startTime3 = {1, 1, 1};
        int[] endTime3 = {2, 3, 4};
        int[] profit3 = {5, 6, 4};
        int expected3 = 6;
        int result3 = jobScheduling(startTime3, endTime3, profit3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "PASSED" : "FAILED"));
    }
}