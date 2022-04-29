package com.ricardohui.javaCodingInterview.miscellanous;

import java.util.*;



class SumOfPathNumbers {

    private static int recursion(TreeNode root, List<Integer> currentPath, int sum){
        // base case
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> newCurrentPath = new ArrayList<>();
        newCurrentPath.addAll(currentPath);
        newCurrentPath.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder concat = new StringBuilder();
            for (int i = 0; i < newCurrentPath.size(); i++) {
                concat.append(newCurrentPath.get(i));
            }
            return Integer.parseInt(concat.toString());
        }

        //recursion
        return recursion(root.left,     newCurrentPath, sum)+recursion(root.right, newCurrentPath, sum);

    }
    public static int findSumOfPathNumbers(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
//        currentPath.add(root.val);
        return recursion(root, currentPath, 0);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}