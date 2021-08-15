import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/7/26 8:59
 * TODO:
 */
public class Solution46_2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution46_2 s = new Solution46_2();
        int[] n1 = new int[]{1, 2, 3};
        List<List<Integer>> permute = s.permute(n1);
        System.out.println(permute.toString());
    }

    private boolean[] visit = null;
    private int n = 0;
    private List<List<Integer>> ans;
    private LinkedList<Integer> list;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        list = new LinkedList<>();
        n = nums.length;
        visit = new boolean[n];
        epoch(nums,0);
        return ans;
    }

    private void epoch(int[] nums,int level) {
        if(level==n-1){
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            list=new LinkedList<>();
            return;
        }
        for (int i = level; i < n; i++) {
            swap(nums,i,level);
            epoch(nums,level+1);
            swap(nums,i,level);
        }
    }
    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
