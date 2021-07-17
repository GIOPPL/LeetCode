/**
 * Created by GIOPPL
 * on 2021/6/23 13:47
 * TODO:给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    TODO:解题思路：先把所有的数都变成负数，然后倍数相加，每次相加x都*2也就是移位，d2也✖2，d1-=d2，这一层循环结束以后在进行
 */
public class Solution29 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        Solution29 solution191=new Solution29();
        /**
         * -2147483648
         * 2147483647
         *
         * -1010369383
         * -2147483648
         *
         * 1
         * 2
         */
        System.out.println(solution191.divide(0,-1));
    }
    public int divide(int dividend, int divisor) {
        long d1=dividend;
        long re=0;
        //被除数等于0的情况下就直接返回0了
        if(dividend==0){
            return 0;
        }
        //sign表示是否是正数，^为异或，相异为1
        boolean sign=(dividend>0)^(divisor>0);
        //把被除数和除数都变成负数
        if(dividend>0){
            d1=-d1;
        }
        if (divisor>0){
            divisor=-divisor;
        }
        do{
            //记录每一层的相减数量，到最后和re相加，x=1的原因是到时候要移位
            long x=1;
            //d2设置为long类型的值
            long d2=divisor;
            //被除数减去除数，这一次减的原因是设置了x=1
            d1-=d2;
            //如果被除数减到溢出了,则返回0，这里是判断d1=1,d2=2的情况
            if(d1>0){
                return 0;
            }
            //内部循环,如果被除数小于除数的时候退出循环，这里的d2每一次循环都会成倍的增加
            while (d1<=d2){
                //被除数减去除数，这是正式的减法
                d1-=d2;
                //除数*2
                d2=d2<<1;
                //减少的数量*2
                x=x<<1;
            }
            //这一次循环较少的数量加到总数量中
            re+=x;
            //如果被除数小于除数，这里选择最原始的除数原因就是保证被除数小于除数
        }while (d1<=divisor);
        //下面是处理非负数的问题
        if(sign){
            if(re>Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
            return (int) -re;
        }
        if(re>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) re;
    }
}
