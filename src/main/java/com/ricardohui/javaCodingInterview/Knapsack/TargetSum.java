package com.ricardohui.javaCodingInterview.Knapsack;

class TargetSum {

    public int findTargetSubsets(int[] num, int s) {
        int[] newNum = new int[num.length * 2];
        int n = newNum.length;
        int sum = s;

        for (int i = 0;i < num.length; i++) {
            newNum[i*2] = num[i];
            newNum[i*2+1] = -num[i];
        }

        int[][] dp = new int[n][1 + s];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = j==num[0]? 1:0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (newNum[i] >= 0 && j>=newNum[i]){
                    dp[i][j] += dp[i - 1][j - newNum[i]];
                }
            }
        }

        return dp[n -1][sum];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}