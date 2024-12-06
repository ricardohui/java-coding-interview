package com.ricardohui.javaCodingInterview.twopointers;
import java.util.*;
public class AddBinary {
    public static String addBinary (String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carryover = 0;        
        while (i >= 0 || j >= 0 || carryover > 0){
            int number1 = i >= 0 ? Character.getNumericValue(a.charAt(i)): 0; // consider the case of 0 + 1000, you need to give a default value for ease of calculation.
            int number2 = j >= 0 ? b.charAt(j) - '0': 0;

            int sum = number1 + number2 + carryover;
            
            int digit = sum % 2; // note the different use of %2 and /2. They gives different effects.
            result.insert(0, digit);
            carryover = sum / 2; 
            

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
