package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;
import java.util.stream.Collectors;

class SumOfElements {

    public static int[] sort(int[] nums){

        return new int[]{1,2};
    }
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int i = k1;
        int sum  = 0;
        while (i<k2-1){
            sum += sortedArray[i];
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}