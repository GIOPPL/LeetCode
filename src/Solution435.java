import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by GIOPPL
 * on 2021/6/29 19:19
 * TODO:[中等]给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
    [ [1,2], [2,3], [3,4], [1,3] ]，输出1
    解题思路：
        1.先按结尾大小排序
        2.贪心算法，优先选择结尾小的，如果不可以的话，则需要删除
 */
public class Solution435 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        int[][] intervals=new int[][]{{1,2},{2,3},{3,4},{1,3}};
        Solution435 solution435=new Solution435();
        System.out.println(solution435.eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        //排序，按照结尾从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(o1->o1[1]));
        //拿到第一个节点得结束值
        int pre=intervals[0][1];
        int re=0;
        for (int i = 1; i < intervals.length; i++) {
            //如果上一个节点的结束值小于这一个节点的开始值，那么相安无事，pre更新
            if(pre<=intervals[i][0]){
                pre=intervals[i][1];
            }else {
                //否则这个节点需要删除
                re++;
            }
        }
        return re;
    }

}
