package com.ricardohui.javaCodingInterview.miscellanous;

class PathWithGivenSequence {

    private static boolean recursion(TreeNode root, int[] sequence, int index){

        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null) {
            return sequence[index] == root.val;
        }else{
            if (sequence[index]!= root.val){
                return false;
            }
        }



        return recursion(root.left, sequence, index+1) || recursion(root.right, sequence, index+1);
    }
    public static boolean findPath(TreeNode root, int[] sequence) {

        return recursion(root, sequence, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}