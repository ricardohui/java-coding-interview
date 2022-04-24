package com.ricardohui.javaCodingInterview.breathFirstSearch;


import java.util.*;

class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {

        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);

        while (!currentLevel.isEmpty()) {
            int currentLevelSize = currentLevel.size();

            for (int i = 0; i < currentLevelSize; i++) {
                root = currentLevel.poll();

                if (root.left != null) {
                    currentLevel.add(root.left);
                }

                if (root.right != null) {
                    currentLevel.add(root.right);
                }

                if(currentLevel.peek()!=null && i!=currentLevelSize-1){
                    root.next = currentLevel.peek();
                }else{
                    root.next = null;
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}