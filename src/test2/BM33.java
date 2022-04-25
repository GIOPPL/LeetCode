package test2;

import meta.TreeNode;

public class BM33 {
    public static void main(String[] args) {
        BM33 b=new BM33();
        TreeNode t=TreeNode.buildTree(new Object[]{8,"#",7,"#",6,"#",5,"#",4});
//        TreeNode t=TreeNode.buildTree(new Object[]{8,7,"#",6,"#",5,"#",4});
        TreeNode.showTree(t);
        TreeNode mirror = b.Mirror(t);
        TreeNode.showTree(mirror);
    }
    public TreeNode Mirror (TreeNode root) {
        fun(root);
        return root;
    }

    private void fun(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return ;
        }
        if(root.right==null){
            root.right=root.left;
            root.left=null;
        }else if(root.left==null){
            root.left=root.right;
            root.right=null;
        }else{
            TreeNode t=root.left;
            root.left=root.right;
            root.right=t;
        }
        fun(root.left);
        fun(root.right);
    }
}
