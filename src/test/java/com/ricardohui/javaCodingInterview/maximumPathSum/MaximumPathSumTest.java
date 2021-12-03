package com.ricardohui.javaCodingInterview.maximumPathSum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximumPathSumTest {

    @Test
    void canHandleNullNode(){
        assertEquals(0, MaximumPathSum.findMaximumPathSum(null));
    }

    @Test
    void shouldEqual6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals( 6, MaximumPathSum.findMaximumPathSum(root));
    }

    @Test
    void shouldEqual31(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        assertEquals( 31, MaximumPathSum.findMaximumPathSum(root));
    }

    @Test
    void shouldEqualNeg4(){
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        assertEquals( -1, MaximumPathSum.findMaximumPathSum(root));
    }

    @Test
    void shouldEqualNeg4WithRightSubtree(){
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        root.right   = new TreeNode(0);
        assertEquals( 0, MaximumPathSum.findMaximumPathSum(root));
    }


    @Test
    void handleNullRecursion(){

        assertEquals(0, MaximumPathSum.recursion(null));
    }
}