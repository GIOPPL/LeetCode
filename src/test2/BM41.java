package test2;

import meta.TreeNode;

import java.util.*;

public class BM41 {
    public static void main(String[] args) {
        int[] pre=new int[]{1,2,4,5,3};
        int[] in=new int[]{4,2,5,1,3};
        BM41 b=new BM41();
        TreeNode root = b.build(pre, in);
        TreeNode.showTree(root);
        int[] fun = b.fun(root);
        for (int i = 0; i < fun.length; i++) {
            System.out.print(fun[i]+"\t");
        }
    }
    private TreeNode build(int[] pre, int[] in){
        if(pre.length==0||in.length==0){
            return null;
        }
        TreeNode t=new TreeNode(pre[0]);
        int x=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                x=i;
                break;
            }
        }
        t.left=build(Arrays.copyOfRange(pre,1,x+1),Arrays.copyOfRange(in,0,x));
        t.right=build(Arrays.copyOfRange(pre,x+1,pre.length),Arrays.copyOfRange(in,x+1,in.length));
        return t;
    }
    private int[] fun(TreeNode root){
        if(root==null){
            return new int[]{};
        }
        Queue<TreeNode> queue=new LinkedList();
        List<Integer> mList=new ArrayList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode t=queue.poll();
                if (i==0){
                    mList.add(t.val);
                }
                System.out.print(t.val+"\t");
                if(t.right!=null){
                    queue.offer(t.right);
                }
                if(t.left!=null){
                    queue.offer(t.left);
                }
            }

        }
        return mList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
