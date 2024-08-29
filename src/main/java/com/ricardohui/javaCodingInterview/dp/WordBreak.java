package com.ricardohui.javaCodingInterview.dp;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
       if (s.length()<= 0 ){
        return true;
       }
       boolean anyTrue = false;
       for (String word : wordDict) {
    
        if (word.length() <= s.length() && word.equals(s.substring(0, word.length())) && wordBreak(s.substring(word.length()), wordDict)){
          anyTrue = true;
        }
       }
       return anyTrue;
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        boolean result1 = wordBreak(s1, dict1);
        System.out.println("Test case 1: " + (result1 == true ? "PASS" : "FAIL"));

        // Test case 2
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        boolean result2 = wordBreak(s2, dict2);
        System.out.println("Test case 2: " + (result2 == true ? "PASS" : "FAIL"));

        // Test case 3
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result3 = wordBreak(s3, dict3);
        System.out.println("Test case 3: " + (result3 == false ? "PASS" : "FAIL"));

        // Test case 4
        String s4 = "aaaaaaa";
        List<String> dict4 = Arrays.asList("aaaa", "aaa");
        boolean result4 = wordBreak(s4, dict4);
        System.out.println("Test case 4: " + (result4 == true ? "PASS" : "FAIL"));

        // Test case 5
        String s5 = "goalspecial";
        List<String> dict5 = Arrays.asList("go", "goal", "goals", "special");
        boolean result5 = wordBreak(s5, dict5);
        System.out.println("Test case 5: " + (result5 == true ? "PASS" : "FAIL"));
    }
}