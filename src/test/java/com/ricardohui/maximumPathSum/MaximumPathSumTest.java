package com.ricardohui.maximumPathSum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximumPathSumTest {

    @Test
    void shouldEqual6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals( 6, MaximumPathSum.findMaximumPathSum(root));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
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
        assertEquals( -4, MaximumPathSum.findMaximumPathSum(root));
    }
}