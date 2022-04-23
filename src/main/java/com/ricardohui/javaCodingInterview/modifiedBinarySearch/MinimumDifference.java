package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        if (key >= arr[end]) return arr[end];
        if (key <= arr[start]) return arr[start];

        int mid = start + (end - start) / 2;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }else{
                return arr[mid];
            }
        }
        if ((arr[start] - key) < (arr[end] - key)) {
            return arr[start];
        }else{
            return arr[end];
        }
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}