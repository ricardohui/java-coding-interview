package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        int start = 0;
        int end = arr.length -1;

        while (start <= end) {
            if (arr[start]< key){
                start++;
            }else if(arr[end] > key){
                end--;
            }else{
                break;
            }
        }

        if (start > end) {
            return result;
        }


        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}