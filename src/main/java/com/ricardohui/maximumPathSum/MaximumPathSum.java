package com.ricardohui.maximumPathSum;


class MaximumPathSum {

    static int maxPathSum;
    public static int findMaximumPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }

        recursion(root);
        return maxPathSum;
    }

    public static int recursion(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        // recursion
        int leftSubtreeSum = Math.max(recursion(currentNode.left),0);
        int rightSubtreeSum = Math.max(recursion(currentNode.right),0);
        // formulate the max sum of this node if this is connecting node
        int value = leftSubtreeSum + rightSubtreeSum + currentNode.val;
        maxPathSum = Math.max(maxPathSum, value);

        //return Max of this node plus the val
        return Math.max(leftSubtreeSum, rightSubtreeSum) + currentNode.val;
    }

}