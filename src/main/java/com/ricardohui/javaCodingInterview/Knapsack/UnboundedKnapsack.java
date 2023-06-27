package com.ricardohui.javaCodingInterview.Knapsack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UnboundedKnapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        Queue<Integer> priceToWeight = new PriorityQueue<>(Comparator.<Integer>comparingDouble((c->profits[ c] / weights[c])).reversed());
        for(int i = 0; i < profits.length; i++){
            priceToWeight.add(i);
        }


//
//        for (Integer integer : priceToWeight) {
//            System.out.println(integer);
//        }

        return recursion(profits, weights, capacity, priceToWeight, 0);
    }

    int recursion(int[] profits, int[] weights, int remainingCapacity, Queue<Integer> priceToWeight, int currentProfit){
        if (priceToWeight.isEmpty()){
            return currentProfit;
        }

        if (remainingCapacity <= 0) {
            return currentProfit;
        }

        Integer currentMaxValueItemIndex = priceToWeight.poll();


        while (remainingCapacity >= weights[currentMaxValueItemIndex]){
            System.out.println("take item#"+currentMaxValueItemIndex+" into knapsack");
            remainingCapacity -= weights[currentMaxValueItemIndex];
            currentProfit += profits[currentMaxValueItemIndex];
        }
        return recursion(profits, weights, remainingCapacity, priceToWeight, currentProfit);

    }



    public static void main(String[] args) {
        UnboundedKnapsack ks = new UnboundedKnapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
