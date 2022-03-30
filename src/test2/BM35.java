package test2;

import meta.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BM35 {
    public static void main(String[] args) {
        BM35 b = new BM35();
        TreeNode t = TreeNode.buildTree(new Object[]{3, 1, 7, "#", "#", 6, 8});
//        TreeNode t=TreeNode.buildTree(new Object[]{1,2,3,4,5,6,7});
        TreeNode.showTree(t);
        System.out.println(b.isCompleteTree(t));
        System.out.println(b.isCompleteTree2(t));
    }

    public boolean isCompleteTree(TreeNode tree) {
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        boolean left = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            if ((null != rightChild && null == leftChild)
                    ||
                    (left && (null !=  rightChild|| null != leftChild))) {
                return false;
            }
            if (null!=leftChild) {
                queue.offer(leftChild);
            }
            if (null!=rightChild) {
                queue.offer(rightChild);
            } else {
                left=true;
            }
        }
        return true;
    }

    public boolean isCompleteTree2(TreeNode tree) {
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        boolean left = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            if ((null != rightChild && null == leftChild) //右孩子不等于空，左孩子等于空  -> false
                    ||
                    (left && (null != rightChild || null != leftChild)) //开启叶节点判断标志位时，如果层次遍历中的后继结点不是叶节点 -> false
            ) {
                return false;
            }
            if (null != leftChild) {
                queue.offer(leftChild);
            }
            if (null != rightChild) {
                queue.offer(rightChild);
            } else {
                left = true;
            }
        }

        return true;
    }
}
