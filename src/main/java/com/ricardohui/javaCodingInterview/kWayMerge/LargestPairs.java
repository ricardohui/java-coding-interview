package com.ricardohui.javaCodingInterview.kWayMerge;

import java.util.*;

class LargestPairs {

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(p -> (p[0] + p[1])));
        int i = 0;


        while (i < nums1.length && i < k) {
            int j = 0;
            while (j < nums2.length && j < k) {
                if (minHeap.size() < k) {
                    minHeap.add(new int[]{nums1[i], nums2[j]});
                }else{
                    if (minHeap.peek()[0] + minHeap.peek()[1] > nums2[j] + nums1[i]) {
                        break;
                    }
                    else {
                        minHeap.poll();
                        minHeap.add(new int[]{nums1[i], nums2[j]});
                    }
                }
                j++;
            }
            i++;
        }

        return new LinkedList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}