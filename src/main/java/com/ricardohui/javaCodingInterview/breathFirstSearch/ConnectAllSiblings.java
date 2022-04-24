package com.ricardohui.javaCodingInterview.breathFirstSearch;


import java.util.*;


class ConnectAllSiblings {
    public static void connect(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                root = queue.poll();

                if (root.left != null) {
                    queue.offer(root.left);
                }

                if (root.right != null) {
                    queue.offer(root.right);
                }

                root.next = queue.peek();

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
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}