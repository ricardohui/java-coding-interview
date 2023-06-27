package com.ricardohui.javaCodingInterview.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CheckMotherVertex {

    public static int findMotherVertex(Graph g){
        Map<Integer, Integer> inDegrees = new HashMap<>();
        List<Integer> sources = new ArrayList<>(g.getVertices());

        // build graph
        for (int parent = 0; parent < g.getVertices(); parent++) {
            DoublyLinkedList<Integer>.Node childNode = g.adjacencyList[parent].headNode;
            while (childNode != null) {
                inDegrees.put(childNode.data,
                              inDegrees.getOrDefault(childNode.data, 0) + 1);

                childNode = childNode.nextNode;
            }
        }

        // find out all the vertice with 0 indegree
        for (int i = 0; i < g.getVertices(); i++) {
            if (inDegrees.getOrDefault(i, 0) <= 0) {
                sources.add(i);
            }
        }

        // eliminate the source and add new source to the queue


        // check cycle
        if (sources.size() > 0) {
            return sources.get(0);
        }
        return -1;
    }
}