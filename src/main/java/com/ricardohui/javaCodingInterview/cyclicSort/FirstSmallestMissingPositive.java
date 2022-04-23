package com.ricardohui.javaCodingInterview.cyclicSort;

class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {
        int i = 0;
        while( i < nums.length){
            int j = nums[i]-1;
            if(i < nums.length && nums[i] > 0 && nums[j] > 0 && nums[i]!=nums[j]){
                swap(nums, i, j);
            }else{
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j]>0 && nums[j]!=j){
                return j;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}