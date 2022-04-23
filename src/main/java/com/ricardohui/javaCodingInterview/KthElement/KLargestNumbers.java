package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {

        Queue maxHeap = new PriorityQueue<Integer>((a, b)-> b-a);
        List result = new ArrayList<Integer>();
        for (int num: nums) {
            maxHeap.offer(num);
        }
        int i = 0;
        while (i < k) {
            result.add(maxHeap.poll());
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}