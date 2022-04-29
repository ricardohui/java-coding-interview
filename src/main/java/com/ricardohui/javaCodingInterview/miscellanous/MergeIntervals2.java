package com.ricardohui.javaCodingInterview.miscellanous;


import java.util.*;


class MergeIntervals2 {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> mergedIntervals = new LinkedList<>();
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval past = intervalItr.next();
        Interval current;
        while (intervalItr.hasNext()) {
            current = intervalItr.next();
            if (past.end > current.start) {
                past.end = Math.max(past.end, current.end);

            }else{
                mergedIntervals.add(past);
                past = current;
            }
        }

        if (mergedIntervals.size()>0) {
            Interval lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (lastInterval.end > past.start) {
                lastInterval.end = Math.max(past.end, lastInterval.end);
            }
        }
        mergedIntervals.add(past);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals2.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals2.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals2.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}