package s21;

/**
 * Created by GIOPPL
 * on 2021/7/11 18:44
 * TODO:
 */
public class Solution42 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution42 s = new Solution42();
        int[] a1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
        int[] a2 = new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6};//23
        int[] a3 = new int[]{4,2,0,3,2,5};//9
        int[] a4 = new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};//83
        int x = s.trap(a4);
        System.out.println(x);
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int x = 0;
        //保存的时上一次最小的高度，初始化为0
        int h = 0;
        int i = 0;
        int j = height.length - 1;
        //i=到第一个非零元素
        while (height[i] <= 0)
            i++;
        //j=从后往前第一个非零元素
        while (height[j] <= 0)
            j--;
        //i>=j时结束
        while (i < j) {
            //找到左边的高度和右边的高度
            int left = height[i];
            int right = height[j];
            //找到最矮的墙
            int min = Math.min(left, right);
            //设置k在(i,j)中循环，把小于这个墙的加一部分水
            for (int k = i + 1; k < j; k++) {
                //如果这个墙小于是左右墙中最矮墙的才可以运算
                if (min - height[k] > 0) {
                    //如果这个墙之前已经计算过了
                    if (height[k] < h) {
                        //那么只需要减掉上一次墙的大小就可以了
                        x += min - h;
                    } else {
                        //如果没计算过
                        //那么需要加上min-这个墙的高度
                        x += min - height[k];
                    }
                }
            }
            //保存本次左右墙中最矮墙
            h = min;
            //如果最矮墙是左边的墙，那么左边开始找下一个墙
            if(left==h){
                i++;
                while (i < j && height[i] <= h) {
                    i++;
                }
            }else {
                //否则，右边开始小最矮的墙
                j--;
                while (i < j && height[j] <= h) {
                    j--;
                }
            }
        }
        return x;
    }


}
