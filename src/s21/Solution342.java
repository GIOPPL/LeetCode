package s21;

/**
 * Created by GIOPPL
 * on 2021/5/31 16:42
 * TODO:给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
    启动：
     s21.Solution342 solution342=new s21.Solution342();
     boolean powerOfFour = solution342.isPowerOfFour(16);
     print(powerOfFour);

 */
public class Solution342 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution342 solution342=new Solution342();
        System.out.println(solution342.isPowerOfFour(16));
    }
    public boolean isPowerOfFour(int n) {
         if(n==0){
             return false;
         }
         if((n&0xAAAAAAAA)==0 && (n&n-1)==0){
             return true;
         }else{
             return false;
         }
    }

}
