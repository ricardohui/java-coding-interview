package com.ricardohui.javaCodingInterview.Knapsack;

class SubsetSum {

    public boolean canPartition(int[] num, int sum) {
        int n = num.length;

        if (sum == 0) {
            return true;
        }
        Boolean[][] dp = new Boolean[n][sum + 1];

        // for sum = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // for 1 number only when the remaining sum is larger than the only number
        for (int s = 1; s <= sum; s++) {
            if (num[0] == s) {
                dp[0][s] = true;
            }else{
                dp[0][s] = false;
            }
        }
        //
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                // include this if
                if (num[i] < j && dp[i-1][j - num[i]]){
                    dp[i][j] = true;
                }
                // exclude current item
                if (dp[i][j]==null)
                    dp[i][j] = dp[i - 1][j];

            }
        }


        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}