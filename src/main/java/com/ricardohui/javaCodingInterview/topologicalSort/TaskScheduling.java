
/* https://www.educative.io/module/lesson/algorithms-in-java/m2MwgwXPD5p
* */
package com.ricardohui.javaCodingInterview.topologicalSort;


import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        // initialization two hashtables for graph from edge and indegree
        Map<Integer, LinkedList<Integer>> adjacentList = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Queue<Integer> sources = new LinkedList<>();
        List<Integer> sortedOrder = new ArrayList<>();

        for (int i = 0; i < tasks; i++) {
            adjacentList.put(i, new LinkedList<>());
            inDegrees.put(i, 0);
        }

        // build two hashtables for graph from edge and indegrees
        for (int[] prereq : prerequisites) {
            int start = prereq[0];
            int end = prereq[1];
            adjacentList.get(start).add(end);
            inDegrees.put(end, inDegrees.get(end)+1);
        }

        // find all vertices with 0 indegrees
        for (int i = 0; i < tasks; i++) {
            if (inDegrees.get(i) == 0) {

                sources.add(i);
            }
        }

        // loop through vertices
        while (!sources.isEmpty())
        {
            int vertice = sources.poll();
            sortedOrder.add(vertice);

            ListIterator<Integer> listIterator = adjacentList.get(vertice).listIterator();
            while (listIterator.hasNext()) {
                Integer child = listIterator.next();
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    sources.add(child);
                }
            }
        }


        // check cycle
        System.out.println(sortedOrder);

        return sortedOrder.size() == tasks;
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