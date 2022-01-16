package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class FrequentNumber {
    int seq;
    int value;
    int frequency

    public FrequentNumber(int value, int seq, int frequency) {
        this.seq = seq;
        this.value = value;
        this.frequency = frequency;
    }
}

class ElementCompartor implements Comparator<FrequentNumber> {
    @Override
    public int compare(com.ricardohui.javaCodingInterview.KthElement.FrequentNumber o1,
                       com.ricardohui.javaCodingInterview.KthElement.FrequentNumber o2) {
        if (o2.frequency !=  o1.frequency) {
            return o2.frequency -o1.frequency;
        }

        return o2.seq - o1.seq;
    }
}


class FrequencyStack {
    int seq =  0
    Map<Integer, Integer> characterFrequencyMap = new HashMap<>();
    Queue<FrequentNumber> maxHeap = new PriorityQueue(new ElementCompartor());

    public void push(int num) {
        characterFrequencyMap.put(num, characterFrequencyMap.get(num, 0) + 1);
        maxHeap.add(new FrequentNumber(num, seq++, characterFrequencyMap.get(num)));
    }

    public int pop() {
        if (maxHeap.isEmpty()) return -1;
        FrequentNumber frequentNumber = maxHeap.poll();
        int num = frequentNumber.value;
        if (characterFrequencyMap.get(num) > 1) {
            characterFrequencyMap.put(num, characterFrequencyMap.get(num) - 1);
        }else{
            characterFrequencyMap.remove(num);
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