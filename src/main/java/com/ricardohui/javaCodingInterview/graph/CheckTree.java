package com.ricardohui.javaCodingInterview.graph;


import java.util.*;

public class CheckTree {
    public static boolean isTree(Graph g) {
        // Write -- Your -- Code
        int numOfVertices = g.vertices;
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Queue<Integer> queue = new Queue<>(g.vertices);

        // build inDegrees
        for (int i = 0; i < numOfVertices; i++) {
            inDegrees.putIfAbsent(i, 0);
            DoublyLinkedList<Integer>.Node childNode = g.adjacencyList[i].headNode;
            while (childNode != null) {
                inDegrees.put(childNode.data, inDegrees.getOrDefault(childNode.data, 0) + 1);
                childNode = childNode.nextNode;
            }
        }


        // find out nodes with inDegrees with 0
        List<Integer> verticesWithZeroInDegree = new ArrayList<>();
        for (Map.Entry<Integer, Integer> child : inDegrees.entrySet()) {
            if (child.getValue() == 0) {
                verticesWithZeroInDegree.add(child.getKey());
            }
            if (child.getValue() > 1) {
                return false;
            }
        }

        System.out.println("number of vertices with zero indegress " + verticesWithZeroInDegree.size());
        if (verticesWithZeroInDegree.size() != 1) {
            return false;
        }

        Integer root = verticesWithZeroInDegree.get(0);
        boolean[] visited = new boolean[numOfVertices];
        dfs(g, root, visited);


        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    public static void dfs(Graph graph, int root, boolean[] visited) {
        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[root].headNode;
        visited[root] = true;
        while (childNode != null) {
            if (!visited[childNode.data]){
                dfs(graph, childNode.data, visited);
            }
            childNode = childNode.nextNode;
        }
    }

    public static void main(String args[]) {

        Graph g = new DirectedGraph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

        Graph g2 = new DirectedGraph(4);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(0,3);
        g2.addEdge(3,2);
        g2.printGraph();
        System.out.println("isTree : " + isTree(g2));

        Graph g3 = new DirectedGraph(6);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(0,3);
        g3.addEdge(4,5);
        g3.printGraph();
        System.out.println("isTree : " + isTree(g3));
    }
}
