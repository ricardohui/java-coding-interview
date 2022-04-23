package com.ricardohui.javaCodingInterview.subset;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class CountUniqueTrees {
    public int countTrees(int n) {

        List<TreeNode> result = countTreesRecursive(1, n);


        return result.size();
    }

    private List<TreeNode> countTreesRecursive(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }


        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = countTreesRecursive(start, i - 1);
            List<TreeNode> rightSubtree = countTreesRecursive(i + 1, end);

            for (TreeNode leftNode : leftSubtree) {
                for (TreeNode rightNode : rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }

        }

            return result;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}