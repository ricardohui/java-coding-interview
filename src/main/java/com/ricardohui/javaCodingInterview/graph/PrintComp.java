package com.ricardohui.javaCodingInterview.graph;

public class PrintComp {
    public static void printConnectedComponents(Graph g) {
        int numOfVertices = g.vertices;
        boolean[] visited = new boolean[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i]){
                traverseChildNode(g,i,visited);
                System.out.println();
            }

        }
    }
    public static void traverseChildNode(Graph graph,  int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v + " ");
        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[v].headNode;
        while (childNode != null) {
            if(!visited[childNode.data]){
                traverseChildNode(graph, childNode.data, visited);
            }
            childNode = childNode.nextNode;
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        System.out.println("The connected components are:");
        PrintComp.printConnectedComponents(g);

    }
}
