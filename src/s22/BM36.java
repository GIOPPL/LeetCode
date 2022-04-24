package s22;

import meta.TreeNode;

public class BM36 {
    public static void main(String[] args) {
        BM36 b=new BM36();
        TreeNode t=TreeNode.buildTree(new Object[]{1,2,3,4,"#",6,7,8});
        TreeNode.showTree(t);
        System.out.println(b.IsBalanced_Solution(t));
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        int l=deep(root.left);
        int r=deep(root.right);
        if (Math.abs(l-r)>1){
            return false;
        }
        return IsBalanced_Solution(root.left)&& IsBalanced_Solution(root.right);
    }

    private int deep(TreeNode root){
        if (root==null){
            return 0;
        }
        int l=deep(root.left);
        int r=deep(root.right);
        return Math.max(l,r)+1;
    }
}
