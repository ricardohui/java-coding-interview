package com.ricardohui.javaCodingInterview.graph;
/* https://www.educative.io/module/lesson/algorithms-in-java/qVn507XBLEG
* */
import java.util.HashSet;
import java.util.LinkedList;

class CountPath {

    public static int countPaths(Graph g, int start, int destination) {
        HashSet<Integer> visited = new HashSet<>(g.vertices);
        return recursion(g, start, destination, visited);
    }

    public static int recursion(Graph g, int start, int target, HashSet<Integer> visited){

        int sum = 0;

        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[start].headNode;
        while (edge!=null) {
            if (edge.data == target) {
                return 1;
            }else{
                if (!visited.contains(edge.data)) {
                    visited.add(edge.data);
                    sum += recursion(g, edge.data, target, visited);    
                }
                

            }
            
            edge = edge.nextNode;
        }

        return sum;
    }



    public static void main(String args[]) {

        int answer;
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = CountPath.countPaths(g1, 0, 5);
        System.out.println(answer);

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 5);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(5, 3);
        g2.addEdge(5, 6);
        g2.addEdge(3, 6);

        answer = CountPath.countPaths(g2, 0, 3);
        System.out.println(answer);
    }
}
