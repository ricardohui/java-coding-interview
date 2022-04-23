package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class FrequentNumber {
    int seq;
    int frequency;

    public FrequentNumber(int seq, int frequency) {
        this.seq = seq;
        this.frequency = frequency;
    }
}
class FrequencyStack {

    static int seq = 0;
    Map<Integer, FrequentNumber> characterFrequencyMap = new HashMap<>();
    Queue<Integer> maxHeap = new PriorityQueue((c1, c2)-> {
        int difference = characterFrequencyMap.get(c2).frequency - characterFrequencyMap.get(c1).frequency;
        if (difference == 0) {
            return  characterFrequencyMap.get(c2).seq - characterFrequencyMap.get(c1).seq;
        }
        return difference;
    });

    public void push(int num) {
        int newFrequency;
        if (!characterFrequencyMap.containsKey(num)){
            newFrequency = 1;
        }else{
            newFrequency = characterFrequencyMap.get(num).frequency+1;
        }
        FrequentNumber frequentNumber = new FrequentNumber(seq++, newFrequency);
        characterFrequencyMap.put(num, frequentNumber);
        maxHeap.clear();
        maxHeap.addAll(characterFrequencyMap.keySet());
    }

    public int pop() {
        if (maxHeap.isEmpty()) {
            return -1;
        }
        int num = maxHeap.poll();
        int newFrequency = characterFrequencyMap.get(num).frequency;
        FrequentNumber frequentNumber = new FrequentNumber(characterFrequencyMap.get(num).seq, newFrequency -1);
        characterFrequencyMap.put(num,  frequentNumber);
        if (characterFrequencyMap.get(num).frequency <= 0) {
            characterFrequencyMap.remove(num);
        }else{
            maxHeap.add(num);
        }
        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}