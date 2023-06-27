package com.ricardohui.javaCodingInterview.dp;



public class ZeroOneKnapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[weights.length][capacity + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        for(int c = 0; c <= capacity; c ++){
            if(weights[0]<=c){
                dp[0][c] = profits[0];
            }
        }


        for(int i = 1; i < n; i++){
            for(int c = 1; c <= capacity; c++){
                if(c >= weights[i]){
                    dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-weights[i]] + profits[i]);
                }else{
                    dp[i][c] = dp[i-1][c];
                }

            }
        }


        return dp[n-1][capacity];
    }


    public static void main(String[] args) {
        ZeroOneKnapsack ks = new ZeroOneKnapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
