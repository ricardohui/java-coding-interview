package com.ricardohui.javaCodingInterview.greedy;

import java.util.*;
import java.lang.*;

class MinSpinningTreeGraph {

    int Vertex, Edges;
    Edge edge[];

    @SuppressWarnings("unchecked")

    //class to represent an edge
    public static class Edge implements Comparable < Edge > {
        int source, destination, weight;

        public int compareTo(Edge var) {
            return this.weight - var.weight;
        }
    };

    //class to represent disjoint sets
    public static class DisjointSets {
        int p, r; //parent of this vertex and root of this vertex. r is the no. of elements in the sets
    }


    public MinSpinningTreeGraph(int v, int e) {
        Vertex = v;
        Edges = e;
        edge = new Edge[Edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    //fund function
    int find(DisjointSets mySet[], int v) {
        // find root and make root as parent of i (path compression)
        if (mySet[v].p != v) // when v == [v].p, the vertex is the root
            mySet[v].p = find(mySet, mySet[v].p);

        return mySet[v].p; // same as return v as mySet[v].p != v
    }
    //merge function
    void merge(DisjointSets mySet[], int i, int j) {
        int set_i = find(mySet, i);
        int set_j = find(mySet, j);

        if (mySet[set_i].r < mySet[set_j].r)
            mySet[set_i].p = set_j;
        else if (mySet[set_i].r > mySet[set_j].r)
            mySet[set_j].p = set_i;
        else {
            mySet[set_j].p = set_i;
            mySet[set_i].r++;
        }
    }
}

class Kruskal {
    public static void KruskalMST(MinSpinningTreeGraph g) {
        int vertexNum = g.Vertex;
        int i = 0, j = 0;
        MinSpinningTreeGraph.Edge[] answer = new MinSpinningTreeGraph.Edge[vertexNum];
        MinSpinningTreeGraph.DisjointSets[] mySet = new MinSpinningTreeGraph.DisjointSets[vertexNum];

        for (i = 0; i < g.Vertex; i++) {
            answer[i] = new MinSpinningTreeGraph.Edge();
            mySet[i] = new MinSpinningTreeGraph.DisjointSets();
            mySet[i].p = i;
            mySet[i].r = 0;

        }

        Arrays.sort(g.edge);

        i = 0;
        while (j < g.Vertex - 1) {
            MinSpinningTreeGraph.Edge edge = g.edge[i++];

            int sourceRoot = g.find(mySet, edge.source);
            int destinationRoot = g.find(mySet, edge.destination);

            if (sourceRoot != destinationRoot) {
                answer[j] = edge;
                j++;
                g.merge(mySet, sourceRoot, destinationRoot);
            }

        }



        //printing contents of answer[] to display the MST
        for (i = 0; i < j; ++i)
            System.out.println(answer[i].source + " , " + answer[i].destination);

    }
}

class Main {
    public static void main(String[] args) {

        int V = 4, E = 5;
        MinSpinningTreeGraph graph = new MinSpinningTreeGraph(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].source = 0;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].source = 2;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 4;

        System.out.println("Minimum Spanning Tree of Graph 1");
        Kruskal.KruskalMST(graph);
        System.out.println();


        V = 6;
        E = 15;
        MinSpinningTreeGraph graph1 = new MinSpinningTreeGraph(V, E);


        graph1.edge[0].source = 0;
        graph1.edge[0].destination = 1;
        graph1.edge[0].weight = 4;

        graph1.edge[1].source = 0;
        graph1.edge[1].destination = 2;
        graph1.edge[1].weight = 3;

        graph1.edge[2].source = 1;
        graph1.edge[2].destination = 2;
        graph1.edge[2].weight = 1;


        graph1.edge[3].source = 1;
        graph1.edge[3].destination = 3;
        graph1.edge[3].weight = 2;

        graph1.edge[4].source = 2;
        graph1.edge[4].destination = 3;
        graph1.edge[4].weight = 4;

        graph1.edge[5].source = 3;
        graph1.edge[5].destination = 4;
        graph1.edge[5].weight = 2;

        graph1.edge[6].source = 4;
        graph1.edge[6].destination = 5;
        graph1.edge[6].weight = 6;

        System.out.println("Minimum Spanning Tree of Graph 2");
        Kruskal.KruskalMST(graph1);
    }
}