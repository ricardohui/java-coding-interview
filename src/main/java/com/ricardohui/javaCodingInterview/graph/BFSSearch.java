package com.ricardohui.javaCodingInterview.graph;

import java.util.*;

class BFSSearch {

    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        String result = "";


        // define a visited array having all false value
        HashSet<Integer> visited = new HashSet<>();

        // go through all the vertice once
        for (int currentNode = 0; currentNode < g.vertices; currentNode++) {
            // define a queue
            if (visited.contains(currentNode)) continue;
            Queue<Integer> aQueue = new Queue<Integer>(g.vertices);
            aQueue.enqueue(currentNode);
            visited.add(currentNode);

            while (!aQueue.isEmpty()) {
                Integer dequeue = aQueue.dequeue();
                result = result + dequeue+"";
                DoublyLinkedList<Integer>.Node node = g.adjacencyList[dequeue].getHeadNode();
                while (node != null) {
                    if (!visited.contains(node.data)){
                        aQueue.enqueue(node.data);
                        visited.add((Integer) node.data);
                    }
                    node = node.nextNode;
                }
            }
        }


        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(3, 4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }

}