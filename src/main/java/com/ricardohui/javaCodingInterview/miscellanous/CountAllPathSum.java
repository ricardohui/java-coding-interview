package com.ricardohui.javaCodingInterview.miscellanous;

import java.util.*;



class CountAllPathSum {

    private static int checkEqualSum(List<TreeNode> path, int S) {
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start <= end && end < path.size()) {
            System.out.println(path.get(end).val);
            sum += path.get(end).val;
            if(sum==S) return 1;

            if (sum > S) {
                sum -= path.get(start).val;
                start++;

            }
                // sum < S
                end++;

        }

        System.out.println("--------------");
        return 0;
    }

    private static int recursion(TreeNode root, int S, List<TreeNode> currentPath) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> newPath = new ArrayList<>();
        newPath.addAll(currentPath);
        newPath.add(root);

        if (root.left == null && root.right == null) {
            // leaf node
            return checkEqualSum(newPath, S);
        }

        return recursion(root.left, S, newPath) + recursion(root.right, S, newPath);
    }

    public static int countPaths(TreeNode root, int S) {
        ArrayList<TreeNode> list = new ArrayList<>();
        return recursion(root, S, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}