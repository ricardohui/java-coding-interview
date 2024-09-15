package com.ricardohui.javaCodingInterview.cyclicSort;


class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {
         int n = nums.length;

        int i = 0;
        while (i < n) {
            int correctPostion = nums[i] - 1;
            if (nums[i] != nums[correctPostion]) {
            swap(nums, i, correctPostion);
        }else{
            i++;
        }
        }

         for (int j = 0; j < nums.length; j++) {
            if (nums[j]!=j+1) {
                return new int[]{nums[j], j+1};
            }
         }

         

         return new int[]{-1,-1};

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}