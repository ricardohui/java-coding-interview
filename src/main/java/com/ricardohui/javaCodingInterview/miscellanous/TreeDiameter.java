package com.ricardohui.javaCodingInterview.miscellanous;



class TreeDiameter {

    private static int maxTreeDiameter = 0;
    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return maxTreeDiameter;
    }

    private static int calculateHeight(TreeNode currentNode) {
        //handle leaf node
        if (currentNode == null) {
            return 0;
        }
        // recursion
        int leftSubtreeHeight = calculateHeight(currentNode.left);
        int rightSubtreeHeight = calculateHeight(currentNode.right);


        // handle connecting path
        if (currentNode.left != null && currentNode.right != null) {
            int currentTreeDiamter = leftSubtreeHeight + rightSubtreeHeight + 1;
            maxTreeDiameter = Math.max(maxTreeDiameter, currentTreeDiamter);
        }

        // return HeightFromTheChildren + 1
        return Math.max(leftSubtreeHeight,rightSubtreeHeight) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
