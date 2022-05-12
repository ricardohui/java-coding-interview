/* https://www.educative.io/module/lesson/algorithms-in-java/xoqAB8yl98n
    Depth First Search on Graph
 */

package com.ricardohui.javaCodingInterview.graph;

import com.ricardohui.javaCodingInterview.graph.DoublyLinkedList;

import java.util.HashSet;

class CheckDFS {
    public static String dfs(Graph g) {
        String result = "";
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < g.vertices; i++) {
            result = result + recursive(g, i, visited);
            
        }


        return result;
    }

    public static String recursive(Graph g, Integer currentNode, HashSet<Integer> visited){
        if (visited.contains(currentNode)) return "";
        String result = currentNode + "";
        visited.add(currentNode);
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[currentNode].headNode;

        while (edge != null) {
           if(!visited.contains(edge.data)){
               result = result + recursive(g, edge.data, visited);
               visited.add(currentNode);
           }
            edge = edge.nextNode;
        }

        return result;

    }
    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}