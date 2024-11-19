package com.ricardohui.javaCodingInterview.backtrack;

import java.util.*;

public class IPAddressRestorer {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we've used all segments and reached the end of the string
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        
        // If we've either used 4 segments or reached the end of the string prematurely
        if (current.size() == 4 || start >= s.length()) {
            return;
        }
        
        // Try segments of length 1, 2, and 3
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String segment = s.substring(start, start + len);
            
            // Check for leading zeros and valid numeric range
            if ((segment.length() > 1 && segment.startsWith("0")) || 
                Integer.parseInt(segment) > 255) {
                continue;
            }
            
            // Add the valid segment and continue backtracking
            current.add(segment);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        IPAddressRestorer restorer = new IPAddressRestorer();
        
        // Test cases
        String[] testInputs = {"25525511135", "0000", "1111"};
        
        for (String input : testInputs) {
            List<String> validIPs = restorer.restoreIpAddresses(input);
            System.out.println("Input: " + input);
            System.out.println("Valid IP Addresses:");
            for (String ip : validIPs) {
                System.out.println(ip);
            }
            System.out.println();
        }
    }
}