package com.ricardohui.javaCodingInterview.dp;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CombinationSum {


    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Set<Integer>>> result = new ArrayList<>();
        result.add(Arrays.asList());
        for (int i = 1; i <= target; i++) {
          List<Set<Integer>> legs = new ArrayList<>();
          for (int num : nums) {
            if(i == num){
              Set<Integer> set = new HashSet<>();
              set.add(num);
              legs.add(set);
            }

            if (i > num) {
              List<Set<Integer>> combinations = result.get(i - num);
              for (Set<Integer> combination : combinations) {
                Set<Integer> newCombination = new HashSet<>();
                newCombination.addAll(combination);
                newCombination.add(num);
                legs.add(newCombination);
              }
            }
          }
          result.add(legs);
        }
        
        List<Set<Integer>> setList = result.get(target);
        List<List<Integer>> resultList = new ArrayList<>();

        for (Set<Integer> list : setList) {
          List<Integer> array = new ArrayList<>();

          for(Integer num: list){
            array.add(num);
          }
          resultList.add(array);
        }
        return resultList;
    }

    

    public static void main(String[] args) {
        // Unit tests
        testCombinationSum1();
        testCombinationSum2();
        testCombinationSum3();

        // Example usage
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    private static void testCombinationSum1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        );
        List<List<Integer>> result = combinationSum(candidates, target);
        assertEquals(expected, result);
    }

    private static void testCombinationSum2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        );
        List<List<Integer>> result = combinationSum(candidates, target);
        assertEquals(expected, result);
    }

    private static void testCombinationSum3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = combinationSum(candidates, target);
        assertEquals(expected, result);
    }

    private static void assertEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("Expected " + expected + ", but got " + actual);
        }

        for (int i = 0; i < expected.size(); i++) {
            List<Integer> expectedList = expected.get(i);
            List<Integer> actualList = actual.get(i);
            if (!expectedList.equals(actualList)) {
                throw new AssertionError("Expected " + expected + ", but got " + actual);
            }
        }
    }
}