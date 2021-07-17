/**
 * Created by GIOPPL
 * on 2021/7/14 21:44
 * TODO:
 */
public class Solution69 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution69 s=new Solution69();
        double v = Math.sqrt(Integer.MAX_VALUE);
        System.out.println(v);
        int sqrt = s.mySqrt(Integer.MAX_VALUE);
        System.out.println(sqrt);
    }
    public int mySqrt(int x) {
        //大于Integer.MAX_VALUE开根号的值，数值只可能在这里面
        if(x>46341){
            return epoch(0,46341,x);
        }
        return epoch(0,x,x);
    }
    //折半查找
    public int epoch(int i,int j,int target){
        //long防止溢出
        long mid=(i+j)/2;
        long pow=mid*mid;
        long right=(mid+1)*(mid+1);
        if(pow<=target&&right>target){
            return (int) mid;
        }else if(pow>target){
            return epoch(i, (int) (mid-1),target);
        }else{
            return epoch((int) (mid+1),j,target);
        }
    }
}
