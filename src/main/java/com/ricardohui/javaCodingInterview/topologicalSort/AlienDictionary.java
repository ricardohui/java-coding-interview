package com.ricardohui.javaCodingInterview.topologicalSort;

import com.ricardohui.javaCodingInterview.graph.Graph;
import javafx.scene.chart.LineChart;

import java.util.*;

class AlienDictionary {

    protected static boolean contains(List<char[]> prerequisites, char[] pair) {
        int i = 0;
        while (i < prerequisites.size()) {
            if (prerequisites.get(i)[0] == pair[0] && prerequisites.get(i)[1] == pair[1]) {
                return true;
            }

            i++;
        }
        return false;
    }

    public static char[] findDifferentCharacter(String s1, String s2) {
        // given two strings, return the characters of each string in a pair that differ.
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return new char[]{s1.charAt(i), s2.charAt(j)};
            }
            i++;
            j++;
        }
        return new char[]{};
    }
    public static String findOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }

        List<char[]> prerequisites = new ArrayList<>();
        Set<Character> distinctCharacterSet = new HashSet<>();

        for (int i = 0; i < words.length - 1; i++) {
            char[] pair = findDifferentCharacter(words[i], words[i + 1]);
            if (!contains(prerequisites, pair)) {
                prerequisites.add(pair);
            }

            distinctCharacterSet.add(pair[0]);
            distinctCharacterSet.add(pair[1]);
        }

        int tasks = prerequisites.size();
        List<Character> distinctCharacters = new ArrayList<>(distinctCharacterSet);

        // init
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();
        for (int i = 0; i <  distinctCharacters.size(); i++){
            graph.put(distinctCharacters.get(i), new ArrayList<>());
            inDegrees.put(distinctCharacters.get(i), 0);
        }

        // build graph
        for (int i = 0; i < prerequisites.size(); i++) {

            graph.get(prerequisites.get(i)[0]).add(prerequisites.get(i)[1]);
            inDegrees.put(prerequisites.get(i)[1], prerequisites.get(i)[1] + 1);
        }

        Queue<Character> workingQueue = new LinkedList<>();
        // find vertice with zero indegrees
        for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                workingQueue.add(entry.getKey());
            }
        }

        // loop through
        StringBuilder stringBuilder = new StringBuilder();
        while (!workingQueue.isEmpty()) {
            Character character = workingQueue.poll();
            stringBuilder.append(character);
            List<Character> children = graph.get(character);
            System.out.println(children.size());
            for (Character child : children) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    workingQueue.add(child);
                }
            }
        }

        // check cycle


        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}