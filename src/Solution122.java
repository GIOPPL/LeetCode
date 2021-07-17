/**
 * Created by GIOPPL
 * on 2021/7/1 10:27
 * TODO:买股票
     给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    解析：
        1.注意没说一天可以交易多少次，所以可以在同一天，卖了再买
        2.如果length<=1的时候那么返回0
        3.设置re=0，循环，如果今天比前一天多，那么就需要买
 */
public class Solution122 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution122 solution122 = new Solution122();
        int[] a1 = new int[]{7,1,5,3,6,4};
        int[] a2 = new int[]{1,2,3,4,5};
        int[] a3 = new int[]{7,6,4,3,1};
        System.out.println(solution122.maxProfit(a2));
    }

    public int maxProfit(int[] prices) {
        int re=0;
        if(prices.length<=1){
            return re;
        }
        for (int i = 1; i < prices.length; i++) {
            int x=prices[i]-prices[i-1];
            if(x>0){
                re+=x;
            }
        }
        return re;
    }
}
