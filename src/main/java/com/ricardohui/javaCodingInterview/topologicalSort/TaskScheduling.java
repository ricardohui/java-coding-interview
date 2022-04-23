package com.ricardohui.javaCodingInterview.topologicalSort;


import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {


        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // 1. initialise the graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // 2. build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // 3. vertice with 0 in-degrees
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 4. while !vertice is not empty
        while (!queue.isEmpty()) {
            Integer vertice = queue.poll();
            result.add(vertice);
            List<Integer> children = graph.get(vertice);
            for (Integer child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                // add source to the queue
                if (inDegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }


        // 5. check cycle

        return result.size() == tasks;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                                                     new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}