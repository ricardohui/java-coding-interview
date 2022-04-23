package com.ricardohui.javaCodingInterview.breathFirstSearch;

import java.util.*;
import java.util.stream.Collectors;



class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            List<Integer> array = currentLevel.stream().map(value -> value.val).collect(Collectors.toList());
            result.add(array);

            Queue<TreeNode> nextLevel = new ArrayDeque<>();

            while (currentLevel.peek() != null) {

                root = currentLevel.poll();
                if (root.left != null) {
                    nextLevel.add(root.left);
                }

                if (root.right != null) {
                    nextLevel.add(root.right);
                }
            }

            currentLevel = nextLevel;

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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}