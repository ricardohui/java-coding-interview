package com.ricardohui.javaCodingInterview.graph;

import java.util.Iterator;

public class Sort {
    // a. Initialize the graph
    // b. Build the graph
    // c. Find all sources i.e., all vertices with 0 in-degrees
    // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue

    @SuppressWarnings("unchecked")
    public static void topologicalSort(Graph g) {


    }

    public static void main(String args[]) {

        Graph g = new Graph(6);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 2);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Graph1 Topological Sort: ");
        Sort.topologicalSort(g);
        System.out.println();

        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(0, 3);

        System.out.println("Graph2 Topological Sort: ");
        Sort.topologicalSort(g1);

    }
}



