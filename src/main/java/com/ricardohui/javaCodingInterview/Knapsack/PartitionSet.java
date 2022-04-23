package com.ricardohui.javaCodingInterview.Knapsack;

import java.util.Arrays;

class PartitionSet {

    public boolean canPartition(int[] num) {
        int sum = Arrays.stream(num).sum();
        if (sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[num.length][sum/2+1];
        return canPartitionRecursive(dp, num, sum/2, 0);
    }


    private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }

        if (num.length == 0|| currentIndex >= num.length) {
            return false;
        }

        if (dp[currentIndex][sum] != null) {
            return dp[currentIndex][sum];
        }


        boolean left = false;

        if (num[currentIndex] <= sum){
            left = canPartitionRecursive(dp, num, sum-num[currentIndex], currentIndex+1);
        }

        boolean right = canPartitionRecursive(dp,num, sum, currentIndex + 1);

        dp[currentIndex][sum] = left || right;

        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}