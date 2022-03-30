package test2;

import meta.TreeNode;
import java.util.*;

public class BM27 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        TreeNode.showTree(treeNode);
        BM27 b = new BM27();
        ArrayList<ArrayList<Integer>> arrayLists = b.Print(treeNode);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list;
        if (root == null) {
            return lists;
        }
        //count为0时往左边走
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                list.add(p.val);

            }
            if (count % 2 == 1) {
                Collections.reverse(list);
            }
            count++;
            lists.add(list);
        }
        return lists;
    }
}
