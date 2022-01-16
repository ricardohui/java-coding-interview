package com.ricardohui.javaCodingInterview.kWayMerge;

import java.util.*;

class Node {
    int elementIndex;
    int arrayIndex;

    public Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(c -> lists.get(c.arrayIndex)[c.elementIndex]));
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(0, i));
            currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
        }

        while (minHeap.size() == lists.size()) {
            Node currentNode = minHeap.poll();
            if (rangeEnd - rangeStart > currentMaxNumber - lists.get(currentNode.arrayIndex)[currentNode.elementIndex] ) {
                rangeStart = lists.get(currentNode.arrayIndex)[currentNode.elementIndex];
                rangeEnd = currentMaxNumber;
            }

            if (currentNode.elementIndex < lists.get(currentNode.arrayIndex).length - 1) {
                minHeap.add(new Node(currentNode.elementIndex + 1, currentNode.arrayIndex));
                currentMaxNumber = Math.max(currentMaxNumber,
                                            lists.get(currentNode.arrayIndex)[currentNode.elementIndex + 1]);
            }
        }



        return new int[] { rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}