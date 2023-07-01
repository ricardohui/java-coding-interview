/* https://www.educative.io/module/lesson/algorithms-in-java/xoqAB8yl98n
    Depth First Search on Graph
 */

package com.ricardohui.javaCodingInterview.graph;

import com.ricardohui.javaCodingInterview.graph.DoublyLinkedList;
import sun.jvm.hotspot.types.CIntegerField;
import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.HashSet;

class CheckDFS {
    public static String dfs(Graph g) {
        String result = "";
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < g.vertices; i++) {
            result = result + recursion(g, visited, i);
        }


        return result;
    }


    static String recursion(Graph g, HashSet<Integer> visited, int currentIndex) {
        if (visited.contains(currentIndex)) return "";

        String result = "";

        // mark visited
        visited.add(currentIndex);

        // add to result
        result += String.valueOf(currentIndex);

        // recursively go through the children of this null
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[currentIndex].getHeadNode();
        while (edge != null) {
            if(!visited.contains(edge.data)){
                result += recursion(g, visited, edge.data);
            }

            edge = edge.nextNode;
        }
        return  result;
    }

    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(4, 3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}