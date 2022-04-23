package com.ricardohui.javaCodingInterview.Knapsack;

class SubsetSumCount {
    static int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][1 + sum];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            if (num[0] == s) {
                dp[0][s] = 1;
            }else{
                dp[0][s] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {

                dp[i][s] = dp[i-1][s];

                if(s >= num[i]){
                    dp[i][s] += dp[i - 1][s - num[i]];
                }
            }
        }


        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        SubsetSumCount ss = new SubsetSumCount();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}