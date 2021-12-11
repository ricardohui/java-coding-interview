package com.ricardohui.javaCodingInterview.subset;

import java.util.*;

class GenerateParentheses {

    private static void recursion(int num,  int index, List<String> result, String currentPath) {
        if (num == index) {
            result.add(currentPath);
            return;
        }

//        for (int i = 0; i < currentPath.length(); i++) {
            recursion(num, index+1, result, '('+currentPath+')');
            recursion(num, index+1, result, currentPath+ "()");
            if(index>=2){
                recursion(num, index+1, result, "()"+currentPath);
            }
//        }


    }

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        recursion(num, 1, result, "()");
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}