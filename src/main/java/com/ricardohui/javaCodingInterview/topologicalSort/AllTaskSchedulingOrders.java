package com.ricardohui.javaCodingInterview.topologicalSort;

import java.util.*;

class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        // initialise the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        // build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        // find out those source
        for (Map.Entry<Integer, Integer> set : inDegree.entrySet()) {
            if (set.getValue() == 0) {
                sources.add(set.getKey());
            }
        }

        ArrayList<Integer> sortedArray = new ArrayList<>();
        recursive(graph, inDegree, sources, sortedArray);

    }

    private static void recursive(Map<Integer, List<Integer>> graph,
                                  Map<Integer, Integer> inDegree,
                                  Queue<Integer> sources,
                                  List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (int vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);

                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child);
                }


                recursive(graph, inDegree, sourcesForNextCall, sortedOrder);

                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }
        if (sortedOrder.size() == inDegree.size())
            System.out.println(sortedOrder);

    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue) {
            clone.add(num);
        }
        return clone;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                                            new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6,
                                            new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4}, new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println();
    }
}