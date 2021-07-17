import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/6/23 13:47
 * TODO:编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
 */
public class Solution191 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        int x=-4;
        Solution191 solution191=new Solution191();
        System.out.println(Integer.toBinaryString(x));
        System.out.println(solution191.hammingWeight(x));
    }
    public int hammingWeight(int n) {
        int re=0;
        for (int i = 0; i < 32; i++) {
            re+=(n>>i)&1;
        }
        return re;
    }
}
