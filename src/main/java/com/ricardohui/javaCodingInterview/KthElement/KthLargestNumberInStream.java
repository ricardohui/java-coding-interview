package com.ricardohui.javaCodingInterview.KthElement;

import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy;

import javax.print.attribute.EnumSyntax;
import java.util.*;

//1,2,3,5,11,12
//        1,2,3,5,6,11,12
//        1,2,3,5,6,11,12,13
//        1,2,3,4,5,6,11,12,13
class KthLargestNumberInStream {

    Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    public KthLargestNumberInStream(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }

    public int add(int num) {
        if (!minHeap.isEmpty() && minHeap.peek() < num) {
            minHeap.poll();
            minHeap.offer(num);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}