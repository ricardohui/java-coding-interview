/*
https://www.educative.io/module/lesson/algorithms-in-java/xlGKXB5KZ9z
 */
package com.ricardohui.javaCodingInterview.graph;

import java.util.HashSet;

public class CountNodes {
    public static int numberOfNodesInGivenLevel(Graph g, int source, int level) {
        int count = 0; //count initialized to zero
        int num_of_vertices = g.getVertices(); //getVertices given in Graph.java file
        if (source > num_of_vertices) {
            return 0;
        }
        Queue<Integer> queue = new Queue<>(num_of_vertices);
        HashSet<Integer> visited = new HashSet<>();
        queue.enqueue(source);
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.getCurrentSize();
            if (currentLevel == level) return currentLevelSize;
            int i = 0;
            while (i < currentLevelSize) {
                Integer currentNode = queue.dequeue();

                visited.add(currentNode);
                DoublyLinkedList<Integer>.Node edge = g.adjacencyList[currentNode].getHeadNode();
                while (edge != null) {
                    if (visited.contains(edge.data)) {
                        edge = edge.nextNode;
                        continue;
                    }
                    queue.enqueue(edge.data);
                    visited.add(edge.data);
                    edge = edge.nextNode;
                }
                i++;
            }
            currentLevel++;
        }
        return count;  // edge case handle level > graph
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(2, 4);

        int answer;

        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 1);
        System.out.println(answer); // 1
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 2);
        System.out.println(answer); // 2
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 3);
        System.out.println(answer); // 2
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 4);
        System.out.println(answer); // 1
    }
}
