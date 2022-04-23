package com.ricardohui.javaCodingInterview.greedy;
import java.io.*;
import java.util.Arrays;
import java.util.*;
class Graph {
    private int vertices; //number of vertices
    private LinkedList < Integer > adjacencyList[]; //Adjacency Lists
    @SuppressWarnings("unchecked")
        // Constructor
    Graph(int vert) {
        this.vertices = vert;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < this.vertices; ++i)
            this.adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
        this.adjacencyList[destination].add(source);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }
};


class Coloring {
    public static void greedyColoring(Graph g) {
        int numofVertices = g.getVertices();
        int[] result = new int[numofVertices];
        boolean[] available = new boolean[numofVertices]; // max j colors


        Arrays.fill(result, -1);
        result[0] = 0;

        Arrays.fill(available, true);
        LinkedList<Integer> Llist[];
        Llist = g.getAdj();
        // first loop all vertice by assigning a new number, then second minimise the number

        for (int i = 1; i < numofVertices; i++) {
            Iterator<Integer> vertice = Llist[i].iterator();
            while (vertice.hasNext()) {
                Integer temp = vertice.next();
                if (result[temp] != -1) {
                    available[result[temp]] = false;
                }
            }
            int j;
            for (j = 0; j < available.length; j++) {
                if (available[j])
                    break;
            }

            result[i] = j;

            Arrays.fill(available, true);


        }

        for (int i = 0; i < numofVertices; i++) {
            System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);

        Coloring.greedyColoring(g1);
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        Coloring.greedyColoring(g2);
    }
}