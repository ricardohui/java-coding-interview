package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[start] <= arr[mid]){
                // the first part is in order
                start = mid + 1;
            }else{
                // the second part is in order
                    end = mid - 1 ;
            }


        }


        return (end + 1) % arr.length;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}