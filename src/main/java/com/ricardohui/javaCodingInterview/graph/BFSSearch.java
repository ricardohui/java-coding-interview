package com.ricardohui.javaCodingInterview.graph;

import java.util.*;
class BFSSearch {

    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        String result = "";

        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < g.vertices; i++){
            if(visited.contains(i)) continue;
            Queue<Integer> queue = new Queue<Integer>(g.vertices);
            queue.enqueue(i);
            visited.add(i);

            while(!queue.isEmpty()){
                Integer currentNode = queue.dequeue();
                result = result + currentNode + "";

                DoublyLinkedList<Integer>.Node edge = g.adjacencyList[currentNode].getHeadNode();

                while (edge!=null){
                    if(!visited.contains(edge.data)){
                        visited.add(edge.data);
                        queue.enqueue(edge.data);
                    }
                    edge = edge.nextNode;
                }
            }



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
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }

}