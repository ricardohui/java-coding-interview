package com.ricardohui.javaCodingInterview.twoheaps;

import java.util.*;

class MedianOfAStream {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianOfAStream() {
        maxHeap = new PriorityQueue<>((smaller,greater)-> greater - smaller);
        minHeap = new PriorityQueue<>((smaller,greater)-> smaller - greater);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }


        // rebalancing
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek()+ minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}