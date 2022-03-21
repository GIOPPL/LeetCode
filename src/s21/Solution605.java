package s21;

/**
 * Created by GIOPPL
 * on 2021/6/30 10:10
 * TODO:种花问题，假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
     可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去
 */
public class Solution605 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution605 solution605=new Solution605();
        int[] a=new int[]{1};
        System.out.println(solution605.canPlaceFlowers(a,1));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int empty=0;
        for (int i = 0; i < flowerbed.length; i++) {
            //前面的值
            int pre=0;
            if(i-1>=0&&flowerbed[i-1]==1){
                pre=1;
            }
            //后面的值
            int next=0;
            if(i+1<flowerbed.length&&flowerbed[i+1]==1){
                next=1;
            }
            //如果都等于0的话，则可以在最中间插一个花坛
            if(flowerbed[i]+pre+next==0){
                empty++;
                //插完以后，需要将这个花坛设置为1
                flowerbed[i]=1;
            }
        }
        return empty>=n;
    }
}
