package com.ricardohui.javaCodingInterview.subset;

import java.util.*;



class UniqueTrees {

    public static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> rightSubtree = findUniqueTreesRecursive(i+1, end);
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
    public static List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0)
            return new ArrayList<TreeNode>();
        return findUniqueTreesRecursive(1, n);
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(3);
        System.out.print("Total trees: " + result.size());
    }
}