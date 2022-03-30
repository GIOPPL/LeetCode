package test2;

import meta.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BM26 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Object[]{1,2,3,4,"#","#",5});
        TreeNode.showTree(treeNode);
        BM26 b=new BM26();
        ArrayList<ArrayList<Integer>> arrayLists = b.levelOrder(treeNode);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list;
        if(root==null){
            return lists;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        Queue<TreeNode> q2=new LinkedList<>();
        while (!queue.isEmpty()){
            list=new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode p = queue.poll();
                q2.offer(p);
                list.add(p.val);
            }
            lists.add(list);
            while (!q2.isEmpty()){
                TreeNode p = q2.poll();
                if (p.left!=null){
                    queue.offer(p.left);
                }
                if (p.right!=null){
                    queue.offer(p.right);
                }
            }
        }
        return lists;
    }
}
