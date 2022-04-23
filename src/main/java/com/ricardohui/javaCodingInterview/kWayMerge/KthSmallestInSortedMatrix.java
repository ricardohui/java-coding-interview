package com.ricardohui.javaCodingInterview.kWayMerge;

import java.util.PriorityQueue;
import java.util.Queue;

class Element{
    int arrayIndex;
    int elementIndex;

    public Element (int arrayIndex, int elementIndex){
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        Queue<Element> maxHeap = new PriorityQueue<>(
                (c1, c2) -> matrix[c2.arrayIndex][c2.elementIndex] - matrix[c1.arrayIndex][c1.arrayIndex]);

        for (int i = 0; i < matrix.length; i++) {
            int[] elements = matrix[i];
            if (elements.length > 0)
                maxHeap.add(new Element(i, 0));
        }

        int runningCount = 0;
        while (!maxHeap.isEmpty()) {
            Element currentSmallestElement = maxHeap.poll();
            runningCount++;
            if (runningCount == k) {
                return matrix[currentSmallestElement.arrayIndex][currentSmallestElement.elementIndex];
            }
            if (currentSmallestElement.elementIndex+1 < matrix[currentSmallestElement.arrayIndex].length)
                maxHeap.add(new Element(currentSmallestElement.arrayIndex, currentSmallestElement.elementIndex+1));
        }

        return -1;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}