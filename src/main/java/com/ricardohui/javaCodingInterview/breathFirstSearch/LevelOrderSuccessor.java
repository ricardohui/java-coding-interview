package com.ricardohui.javaCodingInterview.breathFirstSearch;

import java.util.*;


class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean shouldReturnNextOne = false;
        while (!queue.isEmpty()) {
            int sizeOfCurrentLevel = queue.size();
            for (int i = 0; i < sizeOfCurrentLevel; i++) {
                root = queue.poll();

                if (root.left != null) {
                    queue.offer(root.left);
                }

                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (shouldReturnNextOne) {
                    return root;
                }

                if (root.val == key){
                    shouldReturnNextOne = true;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}