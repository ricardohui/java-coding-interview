
class TreeNodeMaximunPathSum {
    int val;
    TreeNodeMaximunPathSum left;
    TreeNodeMaximunPathSum right;

    TreeNodeMaximunPathSum(int x) {
        val = x;
    }
}

class TreePathSum {
    public static boolean hasPath(TreeNodeMaximunPathSum root, int sum) {
        int sumAfterCurrentNode = sum - root.val;
        if(sumAfterCurrentNode == 0) return true;
        boolean eitherOneTrue = false;
        if (root.left != null && sumAfterCurrentNode > 0) {
            eitherOneTrue = eitherOneTrue || hasPath(root.left, sumAfterCurrentNode);
        }

        if (root.right != null && sumAfterCurrentNode > 0) {
           eitherOneTrue = eitherOneTrue || hasPath(root.right, sumAfterCurrentNode);
        }

        return eitherOneTrue;
    }

    public static void main(String[] args) {
        TreeNodeMaximunPathSum root = new TreeNodeMaximunPathSum(12);
        root.left = new TreeNodeMaximunPathSum(7);
        root.right = new TreeNodeMaximunPathSum(1);
        root.left.left = new TreeNodeMaximunPathSum(9);
        root.right.left = new TreeNodeMaximunPathSum(10);
        root.right.right = new TreeNodeMaximunPathSum(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}