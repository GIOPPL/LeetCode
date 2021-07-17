/**
 * Created by GIOPPL
 * on 2021/7/4 21:50
 * TODO:递增三元子序列
 */
public class Solution334 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution334 solution334=new Solution334();
        int[] n1=new int[]{1,2,3,4,5};
        int[] n2=new int[]{5,4,3,2,1};
        int[] n3=new int[]{2,1,5,0,4,6};
        System.out.println(solution334.increasingTriplet(n2));
    }
    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3){
            return false;
        }
        //最小的变量
        int first=Integer.MAX_VALUE;
        //第二小的变量
        int second=Integer.MAX_VALUE;
        for (int a : nums) {
            //循环如果a小于最小的数，赋值
            //即使这个a在后面也可以赋值，说明有一个隐藏的在second前面的x比second小
            //更新a意味着如果这second不是的话，那么在second前面找一个最小的，为下一步做准备
            if (a <= first) {
                first = a;
            } else if (a <= second) {
                //如果a<=second赋值
                //目的是增大第三个数的检索范围
                second = a;
            } else  {
                return true;
            }
        }
        return false;
    }
}
