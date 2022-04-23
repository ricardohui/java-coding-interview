package com.ricardohui.javaCodingInterview.mergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i  = 0, j = 0;
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].end > arr2[j].start) {
                start = Math.min(Math.min(arr1[i].start, arr2[j].start), start);
                end = Math.max(Math.max(arr1[i].end, arr2[j].end), end);
                j++;
            }else{
                if (start != Integer.MAX_VALUE || end != Integer.MIN_VALUE) {
                    intervalsIntersection.add(new Interval(start, end));
                    start = Integer.MAX_VALUE;
                    end = Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}