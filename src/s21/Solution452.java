package s21;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by GIOPPL
 * on 2021/6/30 10:57
 * TODO:
 */
public class Solution452 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution452 solution452=new Solution452();
        int[][] a=new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int[][] b=new int[][]{{1,2},{3,4},{5,6},{7,8}};
        int[][] c=new int[][]{{1,2},{2,3},{3,4},{4,5}};
        int[][] d=new int[][]{{1,2}};
        int[][] e=new int[][]{{1,2},{2,3}};
        System.out.println(solution452.findMinArrowShots(e));
    }
    public int findMinArrowShots(int[][] points) {
        //先对数组进行排序，用数组的开始位置从小到大排序
        Arrays.sort(points, Comparator.comparingInt(o-> o[0]));
        //返回值为1主要是因为输入points.length>=1
        //这里取1是因为只要数组中有值，就至少需要一支箭
        int re=1;
        //循环从1开始，先给定上一个气球的开始和结束位置
        int preStart=points[0][0];
        int preEnd=points[0][1];
        for (int i = 1; i < points.length; i++) {
            //本气球的开始和结束位置
            int start=points[i][0];
            int end=points[i][1];
            //如果本气球开始的位置或者结束位置在这支箭的范围的开始或者结束位置的中间
            if((start>=preStart&&start<=preEnd)||(end>=preStart&&end<=preEnd)){
                //那么这支箭的范围就缩小到最大的开始，最小的结束
                preStart=Math.max(preStart,start);
                //这个是最小的结束
                preEnd=Math.min(preEnd,end);
            }else {
                //如果不在这之间，那么需要换新箭
                re++;
                //同时更新这支箭的范围为本气球的开始和结束位置
                preStart=start;
                preEnd=end;
            }
        }
        return re;
    }
}
