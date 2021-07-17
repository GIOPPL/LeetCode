/**
 * Created by GIOPPL
 * on 2021/7/3 10:47
 * TODO:[贪心][中等]给定一个数组nums,n[i]表示最大能跳跃的距离，求出从n[0]开始，最少条多少次能到达数组末尾
    解析：
        1.先拿到第一个数跳跃的最远距离
        2.循环这个数组内的数值，有加起来比最远距离的下一个最远距离还远的，
          那么当前的位置就替换，x++
 */
public class Solution45 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution45 solution45 = new Solution45();
        int[] a1 = new int[]{2, 1, 3, 1, 1, 4};//2
        int[] a2 = new int[]{2, 1, 1, 3, 1, 1, 4};//3
        int[] a3 = new int[]{3, 1, 3, 1, 3, 1, 1, 4};//3
        int[] a4 = new int[]{2, 1, 3, 1, 1, 4, 1};//3
        int[] a5 = new int[]{2, 3, 1, 1, 4};//2
        int[] a6 = new int[]{2, 3, 0, 1, 4};//2
        int[] a7 = new int[]{3, 2, 1};//1
        int[] a8 = new int[]{2, 3, 1};//1
        int[] a9 = new int[]{1, 3, 2};//2
        int[] a10 = new int[]{3,4,3,2,5,4,3};//3
        int[] a11 = new int[]{10,9,8,7,6,5,4,3,2,1,1,0};//2
        int[] a12 = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};//2
        int[] a13 = new int[]{9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5};//2
        int[][] a=new int[][]{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13};
        int[] b=new int[]{2,3,3,3,2,2,1,1,2,3,2,2,3};
        for (int[] ints : a) {
            System.out.print(solution45.jump(ints) + "\t");
        }
        System.out.println();
        for (int j : b) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public int jump(int[] nums) {
        int x = 0;
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return 1;
        }
        //先取第一个作为初始化
        //当前的值
        int currValue=nums[0];
        //当前的下标
        int currIndex=0;
        //如果第一个数就可以直接跳跃到最后
        if(currValue>= nums.length-1){
            return 1;
        }
        //如果当前可以跳到最远的距离小于数组的长度
        while (currIndex+currValue< nums.length-1){
            //当前能跳到最远距离的内部距离的开始
            int i = currIndex+1;
            //当前能跳到最远距离的内部距离的结束
            int end=currIndex+currValue;
            //设置当前为下一次可以跳到的最远距离
            currIndex=currIndex+currValue;
            currValue=nums[currIndex];
            for (; i < end; i++) {
                //内部数据i可以跳到的最远距离
                int next=i+nums[i];
                //如果这个距离大于当前的最远距离，那么替换复制
                if(next>currIndex+currValue){
                    currIndex=i;
                    currValue=nums[i];
                }
            }
            x++;
            //如果距离已经小到下一次可以直接跳到的话，直接返回
            if(currIndex+currValue>=nums.length-1){
                return x+1;
            }
        }
        return x;
    }
}
