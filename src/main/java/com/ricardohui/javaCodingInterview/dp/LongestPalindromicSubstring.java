package com.ricardohui.javaCodingInterview.dp;

import java.util.*;
public class LongestPalindromicSubstring {
  public static String longestPalindrome(String s) {
    

      
      return s;
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