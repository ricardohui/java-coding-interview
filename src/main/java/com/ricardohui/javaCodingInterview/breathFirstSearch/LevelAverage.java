package com.ricardohui.javaCodingInterview.breathFirstSearch;

import java.util.*;


class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while (currentLevel.peek()!=null){
            int queueSize = currentLevel.size();
            double sum = 0;
            for (int i = 0; i < queueSize; i++) {
                root = currentLevel.poll();

                if (root.left != null) {
                    currentLevel.add(root.left);
                }

                if (root.right != null) {
                    currentLevel.add(root.right);
                }
                sum+=root.val;
            }
            result.add(sum/queueSize);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}