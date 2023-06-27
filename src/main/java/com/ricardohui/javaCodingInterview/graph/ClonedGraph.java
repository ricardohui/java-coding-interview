package com.ricardohui.javaCodingInterview.graph;

// Importing required functions
import java.util.*;

class ClonedGraph<X> {
    public DirectedGraph clone(DirectedGraph graph) {
        // Hashmap to keep record of visited nodes

        // Creating new graph
        DirectedGraph cloneGraph = new DirectedGraph(graph.vertices);

        for (int i = 0; i < graph.vertices; i++) {
            DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[i].headNode;
            while (childNode != null) {
                cloneGraph.addEdge(i, childNode.data);
                childNode = childNode.nextNode;
            }
        }



        // Return deep copied graph
        return cloneGraph;
    }

    public void recursion(Graph oldGraph, Graph newGraph,  int source, boolean[] visited){
        
    }

    public static void main(String[] args) {
        // Initializing graph 1
        DirectedGraph g1 = new DirectedGraph(5);

        System.out.println("------------   EXAMPLE # 1    -----------");
        // Adding verteces/nodes
//        g1.addVertex(0);
//        g1.addVertex(1);
//        g1.addVertex(2);
//        g1.addVertex(3);
//        g1.addVertex(4);

        // Adding edges of vertex/node 0
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(0, 4);

        // Adding edges of vertex/node 1
        g1.addEdge(1, 2);

        // Adding edges of vertex/node 2
        g1.addEdge(2, 0);

        // Adding edges of vertex/node 3
        g1.addEdge(3, 2);

        // Adding edges of vertex/node 4
        g1.addEdge(4, 1);
        g1.addEdge(4, 3);
        g1.addEdge(4, 0);

        // Printing graph
        System.out.println("Original graph (before copy): ");

        // A custom function to print the graph
        g1.printGraph();
        System.out.println();

        // Initializing graph
        ClonedGraph<Integer> cloneGraphInt = new ClonedGraph();
        DirectedGraph g1Copy = cloneGraphInt.clone(g1);
        System.out.println("Cloned graph (after copy):");
        // A custom function to print the graph
        g1Copy.printGraph();

        System.out.println("\nOriginal graph (after deleting an edge [0->2]):");
        g1.removeEdge(0, 2);
        // A custom function to print the graph
        g1.printGraph();;

        System.out.println(
                "\nCloned graph (after deleting an edge [0->2] from original the graph): ");
        // A custom function to print the graph
        g1Copy.printGraph();

        // Initializing graph 2
        DirectedGraph g2 = new DirectedGraph(6);

        System.out.println("\n------------   EXAMPLE # 2    -----------");


        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);

        g2.addEdge(2, 1);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);

        g2.addEdge(3, 1);
        g2.addEdge(3, 2);
        g2.addEdge(3, 4);
        g2.addEdge(3, 5);

        g2.addEdge(4, 1);
        g2.addEdge(4, 2);
        g2.addEdge(4, 3);
        g2.addEdge(4, 5);

        g2.addEdge(5, 3);

        // Printing graph
        System.out.println("Original graph (before copy): ");

        // A custom function to print the graph
        g2.printGraph();

        // Initializing graph
        ClonedGraph<String> cloneGraphStr = new ClonedGraph<String>();
        DirectedGraph g2Copy = cloneGraphStr.clone(g2);
        System.out.println("\nCloned graph (after copy):");
        // A custom function to print the graph
        g2Copy.printGraph();

        System.out.println("\nOriginal graph (after deleting an edge [v5->3]):");
        g2.removeEdge(5, 3);
        // A custom function to print the graph
        g2.printGraph();

        System.out.println(
                "\nCloned graph (after deleting an edge [v5->3] from original the graph): ");
        // A custom function to print the graph
        g2Copy.printGraph();
    }
}