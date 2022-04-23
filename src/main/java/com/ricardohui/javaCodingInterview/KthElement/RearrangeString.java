package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class RearrangeString {

    public static String rearrangeString(String str) {
        int totalCharacters = str.length();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Queue<Character> maxFirst = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get).reversed());
        for (Character character : str.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }
        maxFirst.addAll(frequencyMap.keySet());

        if (!maxFirst.isEmpty() && totalCharacters % 2 == 0 &&  frequencyMap.get(maxFirst.peek()) >= (totalCharacters / 2) ){
            return "";
        }

        if (!maxFirst.isEmpty() && totalCharacters % 2 == 1 &&  frequencyMap.get(maxFirst.peek()) > (totalCharacters / 2) + 1 ){
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!maxFirst.isEmpty()) {
            Character currentCharacter = maxFirst.poll();

            while (frequencyMap.get(currentCharacter) > 0 ){
                stringBuilder.append(currentCharacter);
                frequencyMap.put(currentCharacter, frequencyMap.get(currentCharacter) - 1);

                if (maxFirst.isEmpty()) continue;

                Character nextCharacter = maxFirst.peek();
                stringBuilder.append(nextCharacter);
                frequencyMap.put(nextCharacter, frequencyMap.get(nextCharacter) - 1);
                if (frequencyMap.get(nextCharacter) <= 0) {
                    maxFirst.poll();
                }

            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}