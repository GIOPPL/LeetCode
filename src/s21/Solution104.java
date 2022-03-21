package s21;

import meta.TreeNode;

/**
 * Created by GIOPPL
 * on 2021/6/27 14:59
 * TODO:求二叉树的最大深度
 */
public class Solution104 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution104 solution104=new Solution104();
        Object[] list=new Object[]{3,9,20,null,null,15,7};
        System.out.println(solution104.maxDepth(TreeNode.buildTree(list)));
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return deep(root,1);
    }
    private int deep(TreeNode root,int d){
        if(root==null){
            return d-1;
        }
        if(root.left==null&&root.right==null){
            return d;
        }
        int l=deep(root.left,d+1);
        int r=deep(root.right,d+1);
        return l>r?l:r;

    }
}
