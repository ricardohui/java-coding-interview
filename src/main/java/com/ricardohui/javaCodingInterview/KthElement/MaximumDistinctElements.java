package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

public class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o-> frequencyMap.get(o)));
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            frequencyMap.put(currentNum, frequencyMap.getOrDefault(currentNum, 0) + 1);

        }

        minHeap.addAll(frequencyMap.keySet());
        int distinctNumber = 0;
        while (!minHeap.isEmpty() && frequencyMap.get(minHeap.peek()) == 1) {
            minHeap.poll();
            distinctNumber++;
        }

        while (k!=0 && !minHeap.isEmpty()){
            int newNumber = frequencyMap.get(minHeap.peek()) - 1;
            frequencyMap.put(minHeap.peek(), newNumber);
            if (newNumber <= 1) {
                minHeap.poll();
                distinctNumber++;
            }
            k--;
        }

        return distinctNumber - k;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}