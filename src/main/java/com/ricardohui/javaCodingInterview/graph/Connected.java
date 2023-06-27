package com.ricardohui.javaCodingInterview.graph;
/* https://www.educative.io/module/lesson/algorithms-in-java/B6KKop69Qyk
* */
import sun.jvm.hotspot.debugger.windbg.DLL;

import java.util.Iterator;

class Connected{

    public static void dfsTraversal(Graph graph, int v, boolean visited[]) {
        visited[v] = true;
        int source = 0;

        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[v].headNode;
        while (childNode != null) {
            if (!visited[childNode.data]) {
                dfsTraversal(graph, childNode.data, visited);
            }

            childNode = childNode.nextNode;
        }

    }
    public static boolean isConnected(Graph g) {
        //use this helper function if you want to
        boolean[] visited = new boolean[g.getVertices()];

        dfsTraversal(g, 0, visited);

        for (int i = 0; i < g.getVertices(); i++) {
            if (!visited[i]) {
                // proceed when true;
                System.out.println("node "+ i+ "is found not visited");
                return false;
            }
            // at the same time reset value

            visited[i] = false;
        }

        dfsTraversal(g.getTranspose(), 0, visited);
        for (int i = 0; i < g.getVertices(); i++) {
            if (!visited[i]) {
                System.out.println("node "+ i+ "is found not visited");
                return false;
            }

        }

        return true;
    }

    public static Object willCauseSeparateComponents(Graph g, int source, int destination) {
        // remove the given edge
        removeEdge(g, source, destination);
        removeEdge(g,destination,source);

        // check connected
        return !isConnected(g);
    }

    private static void removeEdge(Graph g, int source, int destination) {
        DoublyLinkedList<Integer>.Node childNode = g.adjacencyList[source].headNode;
        DoublyLinkedList<Integer>.Node parentNode = null;
        while (childNode != null) {
            if (childNode.data == destination) {
                if (parentNode == null) {
                    g.adjacencyList[source].headNode = childNode.nextNode;
                }else{
                    parentNode.nextNode = childNode.nextNode;
                }
            }
            parentNode = childNode;
            childNode = childNode.nextNode;
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);

        // remove edge 3 -> 4
        Object x = Connected.willCauseSeparateComponents(g, 3, 4);
        System.out.println("Separate components created due to deletion of edge 3 -> 4? " + x);

        // remove edge 1 -> 2
        x = Connected.willCauseSeparateComponents(g, 1, 2);
        System.out.println("Separate components created due to deletion of edge 1 -> 2? " + x);

    }
}