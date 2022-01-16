package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        int intervals = 0;
        for (char c: tasks) {
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());
        maxHeap.addAll(characterFrequencyMap.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            intervals++;
            entry.setValue(entry.getValue() - 1);
            characterFrequencyMap.put(entry.getKey(), entry.getValue());
            queue.add(entry);
            int buffer = 0;
            if (queue.size() + buffer == k + 1 ) {
                buffer = 0;
                Map.Entry<Character, Integer> entry1 = queue.poll();
                if (entry1.getValue() > 0) {
                    maxHeap.add(entry1);
                }
            }else{
                intervals++;
                buffer++;
                System.out.println(buffer);
            }
        }


        return intervals;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}