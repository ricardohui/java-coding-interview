package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]){
                if (arr[mid] > key) {
                    end = mid -1 ;
                }if (arr[mid]< key){
                    start = mid+1;
                } else{
                    return mid;
                }
            }else{
                if (arr[mid] < key) {
                    start = mid + 1;
                }if(arr[mid] > key) {
                    end = mid - 1;
                }else{
                    return mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}