package s21;

import meta.TreeNode;

/**
 * Created by GIOPPL
 * on 2021/6/26 21:57
 * TODO:判断两棵树是否是一样的结构一样的值
 */
public class Solution100 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Object[] a=new Object[]{1,2,2,null,5,6,7};
        Object[] b=new Object[]{1,2,2,null,5,6,7};
        Solution100 solution100=new Solution100();
        System.out.println(solution100.isSameTree(TreeNode.buildTree(a),TreeNode.buildTree(b)));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null||p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}
