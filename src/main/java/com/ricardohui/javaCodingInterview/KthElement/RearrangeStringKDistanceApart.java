package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        if (k <= 1) {
            return str;
        }
        // frequencyMap
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        // add all keyset to the maxFirst
        maxHeap.addAll(characterFrequencyMap.entrySet());

        StringBuilder stringBuilder = new StringBuilder(str.length());
        LinkedList<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            stringBuilder.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.offer(currentEntry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0)
                    maxHeap.add(entry);
            }
        }


        return str.length() == stringBuilder.length() ?stringBuilder.toString(): "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                                   RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                                   RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                                   RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                                   RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}