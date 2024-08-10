package com.ricardohui.javaCodingInterview.graph;


import java.util.*;

public class CheckTree {
    public static boolean isTree(Graph g) {
        HashMap<Integer,Integer> indegree = new HashMap<>();
        boolean[] visited = new boolean[g.vertices];
        // collect indegree by doing dfs
        for (int i = 0; i < g.vertices; i++) {
            dfs(g, i, visited, indegree);
        }


        // find the root with the indegree 0
        List<Integer> vertexWithZeroDegree = new ArrayList<>();
        for (int i = 0; i < g.vertices; i++) {
            if (indegree.getOrDefault(i, 0)==0) vertexWithZeroDegree.add(i);
        }

        if (vertexWithZeroDegree.size() <= 0) {
            return false;
        }


        //dfs once to see if every vertex is visited (coompleted)
        int root = vertexWithZeroDegree.get(0);
        Arrays.fill(visited, false);
        dfs(g,root,visited, indegree);

        for (boolean value: visited) {
            if (!value) return false;
        }

        return  true;
    }

    public static void dfs(Graph g, Integer source, boolean[] visited, HashMap<Integer, Integer> indegree){
        // mark visited
        visited[source] = true;


        DoublyLinkedList<Integer>.Node childNode  =  g.adjacencyList[source].getHeadNode();
        while (childNode != null) {
            if (!visited[childNode.data]) {
                indegree.put(source, indegree.getOrDefault(source,0)+1);
                dfs(g, childNode.data, visited, indegree);
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
