package com.ricardohui.javaCodingInterview.graph;
/*
https://www.educative.io/module/lesson/algorithms-in-java/xoGDgBqn6QJ
* */
import java.util.HashSet;
import java.util.LinkedList;

class TransposeGraph {
    public static void getTranspose(Graph g) {
        int num_of_vertices = g.getVertices(); //getVertices defined in Graph.java file
        HashSet<Integer> visited = new HashSet<>();

        Graph transposedGraph = new Graph(num_of_vertices); //new graph to store the transpose
        recursion(g, transposedGraph, 0, visited);
        DoublyLinkedList<Integer>[] Llist;
        Llist = g.adjacencyList;
        //transposing the graph
//        for (int v = 0; v < g.getVertices(); v++) {
//            for (int i = 0; i < Llist[v].getSize(); i++) {
//                //Now the source is destination and vice versa
//                transposedGraph.addEdge(Llist[v].get(i), v);
//            }
//        }
        transposedGraph.printGraph(); //calling print function on the final transposed graph


    }

    public static void recursion(Graph oldGraph, Graph newGraph, int parent, HashSet<Integer> visited){

        DoublyLinkedList<Integer>.Node childNode = oldGraph.adjacencyList[parent].headNode;
        visited.add(parent);
        while (childNode != null) {
                if (!visited.contains(childNode.data)){
                    visited.add(childNode.data);
                    recursion(oldGraph, newGraph, childNode.data, visited);
                }
            newGraph.addEdge(childNode.data, parent);
//            newGraph.adjacencyList[childNode.data].insertAtEnd(parent);
            childNode = childNode.nextNode;
        }

    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        System.out.println("Transpose of given Graph: ");
        TransposeGraph.getTranspose(g1);
    }
}
