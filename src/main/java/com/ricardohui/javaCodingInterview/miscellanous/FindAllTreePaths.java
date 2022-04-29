package com.ricardohui.javaCodingInterview.miscellanous;

import java.util.*;

class FindAllTreePaths {

    private static void findPaths(TreeNode root, int sum, List<Integer> onePath, List<List<Integer>> allPath){
        int currentValueAfterRootVal = sum - root.val;

        if (root.left == null && root.right==null) {
            if(currentValueAfterRootVal==0) {
                onePath.add(root.val);
                allPath.add(onePath);
            }
            return;
        }
        List<Integer> newOnePath = new ArrayList<>();
        newOnePath.addAll(onePath);
        newOnePath.add(root.val);

        if(root.left!=null){
            findPaths(root.left, currentValueAfterRootVal, newOnePath, allPath);
        }
        if(root.right!=null){
            findPaths(root.right, currentValueAfterRootVal, newOnePath, allPath);
        }
    }
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        ArrayList<Integer> onePath = new ArrayList();
        onePath.add(root.val);
        findPaths(root.left, sum - root.val, onePath, allPaths);
        findPaths(root.right, sum - root.val, onePath, allPaths);
        return allPaths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}