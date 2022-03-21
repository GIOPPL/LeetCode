package s21;

import meta.TreeNode;

import java.util.Stack;

/**
 * Created by GIOPPL
 * on 2021/6/26 9:14
 * TODO:给定一个二叉树，检查它是否是镜像对称的。
 *  思路：先序遍历。设置两个栈空间，第一个是正常先序遍历，第二个是从右开始的先序遍历，循环比较，如果元素不相同，返回false
 */
public class Solution101 {

    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        Solution101 solution101=new Solution101();
        Object[] list=new Object[]{1,2,2,3,4,4,3};
        TreeNode root = TreeNode.buildTree(list);
        TreeNode.showTree(root);
        System.out.println(solution101.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        //设置两个栈空间
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        //将根节点加入到栈中
        stack1.push(root);
        stack2.push(root);
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            //弹出一个节点
            TreeNode node1=stack1.pop();
            TreeNode node2=stack2.pop();
            //节点可能为空，因为防止子树左右半对称，也就是防止以下情况出现
            /**
             *     1
             *    / \
             *   2   2
             *    \   \
             *    3    3
             */
            if (node1==null&&node2==null){
                continue;
            }
            //如果只有一个为空,那么则返回false
            if (node1==null||node2==null){
                return false;
            }
            //不相等返回false
            if (node1.val!=node2.val){
                return false;
            }
            //从下面开始就是为了添加节点
            //先为第一个栈添加节点,先加左再加右，空的也要加
            stack1.push(node1.left);
            stack1.push(node1.right);
            //第二个栈添加节点，先加右在加左，空的也要加
            stack2.push(node2.right);
            stack2.push(node2.left);
        }
        return true;
    }


}
