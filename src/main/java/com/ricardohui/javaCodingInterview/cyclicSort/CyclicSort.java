package com.ricardohui.javaCodingInterview.cyclicSort;

class CyclicSort {

    public static void sort(int[] nums) {
        // write a cyclic sort algorithm

        StringBuffer sb = new StringBuffer();
        
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
    }



    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

// generate unit tests for this class