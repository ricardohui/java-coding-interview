package com.ricardohui.javaCodingInterview.graph;

import java.util.*;

public class TopologicalSort {


    @SuppressWarnings("unchecked")
    public static void topologicalSort(Graph g) {
        // a. Initialize the graph, you need a hashtable to keep track of indegrees
        int numOfVertices = g.getVertices();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Queue<Integer> sources = new Queue<>(numOfVertices);

        if (numOfVertices<=0) {
            return;
        }
        // b. Build the graph
        for (int i = 0; i < numOfVertices; i++) {
            DoublyLinkedList<Integer>.Node childNode = g.adjacencyList[i].headNode;

            while (childNode != null) {
                int child = childNode.data;
                inDegrees.put(child, inDegrees.getOrDefault(child,0) + 1);
                childNode = childNode.nextNode;
            }
        }


        // c. Find all sources i.e., all vertices with 0 in-degrees
        for (int i = 0; i < numOfVertices; i++) {
            Integer inDegree = inDegrees.getOrDefault(i,0);
            if (inDegree == 0) {
                sources.enqueue(i);
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            Integer vertice = sources.dequeue();
            System.out.print(vertice + " ");
            DoublyLinkedList<Integer>.Node childNode = g.adjacencyList[vertice].headNode;
            while (childNode != null) {
                inDegrees.put(childNode.data, inDegrees.get(childNode.data)-1);
                if (inDegrees.get(childNode.data)==0) sources.enqueue(childNode.data);
                childNode = childNode.nextNode;
            }
        }

        // e. check if the length of sortedOrder equals to the vertices



    }

    public static void main(String args[]) {

        Graph g = new DirectedGraph(6);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 2);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("DirectedGraph1 Topological Sort: ");
        TopologicalSort.topologicalSort(g);
        System.out.println();

        Graph g1 = new DirectedGraph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(0, 3);

        System.out.println("Graph2 Topological Sort: ");
        TopologicalSort.topologicalSort(g1);

    }
}



