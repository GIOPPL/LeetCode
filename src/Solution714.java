/**
 * Created by GIOPPL
 * on 2021/7/8 8:29
 * TODO:
 */
public class Solution714 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution714 s=new Solution714();
        int[] p1=new int[]{1, 3, 2, 8, 4, 9};
        int i = s.maxProfit(p1, 2);
        System.out.println(i);
    }
        public int maxProfit(int[] prices, int fee) {
            int len=prices.length;
            if (len<2){
                return 0;
            }
            int res=0,min=prices[0];
            for (int i = 1; i <len ; i++) {
                if (prices[i]<min){
                    //未发生买卖时找到第一个最小数，如果发生过买卖则比较当前价格和上次卖出时的价格减去手续费
                    min=prices[i];
                }else {
                    if (prices[i]-fee>min){
                        res+=prices[i]-min-fee;
                        //当前的价格已经减过手续费，所以min的值应为当前价格减去手续费。
                        min=prices[i]-fee;
                    }
                }
            }
            return res;
        }
}
