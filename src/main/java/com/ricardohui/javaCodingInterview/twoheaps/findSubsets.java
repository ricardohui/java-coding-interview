package com.ricardohui.javaCodingInterview.twoheaps;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<>();
        subsets.add(emptySet);
        for (int n = 0; n < nums.length; n++) {
            int number = nums[n];
            int i = 0;
            int initalSize = subsets.size();
            while (i < initalSize) {
                List<Integer> existingSet = new ArrayList<>(subsets.get(i));
                existingSet.add(number);
                subsets.add(existingSet);
                i++;
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }

}
