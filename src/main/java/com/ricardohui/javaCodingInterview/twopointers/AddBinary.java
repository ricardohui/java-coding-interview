package com.ricardohui.javaCodingInterview.twopointers;
import java.util.*;
public class AddBinary {
    public static String addBinary (String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        // Add digits from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            // Get current digits (0 if string is exhausted)
            int digitA = (i >= 0) ? Character.getNumericValue(a.charAt(i)) : 0;
            int digitB = (j >= 0) ? Character.getNumericValue(b.charAt(j)) : 0;
            
            // Calculate sum of current digits and carry
            int currentSum = digitA + digitB + carry;
            
            // Prepend current digit to result
            result.insert(0, currentSum % 2);
            
            // Update carry
            carry = currentSum / 2;
            
            // Move to next digits
            i--;
            j--;
        }
        
        return result.toString();
    }
    
     /**
     * Main method with unit tests for the addBinary method
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test Case 1: Simple addition
        testAddBinary("11", "1", "100");
        
        // Test Case 2: Different length inputs
        testAddBinary("1010", "1011", "10101");
        
        // Test Case 3: One zero input
        testAddBinary("0", "0", "0");
        
        // Test Case 4: Large binary numbers
        testAddBinary("1111", "1111", "11110");
        
        // Test Case 5: Uneven length inputs
        testAddBinary("1", "111", "1000");
        
        System.out.println("All test cases passed successfully!");
    }
    
    /**
     * Helper method to run unit tests
     * 
     * @param a First binary input
     * @param b Second binary input
     * @param expected Expected result of binary addition
     */
    private static void testAddBinary(String a, String b, String expected) {
        String result = addBinary(a, b);
        
        if (!result.equals(expected)) {
            System.out.println("Test Failed:");
            System.out.println("Input a: " + a);
            System.out.println("Input b: " + b);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + result);
            throw new AssertionError("Test case failed");
        }
        
        System.out.println("Test Passed: " + a + " + " + b + " = " + result);
    }


}
