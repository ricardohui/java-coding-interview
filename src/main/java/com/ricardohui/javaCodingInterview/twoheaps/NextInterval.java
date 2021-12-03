package com.ricardohui.javaCodingInterview.twoheaps;

import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {

    public static int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        // heap for finding the max start
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(
                (o1, o2) -> intervals[o2].start - intervals[o1].start);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>((o1, o2) -> intervals[o2].end - intervals[o1].end);
        for (int i = 0; i < intervals.length; i++) {
            maxEndHeap.offer(i);
            maxStartHeap.offer(i);
        }

        for (int i = 0; i < n; i++) {
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;

            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end ){
                int topStart = maxStartHeap.poll();

                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
            }



        }


        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}