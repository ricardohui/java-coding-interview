package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        Map<Integer, Integer> frequencyMapByNumber = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMapByNumber::get));
        for (int num : nums) {
            frequencyMapByNumber.put(num, frequencyMapByNumber.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (!minHeap.contains(nums[i]) && frequencyMapByNumber.get(minHeap.peek()) <= frequencyMapByNumber.get(nums[i])) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{5, 12, 11, 3, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}