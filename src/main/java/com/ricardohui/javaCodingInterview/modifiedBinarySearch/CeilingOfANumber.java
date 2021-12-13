package com.ricardohui.javaCodingInterview.modifiedBinarySearch;


class CeilingOfANumber {

    private static int searchCeilingOfANumber(int[] arr, int key, int start, int end, int result) {


        if (start >= end) {
            return result;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == key) {
            return middle;
        }


        if (arr[middle] > key) {
            return searchCeilingOfANumber(arr, key, start, middle - 1, middle);
        } else {
            return searchCeilingOfANumber(arr, key, middle + 1, end, result);
        }

    }
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr.length <= 0) {
            return -1;
        }

        if (arr.length == 1) {
            if (arr[0] >= key) {
                return 0;
            }
            return -1;
        }

        if (key <= 0) {
            return 0;
        }
        return searchCeilingOfANumber(arr, key, 0, arr.length, -1);
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6 ));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}