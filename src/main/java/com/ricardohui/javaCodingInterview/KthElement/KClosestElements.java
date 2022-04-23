package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;
import java.util.stream.Collectors;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> maxHeap  = new PriorityQueue<>((a, b)-> (X-b)*(X-b) -  (X-a)*(X-a) );

        for (int i = 0; i < K; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = K; i < arr.length; i++) {
            int currentNumber = arr[i];
            if ( !maxHeap.isEmpty() && ((X - currentNumber) * (X - currentNumber)) < (X - maxHeap.peek()) * (X - maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.offer(currentNumber);
            }
        }


        result.addAll(maxHeap);

        return result.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}