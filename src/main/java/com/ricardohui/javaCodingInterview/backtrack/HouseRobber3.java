package com.ricardohui.javaCodingInterview.backtrack;
// TreeNode class to represent each house
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  
  TreeNode(int val) {
      this.val = val;
  }
}

// Pair class to store rob and not_rob values for each node
class Pair {
  int rob;    // Maximum money if we rob this house
  int notRob; // Maximum money if we don't rob this house
  
  Pair(int rob, int notRob) {
      this.rob = rob;
      this.notRob = notRob;
  }
}

public class HouseRobber3 {
  // Main method with test cases
  public static void main(String[] args) {
      HouseRobber3 solution = new HouseRobber3();
      
      // Test Case 1: Simple tree
      TreeNode root1 = new TreeNode(3);
      root1.left = new TreeNode(2);
      root1.right = new TreeNode(3);
      root1.left.right = new TreeNode(3);
      root1.right.right = new TreeNode(1);
      
      System.out.println("Test Case 1:");
      System.out.println("Expected: 7");
      System.out.println("Result: " + solution.rob(root1));
      System.out.println();
      
      // Test Case 2: Another example
      TreeNode root2 = new TreeNode(3);
      root2.left = new TreeNode(4);
      root2.right = new TreeNode(5);
      root2.left.left = new TreeNode(1);
      root2.left.right = new TreeNode(3);
      root2.right.right = new TreeNode(1);
      
      System.out.println("Test Case 2:");
      System.out.println("Expected: 9");
      System.out.println("Result: " + solution.rob(root2));
      System.out.println();
      
      // Test Case 3: Single node
      TreeNode root3 = new TreeNode(1);
      
      System.out.println("Test Case 3:");
      System.out.println("Expected: 1");
      System.out.println("Result: " + solution.rob(root3));
      System.out.println();
      
      // Test Case 4: Empty tree
      System.out.println("Test Case 4 (Empty tree):");
      System.out.println("Expected: 0");
      System.out.println("Result: " + solution.rob(null));
      System.out.println();
      
      // Test Case 5: Linear tree
      TreeNode root5 = new TreeNode(4);
      root5.right = new TreeNode(1);
      root5.right.right = new TreeNode(2);
      root5.right.right.right = new TreeNode(3);
      
      System.out.println("Test Case 5 (Linear tree):");
      System.out.println("Expected: 7");
      System.out.println("Result: " + solution.rob(root5));
  }
  
  // Main method to start the robbery calculation
  public int rob(TreeNode root) {
      Pair result = robHelper(root);
      return Math.max(result.rob, result.notRob);
  }
  
  // Helper method that returns a Pair containing maximum money with and without robbing current house
  private Pair robHelper(TreeNode node) {
      // Base case: if node is null, return 0 for both rob and not_rob
      if (node == null) {
          return new Pair(0, 0);
      }
      
      // Recursively calculate values for left and right subtrees
      Pair left = robHelper(node.left);
      Pair right = robHelper(node.right);
      
      // If we rob this house, we can't rob its children
      int robThis = node.val + left.notRob + right.notRob;
      
      // If we don't rob this house, we can choose the maximum possible value from each child
      int notRobThis = Math.max(left.rob, left.notRob) + Math.max(right.rob, right.notRob);
      
      return new Pair(robThis, notRobThis);
  }
}