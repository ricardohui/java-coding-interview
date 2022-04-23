package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> frequencyMapByCharacter = new HashMap<>();
        Queue<Character> maxHeap = new PriorityQueue<>((c1, c2)-> frequencyMapByCharacter.get(c2) - frequencyMapByCharacter.get(c1));

        for (int i = 0; i < str.length(); i++) {

            char currentCharacter = str.charAt(i);
            frequencyMapByCharacter.put(currentCharacter,
                                        frequencyMapByCharacter.getOrDefault(currentCharacter, 0) + 1);
//            if (!maxHeap.contains(currentCharacter))
//                maxHeap.offer(currentCharacter);
        }

        maxHeap.addAll(frequencyMapByCharacter.keySet());

        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character currentCharacter = maxHeap.poll();
            int count = frequencyMapByCharacter.get(currentCharacter);
            int i =0;
            while (i < count) {
                stringBuilder.append(currentCharacter);
                i++;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}