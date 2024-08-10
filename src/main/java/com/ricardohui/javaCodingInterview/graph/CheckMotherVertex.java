package com.ricardohui.javaCodingInterview.graph;


import java.util.*;

class CheckMotherVertex {

    public static int findMotherVertex(Graph g){
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> aQueue = new Queue<>(g.vertices);

        for (int startingNode = 0; startingNode < g.vertices; startingNode++) {
            if (visited.contains(startingNode)) continue;

            aQueue.enqueue(startingNode);

            while (!aQueue.isEmpty()){
                Integer currentNode = aQueue.dequeue();

                // mark visited
                visited.add(currentNode);


                // add the children to the queue if not visited
                DoublyLinkedList<Integer>.Node  edge= g.adjacencyList[currentNode].getHeadNode();
                while (edge != null) {
                    indegree.put(edge.data, indegree.getOrDefault(edge.data, 0)+1);
                    if (!visited.contains(edge.data)){
                        aQueue.enqueue(edge.data);
                    }
                    edge = edge.nextNode;
                }


            }
        }

        // check in degree
        List<Integer> sources = new ArrayList<>(g.vertices);
        for (int startingIndex = 0; startingIndex < g.vertices; startingIndex++) {
            if((indegree.get(startingIndex)==0)){
                sources.add(startingIndex);
            }
        }
        if (sources.size() > 0) {
            return sources.get(0);
        }
        return -1;

    }

    public static void main(String args[]) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));

    }
}