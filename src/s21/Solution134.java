package s21;

/**
 * Created by GIOPPL
 * on 2021/7/3 21:08
 * TODO:加油站问题
    解析：

 */
public class Solution134 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution134 solution134=new Solution134();
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        System.out.println(solution134.canCompleteCircuit(gas,cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从第i个站点出发
        for (int i = 0; i < gas.length; i++) {
            //记录从i出发的当前油量
            int curr=gas[i];
            //到下一个站点的消耗
            int nextCost=cost[i];
            //查看这一圈是否能走的过去，能则直接返回
            boolean noPass=false;
            //这是从i开始出发，走一圈
            for (int j = i; j < i + gas.length; j++) {
                //如果当前油量不足以支撑到下一个站点,结束本站点开始的循环
                if(curr<nextCost){
                    noPass=true;
                    break;
                }
                //循环的index，如果到达最后一个，那么下一个要这么写，循环数组的标志
                int index=(j+1)% gas.length;
                //当前油量更新
                curr=curr-nextCost+gas[index];
                //下一站的消耗更新
                nextCost=cost[index];
            }
            //能走过去就直接返回
            if(!noPass){
                return i;
            }
        }
        return -1;
    }
}
