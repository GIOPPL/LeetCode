/**
 * Created by GIOPPL
 * on 2021/7/5 16:23
 * TODO:
 */
public class Solution376 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution376 solution376 = new Solution376();
        int[] n1 = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};//7
        int[] n2 = new int[]{1, 7, 4, 9, 2, 5};//6
        int[] n3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};//2
        int[] n4 = new int[]{1, 1, 1, 1, 1, 1};//1
        int[] n5 = new int[]{0, 1, 1, 0};//3
        int[] n6 = new int[]{3, 3, 3, 3, 2, 5};//3
        int[] n7 = new int[]{1, 1, 7, 4, 9, 2, 5};//6
        System.out.println(solution376.wiggleMaxLength(n7));
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        //d数组表示与下一个数的差值，大于0为1，小于0为-1，等于0为0
        int[] distances = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            //差值
            int d = nums[i] - nums[i + 1];
            //差值大于0小于0都好理解
            if (d > 0) {
                distances[i] = 1;
            } else if (d < 0) {
                distances[i] = -1;
            } else {
                //等于0的情况，i+1差值为0，起码需要和i+2相比
                //在连续的数时候，如111132
                //在i=1的时候查找，一直找到下一个不是1的数
                //其余的1为0，Java初始化为0
                //111132->d[]={-1,0,0,0,1},所以到时候可以直接跳过0
                int j = i + 2;
                //一直向后找到下一个不一样的数
                while (j < nums.length && nums[i] - nums[j] == 0) j++;
                if (j < nums.length) {
                    //赋值
                    distances[i] = (nums[i] - nums[j]) > 0 ? 1 : -1;
                    //在这里减少了重复元素的计算，111132中间三个1都不会计算了
                    i = j - 1;
                }
            }
        }
        //如果最开始为0，赋值0，反之为1，这个是最终长度
        int x = distances[0] == 0 ? 0 : 1;
        //最开始的数值
        int pre = distances[0];
        for (int i = 1; i < distances.length; i++) {
            //只要找到和前面pre相反的数，那么x++
            if ((pre == 1 && distances[i] == -1) || (pre == -1 && distances[i] == 1)) {
                x++;
                pre = distances[i];
            }
        }
        return x + 1;
    }
}
