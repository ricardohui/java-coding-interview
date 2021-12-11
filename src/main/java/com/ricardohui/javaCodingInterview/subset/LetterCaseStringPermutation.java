package com.ricardohui.javaCodingInterview.subset;

import java.util.*;
import java.util.regex.Pattern;

class LetterCaseStringPermutation {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(Character strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum.toString()).matches();
    }

    private static void recursion(String str, String path, List<String> permutations, int index){
        if (index == str.length()) {
            permutations.add(path);
            return;
        }else{
            if (isNumeric(str.charAt(index))){
                recursion(str, path + str.charAt(index), permutations, index+1);
            }else{
                char c = str.charAt(index);
                recursion(str, path + Character.toString(c).toUpperCase(), permutations, index+1);
                recursion(str, path + c, permutations, index+1);

            }

        }
    }
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        recursion(str, "", permutations, 0);
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}