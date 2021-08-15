import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/30 10:05
 * TODO:
 */
public class Solution77 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution77 s = new Solution77();
        List<List<Integer>> combine = s.combine(5, 4);
        System.out.println(combine);
    }

    private List<List<Integer>> ans;
    private LinkedList<Integer> list;
    private boolean[] v = null;

    public List<List<Integer>> combine(int n, int k) {
        //构造数组
        int[] nums = new int[n];
        //给数组赋值
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        ans = new ArrayList<>();
        list = new LinkedList<>();
        v = new boolean[n];
        epoch(nums, k, 0);
        return ans;
    }

    private void epoch(int[] nums, int k, int position) {
        //如果数组大小为k，那么就直接可以添加到答案中去
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //i=position是为了保证其中数字只能从小到大的存，也就是和全排列不同的地方
        for (int i = position; i < nums.length; i++) {
            //保证这个数没经历过
            if (!v[i]) {
                //添加数组
                v[i] = true;
                list.add(nums[i]);
                epoch(nums, k, i);
                //回溯
                list.removeLast();
                v[i] = false;
            }
        }
    }
}
