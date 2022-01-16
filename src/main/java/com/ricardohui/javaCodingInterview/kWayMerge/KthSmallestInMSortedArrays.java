package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i<lists.size(); i++) {
           indexList.add(0);
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((c1, c2)->c2-c1);


        while (maxHeap.size() < k) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < lists.size(); j++) {
                if (indexList.get(j)>=lists.get(j).length) {
                    continue;
                }
                int currentNumber = lists.get(j)[indexList.get(j)];
                if (currentNumber < min) {
                    min = currentNumber;
                    indexList.set(j, indexList.get(j)+1);
                }
            }
                maxHeap.add(min);
                if (maxHeap.size() == k) break;

        }


        return maxHeap.peek();
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}