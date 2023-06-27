package com.ricardohui.javaCodingInterview.graph;

import java.util.Iterator;

public class Graph{
    int vertices; //Total number of vertices in graph
    DoublyLinkedList<Integer> adjacencyList[]; //An array of linked lists to store adjacent vertices.




    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        if (source < vertices && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);

            //for undirected graph uncomment the line below
            this.adjacencyList[destination].insertAtEnd(source);
        }
    }

    public void removeEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            DoublyLinkedList<Integer>.Node childNode = this.adjacencyList[source].headNode;
            DoublyLinkedList<Integer>.Node parent = null;
            while (childNode != null) {
                if (childNode.data == destination) {
                    if (parent != null){
                        parent.nextNode = childNode.nextNode;
                    }else{
                        this.adjacencyList[source].headNode = childNode.nextNode;
                    }
                    break;
                }
                parent = childNode;
                childNode = childNode.nextNode;
            }

            // for reversed direction
            childNode = this.adjacencyList[destination].headNode;
            parent = null;
            while (childNode != null) {
                if (childNode.data == destination) {
                    if (parent != null) {
                        parent.nextNode = childNode.nextNode;
                    }else{
                        this.adjacencyList[source].headNode = childNode.nextNode;
                    }
                    break;
                }
                parent = childNode;
                childNode = childNode.nextNode;
            }

        }
    }

    public int getVertices() {
        return this.vertices;
    }
    public void printGraph()
    {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

    public Graph getTranspose() {
        Graph g = new Graph(vertices);
        for (int j = 0; j < vertices; j++) {
            DoublyLinkedList.Node childNode = adjacencyList[j].headNode;
            while (childNode != null) {
                g.addEdge((Integer) childNode.data, j);
                childNode = childNode.nextNode;
            }

        }
        return g;
    }


    public void dfsTraversal(int v, boolean visited[]) {
        visited[v] = true;
        int source = 0;

        DoublyLinkedList<Integer>.Node childNode = adjacencyList[v].headNode;
        while (childNode != null) {
            if (!visited[childNode.data]) {
                dfsTraversal(childNode.data,visited );
            }

            childNode = childNode.nextNode;
        }

    }
}

