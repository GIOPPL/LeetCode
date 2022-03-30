package test2;

import meta.TreeNode;

public class BM34 {
    public static void main(String[] args) {
        BM34 b = new BM34();
//        TreeNode t=TreeNode.buildTree(new Object[]{3,2,5,1,4});
        TreeNode t = TreeNode.buildTree(new Object[]{2, 1, 3});
        TreeNode.showTree(t);
        System.out.println(b.isValidBST(t));
    }

    public boolean isValidBST(TreeNode t) {
        boolean l = fun(t.left, t.val);
        boolean r = fun(t.right, t.val);
        return l && r;
    }

    private boolean fun(TreeNode root, int par) {
        if (root == null) {
            return true;
        }
        int l = root.left == null ? Integer.MIN_VALUE : root.left.val;
        int r = root.right == null ? Integer.MAX_VALUE : root.right.val;
        if (root.val < l || root.val > r || par > l || par < r) {
            return false;
        }
        boolean left = fun(root.left, root.val);
        boolean right = fun(root.right, root.val);
        return left && right;
    }
}
