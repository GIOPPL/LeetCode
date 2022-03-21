package s21;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/6/28 15:43
 * TODO:给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class Solution39 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        int[] a=new int[]{1,2,3,4,5};
        Solution39 solution39=new Solution39();
        List<List<Integer>> lists = solution39.combinationSum(a, 9);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
    ///全局的总lists
    List<List<Integer>> lists;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0||target<0){
            return lists;
        }
        lists=new ArrayList();
        //每次有正确的时候添加的List
        List<Integer> list=new ArrayList();
        process(candidates,target,list,0);
        return lists;
    }
    private void process(int[] candidates, int target,List<Integer> list,int start) {
        //函数出口1，如果target<0的时候，返回
        if (target < 0) {
            return;
        } else if (target == 0) {
            //函数出口2，target=0的时候添加进去，这里注意需要复制一份
            lists.add(new ArrayList<Integer>(list));
        } else{
            //循环添加
            for (int i = start; i < candidates.length; i++) {
                //添加一个数
                list.add(candidates[i]);
                //递归添加，这里的start=i意思是去除重复元素，也就是不会向前跑，
                //比如说 c=[2,3,6,7] target=7
                //在第一轮的时候添加223,第二轮c[i]=3的时候防止添加前面的2元素
                process(candidates, target - candidates[i], list, i);
                //保证在不匹配的时候，删除上一个元素，如上面示例，在添加[2,2,2,2]后不满足要求，
                // 那么则需要删除列表里上一个的元素
                list.remove(list.size() - 1);
            }
        }
    }
}
