package com.ricardohui.javaCodingInterview.topologicalSort;

import java.util.*;

class SequenceReconstruction {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        List<Integer[]> newSequence = new ArrayList<>();
        for (int[] sequence : sequences) {
            if (sequence.length > 2) {
                for (int i = 1; i < sequence.length; i++) {
                    newSequence.add(new Integer[]{sequence[i - 1], sequence[i]});
                }

            } else if (sequence.length == 2) {
                newSequence.add(new Integer[]{sequence[0], sequence[1]});
            }else{
                System.out.println("sequence length smaller than 2");
            }
        }

        // initial graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < originalSeq.length; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        
        // build graph
        for (int i = 0; i < newSequence.size(); i++) {
            Integer parent = newSequence.get(i)[0], child = newSequence.get(i)[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(i) + 1);
        }

        // find the source
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        ArrayList<Integer[]> resultList = new ArrayList<>();
        recursive(graph, inDegree, sources, resultList);

        if (resultList.size() == 1) {
            for (int i = 0; i < resultList.get(0).length; i++) {
                if (resultList.get(0)[i] != originalSeq[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;

    }

    private static void recursive(HashMap<Integer, List<Integer>> graph,
                                  HashMap<Integer, Integer> inDegree,
                                  Queue<Integer> sources, ArrayList<Integer[]> resultList){
        // for source > recursive
        for (int i = 0; i < sources.size(); i++) {
            Integer vertex = sources.poll();
            Queue<Object> newSource = cloneQueue(sources);


            List<Integer> children = graph.get(vertex);
            for (Integer child: children) {
                if (inDegree.get(child)==0) {
                    newSource.add(child);
                }
            }



        }
    }

    private static LinkedList<Object> cloneQueue(Queue<Integer> queue) {
        LinkedList<Object> clone = new LinkedList<>();
        for (Integer item : queue) {
            clone.add(item);
        }
        return clone;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                                                             new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                                                     new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
                                                     new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}