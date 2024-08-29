package com.ricardohui.javaCodingInterview.dp;

import java.util.*;

public class LongestPalindromicSubstring {
  public static String longestPalindrome(String s) {
    boolean[][] lookup = new boolean[s.length()][s.length()];
    int[] result = new int[2];

    // 1st base case  
    for (int i = 0; i < s.length(); i++) {
      lookup[i][i] = true;
    }

    // 2nd base case 
    for (int i = 0; i+1 < s.length(); i++) {
      lookup[i][i+1] = s.charAt(i) == s.charAt(i+1);
      if (lookup[i][i+1]) {
        result= new int[]{i,i+1};
      }
    }

  
    for (int length = 3; length <= s.length(); length++){
      // start a look with the window is smart so it saves you the trouble for comparing the existing max value
      int i = 0;
      int j = length - 1;
      while (j < s.length()) {
        lookup[i][j] = lookup[i+1][j-1] && s.charAt(i) == s.charAt(j);
        if (lookup[i][j]) {
          result = new int[]{i, j};
        }
        i++;
        j++;
      }

    }
    // for (int i = 0; i < s.length(); i++) {
    //   for (int length = 3; i + length < s.length(); length++) {
    //     int left = i;
    //     int right = i + length -1;
    //     lookup[left][right] = lookup[i+1][right-1] &&  s.charAt(left) == s.charAt(right);
    //     if (lookup[left][right] && right - left > result[1] - result[0]){
    //       result = new int[]{left, right};
    //     }
    //   }
    // }

    return s.substring(result[0], result[1] + 1);
  }

  public static void main(String[] args) {
    String[] testCases = {
        "babad",
        "cbbd",
        "a",
        "ac",
        "racecar",
        "bananas"
    };

    for (String test : testCases) {
      String result = longestPalindrome(test);
      System.out.println("Input: " + test);
      System.out.println("Longest palindromic substring: " + result);
      System.out.println();
    }
  }
}