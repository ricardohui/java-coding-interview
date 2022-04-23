package com.ricardohui.javaCodingInterview.breathFirstSearch;

import java.util.*;



class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> nextLevel = new LinkedList<>();
        nextLevel.offer(root);
        boolean isReversed = false;

        while (!nextLevel.isEmpty()) {
            int levelSize = nextLevel.size();
            List<Integer>  currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                root = nextLevel.poll();

                if (isReversed){
                    currentLevel.add(0,root.val);
                }else{
                    currentLevel.add(root.val);
                }

                if (root.left != null) {
                    nextLevel.offer(root.left);
                }

                if (root.right != null) {
                    nextLevel.offer(root.right);
                }

            }
            isReversed = !isReversed;
            result.add(currentLevel);

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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}