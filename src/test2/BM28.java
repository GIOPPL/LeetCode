package test2;

import meta.TreeNode;

public class BM28 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Object[]{1,"#",3,"#","#","#",5});
        TreeNode.showTree(treeNode);
        BM28 b=new BM28();
        int i = b.maxDepth(treeNode);
        System.out.println(i);
    }
    public int maxDepth (TreeNode root) {
        if (root==null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r=maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
