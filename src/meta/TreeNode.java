package meta;

import meta.utils.TreeOperation;

/**
 * Created by GIOPPL
 * on 2021/6/26 8:58
 * TODO:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode buildTree(Object[] list){
        Object[] newList=new Object[list.length+1];
        newList[0]=-1;
        System.arraycopy(list, 0, newList, 1, list.length);
        return build(newList,1);
    }
    private static TreeNode build(Object[] list,int position){
        if (position>list.length-1||list[position]==null||list[position]=="#"){
            return null;
        }
        TreeNode t=new TreeNode();
        t.val= (int) list[position];
        t.left=build(list,position*2);
        t.right=build(list,position*2+1);
        return t;
    }
    public static void showTree(TreeNode node){
        TreeOperation.show(node);
    }



    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
