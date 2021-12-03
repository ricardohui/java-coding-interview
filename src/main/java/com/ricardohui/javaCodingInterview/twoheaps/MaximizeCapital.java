package com.ricardohui.javaCodingInterview.twoheaps;

import java.util.*;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        // assume capital and profits are both accedning
        int n = profits.length;
        Queue<Integer> minCapitalHeap = new PriorityQueue<>((smaller, greater) -> smaller - greater);
        Queue<Integer> maxProfitHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            minCapitalHeap.add(i);
        }

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {

            while (!minCapitalHeap.isEmpty() && availableCapital >= capital[minCapitalHeap.peek()]) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            availableCapital += profits[maxProfitHeap.poll()];

        }
        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 5}, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}