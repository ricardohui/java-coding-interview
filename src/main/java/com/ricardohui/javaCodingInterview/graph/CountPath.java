package com.ricardohui.javaCodingInterview.graph;
/* https://www.educative.io/module/lesson/algorithms-in-java/qVn507XBLEG
* */
import java.util.HashSet;
import java.util.LinkedList;

class CountPath {

    public static int countPaths(Graph g, int start, int destination) {
        int numOfVertices = g.getVertices();
        if (start > numOfVertices || destination > numOfVertices) {
            return 0;
        }
        HashSet<Integer> visited = new HashSet<>();
        return recursion(g, start,destination, visited);
    }

    public static Integer recursion(Graph graph, int parent, int target, HashSet<Integer> visited) {
        int sum = 0;
        visited.add(parent);
        if (parent == target) {
            sum = 1;
        }
        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[parent].getHeadNode();
        while (childNode != null) {
//            if (!visited.contains(childNode.data)) {
                visited.add(childNode.data);
                sum+=recursion(graph, childNode.data, target, visited);
//            }
            childNode = childNode.nextNode;
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
