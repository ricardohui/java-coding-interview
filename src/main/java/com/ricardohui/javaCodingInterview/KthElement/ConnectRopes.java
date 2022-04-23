package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        if (ropeLengths.length == 1) {
            return ropeLengths[0];
        }

        if (ropeLengths.length == 0) {
            return 0;
        }

        Queue<Integer> minHeap  = new PriorityQueue<>();
        for (int i = 0; i < ropeLengths.length; i++) {
            minHeap.offer(ropeLengths[i]);
        }

        int minCost = 0;
        while (minHeap.size() > 1) {
            int costForThisRound = minHeap.poll() + minHeap.poll();
            minCost += costForThisRound;
            minHeap.offer(costForThisRound);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}