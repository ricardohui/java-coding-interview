package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

class BinarySearch {

    private static int searchRecusive(int[] arr, int key, int start, int end){
        if (start > end) return -1;

        int midpoint = start + (end - start) / 2;
        if (arr[midpoint] == key){
            return midpoint;
        }


        if (arr[midpoint] > key){
            return searchRecusive(arr, key, start, midpoint);
        }else{
            return searchRecusive(arr, key, midpoint+1, end);
        }
    }

    public static int search(int[] arr, int key) {
        if (arr.length <= 0){
            return -1;
        }
        Arrays.sort(arr);
       return searchRecusive(arr, key, 0, arr.length);


    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}