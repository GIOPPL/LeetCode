package s22;

import meta.TreeNode;

/**
 * Created by GIOPPL
 * on 2022/3/21 22:53
 * TODO:
 */
public class BM32 {
    public static void main(String[] args) {
        TreeNode t1=TreeNode.buildTree(new Object[]{9,"#",9,7,"#",9,2});
        TreeNode t2=TreeNode.buildTree(new Object[]{10,1,2,9,6,"#",1,8,"#",9,"#","#",3,3});
        TreeNode.showTree(t1);
        TreeNode.showTree(t2);
        BM32 b=new BM32();
        TreeNode node = b.mergeTrees(t1, t2);
        TreeNode.showTree(node);
    }

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1!=null&&t2!=null){
            t1.val+= t2.val;
        }
        if (t1==null&&t2!=null){
            return t2;
        }
        fun(t1, t2);
        return t1;
    }

    private void fun(TreeNode t1,TreeNode t2){
        if (t1==null&&t2==null){
            return ;
        }else if(t1 == null){
            return ;
        }else if (t2==null){
            return ;
        }
        if (t1.left!=null){
            if (t2.left!=null){
                t1.left.val+=t2.left.val;
            }
        }else {
            if (t2.left!=null){
                t1.left=t2.left;
            }
        }
        if (t1.right!=null){
            if (t2.right!=null){
                t1.right.val+=t2.right.val;
            }
        }else {
            if (t2.right!=null){
                t1.right=t2.right;
            }
        }
        fun(t1.left,t2.left);
        fun(t1.right,t2.right);
    }
}
