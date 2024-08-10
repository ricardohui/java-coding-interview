package com.ricardohui.javaCodingInterview.graph;

public class CheckMin {

    public static int findMin(Graph g, int source, int destination) {
        boolean[] visited = new boolean[g.getVertices()];
        return recursion(g, source, destination, visited, 0);
   }

   public static int recursion(Graph graph, int currentVertex, int destination, boolean[] visited, int depth){

        if (currentVertex == destination){
            return depth;
        }


       // mark visited
        visited[currentVertex] = true;

        int min = Integer.MAX_VALUE;

        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[currentVertex].getHeadNode();
       while (childNode != null) {
            if(!visited[childNode.data]){
                min = Math.min(min, recursion(graph, childNode.data, destination, visited, depth+1));
            }

            childNode = childNode.nextNode;
       }

        return min;

   }


    public static void main(String args[]) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(findMin(g, 0, 4));
    }
}
