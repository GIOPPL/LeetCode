package s21;

/**
 * Created by GIOPPL
 * on 2021/7/11 14:48
 * TODO:c=a^2+b^2?
 */
public class Solution633 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution633 s=new Solution633();
        boolean x = s.judgeSquareSum(100);
        System.out.println(x);
    }
    public boolean judgeSquareSum(int c) {
        int j= (int) (Math.sqrt(c)+1);
        int i=0;
        while (i<=j){
            int a= i*i+j*j;
            if(a==c){
                return true;
            }else if(a<c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
