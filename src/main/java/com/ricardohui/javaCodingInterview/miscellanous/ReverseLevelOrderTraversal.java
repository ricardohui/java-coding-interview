import java.util.*;

class TreeNode {
    int val;
    TreeNodeMaximunPathSum left;
    TreeNodeMaximunPathSum right;

    TreeNode(int x) {
        val = x;
    }
};

class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNodeMaximunPathSum root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNodeMaximunPathSum> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNodeMaximunPathSum currentNode = queue.poll();

                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNodeMaximunPathSum root = new TreeNodeMaximunPathSum(12);
        root.left = new TreeNodeMaximunPathSum(7);
        root.right = new TreeNodeMaximunPathSum(1);
        root.left.left = new TreeNodeMaximunPathSum(9);
        root.right.left = new TreeNodeMaximunPathSum(10);
        root.right.right = new TreeNodeMaximunPathSum(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}