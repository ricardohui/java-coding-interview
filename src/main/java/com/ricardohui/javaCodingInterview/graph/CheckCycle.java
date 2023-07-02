package com.ricardohui.javaCodingInterview.graph;

import java.util.HashMap;
import java.util.HashSet;

class CheckCycle {
    public static boolean detectCycle(Graph g){

        // define a visited hashset
        HashSet<Integer> visited = new HashSet<>();

        // get the first element
        for (int startingNode = 0; startingNode < g.vertices; startingNode++) {
            HashMap<Integer, Integer> frequency = new HashMap<>();

            if (dfs(g, visited, startingNode, frequency)) {
                return true;
            }
        }

        // call dfs


        return false;
    }


    static boolean dfs(Graph g, HashSet<Integer> visited, Integer currentIndex, HashMap<Integer, Integer> frequency){
        if(visited.contains(currentIndex) && frequency.getOrDefault(currentIndex, 0) >= 1) {
            // cycle detected
            return true;
        }

        // marked visit
        visited.add(currentIndex);
        frequency.put(currentIndex, frequency.getOrDefault(currentIndex, 0)+1);

        // loop each edge
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[currentIndex].getHeadNode();
        while (edge != null) {

            if (dfs(g, visited, edge.data, frequency)){
                return true;
            }
            frequency.put(edge.data, frequency.get(edge.data) - 1); //backtrack missed!!!
            edge = edge.nextNode;
        }

        return false;
    }


    public static void main(String args[]) {
        Graph g1 = new DirectedGraph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new DirectedGraph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}