package s22;

import meta.TreeNode;

/**
 * Created by GIOPPL
 * on 2022/3/20 20:45
 * TODO:
 */
public class BM29 {
    public static void main(String[] args) {
//        TreeNode root=TreeNode.buildTree(new Object[]{5,4,8,1,11,"#",9,"#","#",2,7});
        TreeNode root=TreeNode.buildTree(new Object[]{1,-2,-3,1,3,-2,"#",-1});
        TreeNode.showTree(root);
        BM29 b=new BM29();
        System.out.println(b.hasPathSum(root, -1));
    }
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root==null&&sum==0){
            return false;
        }
        return fun(root,sum,0);
    }
    public boolean fun (TreeNode root, int total,int count) {
        if (root!=null&&root.left==null&&root.right==null&&total==(count+ root.val)){
            return true;
        }else if (root==null){
            return false;
        }else {
            boolean l = fun(root.left, total, count + root.val);
            boolean r = fun(root.right, total, count + root.val);
            return l||r;
        }
    }
}
