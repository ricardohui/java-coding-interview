package com.ricardohui.javaCodingInterview.topologicalSort;

import java.util.*;

class TaskSchedulingOrder {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // initialise graph
        for (int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        // build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        Queue<Integer> source = new LinkedList<>();
        // find out the source
        for (Map.Entry<Integer, Integer> set: inDegree.entrySet()) {
            if (set.getValue()==0) {
                source.offer(set.getKey());
            }
        }

        // while the source is not empty
        while (!source.isEmpty()) {
            Integer vertice = source.poll();
            sortedOrder.add(vertice);
            List<Integer> children = graph.get(vertice);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child)-1);
                if (inDegree.get(child) == 0) {
                    source.offer(child);
                }
            }
        }

        // if there is cyclic dependency
        if (sortedOrder.size() != tasks) {
            return new ArrayList<>();
        }


        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
                                               new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}