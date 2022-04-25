package test2;

import meta.TreeNode;

public class BM31 {
    public static void main(String[] args) {
        BM31 b=new BM31();
        TreeNode t=TreeNode.buildTree(new Object[]{1,1,1});
        TreeNode.showTree(t);
        System.out.println(b.isSymmetrical(t));
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null){
            return true;
        }
        return fun(pRoot.left,pRoot.right);
    }
    boolean fun (TreeNode lRoot,TreeNode rRoot){
        if (lRoot==null&&rRoot==null){
            return true;
        }else if ((lRoot!=null&&rRoot==null)){
            return false;
        }else if (lRoot == null){
            return false;
        }else if (lRoot.val!=rRoot.val){
            return false;
        }else {
            boolean l = fun(lRoot.left, rRoot.right);
            boolean r = fun(lRoot.right, rRoot.left);
            return l&&r;
        }
    }
}
