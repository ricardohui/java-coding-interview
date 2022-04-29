package com.ricardohui.javaCodingInterview.miscellanous;

import java.util.ArrayList;

class Pair {
    public int first;
    public int second;

    public Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

class MergeIntervals {
    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {

        if (v.size() < 2) {
            return v;
        }

        ArrayList<Pair> result = new ArrayList<>();
        // FIXME: immutable is important here to avoid accidental side effect
        Pair lastPair = v.get(0);

        result.add(lastPair);
        for (int i = 1; i < v.size(); i++) {
            Pair currentPair = v.get(i);
            if (lastPair.second >= currentPair.first) {
                lastPair.second = currentPair.second;
            } else {
                result.add(currentPair);
                lastPair = currentPair;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        ArrayList<Pair> result = mergeIntervals(v);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }
}