package com.ricardohui.javaCodingInterview.twoheaps;

import java.util.*;

class SlidingWindowMedian {
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        int start = 0;
        int end = 0;

        while (end < nums.length) {

            // add the new element to the queue
            if (maxHeap.isEmpty() || nums[end] <= maxHeap.peek()) {
                maxHeap.add(nums[end]);
            }else{
                minHeap.add(nums[end]);
            }

            // rebalancing two heaps
            if (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }


            // if no. of items greater than the window size, remove the earliest one.
            if (end - k + 1>= 0) {

                double median;
                if (minHeap.size() == maxHeap.size()) {
                    median = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
                }else{
                    median = maxHeap.peek();
                }
                result[end - k + 1 ] = median;

                if (nums[start] <= maxHeap.peek()) {
                    maxHeap.remove(nums[start]);
                }else{
                    minHeap.remove(nums[start]);
                }


                // rebalancing two heaps
                if (minHeap.size() + 1 < maxHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }



                start++;
            }


            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
