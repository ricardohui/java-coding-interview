package com.ricardohui.javaCodingInterview.KthElement;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o-> (int) o).reversed());
        // in max heap, the max is on the top
        int i = 0;
        while (i < k) {
            maxHeap.offer(nums[i]);
            i++;
        }

        for (int j = k; j < nums.length; j++) {
            if (nums[j] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[j]);
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
