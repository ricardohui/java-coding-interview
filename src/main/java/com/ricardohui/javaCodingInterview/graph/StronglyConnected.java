package com.ricardohui.javaCodingInterview.graph;

import org.w3c.dom.NamedNodeMap;
/*https://www.educative.io/module/lesson/algorithms-in-java/B6wB83QzJnW
* */
class StronglyConnected {

    public static void utilityFunction(Graph g, int v, boolean visited[]) {
        //use this helper function if you want to
        visited[v] = true;

        DoublyLinkedList<Integer>.Node child = g.adjacencyList[v].headNode;
        while (child != null) {
            if (!visited[child.data]){
                utilityFunction(g, child.data, visited);
            }
            child = child.nextNode;
        }
    }


    public static boolean isStronglyConnected(Graph g) {
        int numOfVertices = g.getVertices();
        boolean[] visited = new boolean[numOfVertices];

        utilityFunction(g, 0, visited);

        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        //reset
        for (int i = 0; i < numOfVertices; i++) {
            visited[i] = false;
        }

        Graph tranposedGraph = g.getTranspose();

        utilityFunction(tranposedGraph,0,visited);

        //check all nodes are visited
        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;


    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        Object x = StronglyConnected.isStronglyConnected(g1);
        System.out.println("Graph g1 is strongly connected? " + x);


        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        x = StronglyConnected.isStronglyConnected(g2);
        System.out.println("Graph g2 is strongly connected? " + x);
    }
}