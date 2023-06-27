package com.ricardohui.javaCodingInterview.graph;

class CheckPaths {

    public static boolean checkPath(Graph g, int source, int destination) {

        boolean[] visited = new boolean[g.getVertices()];

        return recursion(g, source, destination, visited);
    }

    public static boolean recursion(Graph graph, int vertex, int target, boolean[] visited) {

        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[vertex].headNode;
        visited[vertex] = true;
        if (vertex == target) {
            return true;
        }
        while (childNode != null) {
            if (!visited[childNode.data]){
                if (recursion(graph, childNode.data, target, visited)) {
                    return true;
                }
            }

            childNode = childNode.nextNode;
        }
        return false;

    }

    public static void main(String args[]) {

        Graph g1 = new DirectedGraph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        Graph g2 = new DirectedGraph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }
}