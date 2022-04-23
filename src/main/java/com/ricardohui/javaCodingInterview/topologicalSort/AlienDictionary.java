package com.ricardohui.javaCodingInterview.topologicalSort;

import javafx.scene.chart.LineChart;

import java.util.*;

class AlienDictionary {
    protected static char[] findPrecedenceAlphabet(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i)!=s2.charAt(i)){
                return new char[]{s1.charAt(i), s2.charAt(i)};
            }
            i++;
            j++;
        }
        return new char[]{};
    }

    private static boolean contain(List<char[]> prerequisites, char[] pair) {
        int i = 0;
        while (i < prerequisites.size()) {
            if (prerequisites.get(i)[0] == pair[0] && prerequisites.get(i)[1] == pair[1]) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static String findOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }


        List<char[]> prerequisites = new ArrayList<>();
        Set<Character> unqiueCharacterSet = new HashSet<>();

        for (int i = 1; i < words.length; i++) {
            char[] pair = findPrecedenceAlphabet(words[i - 1], words[i]);
            if (!contain(prerequisites,pair)) {
                prerequisites.add(pair);
            }
            unqiueCharacterSet.add(pair[0]);
            unqiueCharacterSet.add(pair[1]);
        }
        int tasks = prerequisites.size();
        List<Character> uniqueCharacters = new ArrayList<>(unqiueCharacterSet);

        // initial the graph
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < uniqueCharacters.size(); i++) {
            graph.put(uniqueCharacters.get(i), new ArrayList<>());
            inDegree.put(uniqueCharacters.get(i), 0);
        }

        // build the graph
        for (int i = 0; i < tasks; i++) {
            char parent = prerequisites.get(i)[0], child = prerequisites.get(i)[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
        
        Queue<Character> workingQueue = new LinkedList<>();
        // find the source
        for (Map.Entry<Character, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue()==0){
                workingQueue.add(entry.getKey());
            }
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        // while source is not null
        while (!workingQueue.isEmpty()) {
            Character character = workingQueue.poll();
            stringBuilder.append(character);
            List<Character> children = graph.get(character);
            for (Character child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    workingQueue.add(child);
                }
            }
        }

        // find cycle

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