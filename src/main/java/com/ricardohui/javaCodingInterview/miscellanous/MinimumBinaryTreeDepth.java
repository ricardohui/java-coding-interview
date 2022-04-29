package com.ricardohui.javaCodingInterview.miscellanous;


import java.util.*;



class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 0;
        int minDepth = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            currentDepth++;
            for (int i = 0; i < currentLevelSize; i++) {
                root = queue.poll();
                System.out.println(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }

                if (root.right != null) {
                    queue.offer(root.right);
                }

                if (root.left == null && root.right == null) {
                    minDepth = Math.min(minDepth, currentDepth);
                }
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}