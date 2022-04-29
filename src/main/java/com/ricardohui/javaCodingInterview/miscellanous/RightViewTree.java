package com.ricardohui.javaCodingInterview.miscellanous;

import java.util.*;

;

class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while (!level.isEmpty()) {
            int currentLevelSize = level.size();

            for (int i = 0; i < currentLevelSize; i++) {
                root = level.poll();

                if (root.left != null) {
                    level.offer(root.left);
                }

                if (root.right != null) {
                    level.offer(root.right);
                }
            }
            result.add(root);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
