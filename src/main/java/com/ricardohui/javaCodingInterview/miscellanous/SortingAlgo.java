package com.ricardohui.javaCodingInterview.miscellanous;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.toList;

/**
 * [bear note](bear://x-callback-url/open-note?id=76E49317-082C-4BEB-9199-03B6E3090BF6-12185-000013F118D2219F)
 */
class SortingAlgo {
    /**
     * Insertion Sort: how you organized a deck of cards
     * complexity O(n^2)
     */
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    static void selectionSort(int[] arr){
        return;
    }

    static void mergeSort(int[] arr){

    }
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        int i = low;
//        System.out.println("soutm SortingAlgo.partition");
//        System.out.println("soutp arr = " + Arrays.toString(arr) + ", low = " + low + ", high = " + high);
//        System.out.println("soutv high = " + high);
        System.out.println("arr[high] = " + arr[high]);
        while (i < high) {
            if (arr[i] < arr[high]) {
                swap(arr, i, low);
                low++;
            }
            i++;
        }
        swap(arr, i, low);

        return low;
    }

    static void quickSortRec(int[] arr, int low, int high) {

        if (high > low) {
            int pivotIndex = partition(arr, low, high);
            quickSortRec(arr, low, pivotIndex - 1);
            quickSortRec(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Quick Sort: you need a pivot. the left of pivot is smaller than pivot. The right of pivot is larger than the
     * pivot.
     * complexity O(n log n)
     */
    static void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);

    }

    /**
     * Bubble Sort: the largest value bubble up(swap to the rightmost) each pass
     * complexity O(n^2)
     */
    static void bubbleSort(int[] arr) {
        // TODO:
    }


    static void cycleSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;

            if (j != i) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = new int[]{33, 6, 21, 12, 19, 29, 38, 22, 14, 40};
        int[] a = new int[]{3, 6, 4, 2, 1, 5};

        System.out.print("Before Sorting\n");
        System.out.print(Arrays.toString(a) + "\n");
        long startTime = System.nanoTime();
//        quickSort(a);
        cycleSort(a);
//        insertionSort(a); // 27microseconds

        long endTime = System.nanoTime();
        System.out.print("After Sorting\n");
        System.out.println(Arrays.toString(a));
        System.out.printf("It took %d microseconds to complete", (endTime - startTime) / 1000);
    }
}