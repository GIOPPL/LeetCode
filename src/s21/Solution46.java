package s21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/26 8:59
 * TODO:全排列
 */
public class Solution46 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution46 s = new Solution46();
        int[] n1 = new int[]{1, 2, 3, 4};
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
        epoch(nums);
        return ans;
    }

    private void epoch(int[] nums) {
        if (list.size() == n) {
            //当列表数量和列表程度相等时候，就是答案
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!visit[j]) {
                //设置为已查看
                visit[j] = true;
                //添加到列表中
                list.add(nums[j]);
                //递归搜索
                epoch(nums);
                //回溯，返回递归前的样子
                list.removeLast();
                visit[j] = false;
            }
        }
    }
}
