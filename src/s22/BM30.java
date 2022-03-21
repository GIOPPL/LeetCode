package s22;

import meta.TreeNode;

/**
 * Created by GIOPPL
 * on 2022/3/20 21:10
 * TODO:
 */
public class BM30 {
    public static void main(String[] args) {

    }
    TreeNode pre= null;
    TreeNode root=null;
    public TreeNode Convert(TreeNode root) {
        if(root ==null) return null;
        Convert(root.left);
        if(this.root == null){
            this.root =root;
        }
        if(pre!=null){
            root.left=pre;
            pre.right=root;
        }
        pre=root;
        Convert(root.right);
        return this.root;
    }
}
