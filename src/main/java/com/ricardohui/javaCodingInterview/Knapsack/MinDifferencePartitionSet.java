package com.ricardohui.javaCodingInterview.Knapsack;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

class MinDifferencePartitionSet {

    public int canPartition(int[] num) {
        int sum = Arrays.stream(num).sum();


        Boolean[][] difference = new Boolean[num.length][1 + sum / 2];

        for (int i = 0; i < num.length; i++) {
            difference[i][0] = true;
        }
        for (int s = 1; s <= sum / 2; s++) {
            if (num[0] == s){
                difference[0][s] = true;
            }else {
                difference[0][s] = false;
            }
        }


        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum/2; s++) {
                if (difference[i - 1][s]){
                    difference[i][s] = true;
                } else if (s >= num[i]) {
                    difference[i][s] = difference[i - 1][s - num[i]];
                }
            }
        }

        int sum1 = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (difference[num.length - 1][i] == true) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        
        
        return Math.abs(sum2 - sum1);
    }

    public static void main(String[] args) {
        MinDifferencePartitionSet ps = new MinDifferencePartitionSet();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}