package s21;

/**
 * Created by GIOPPL
 * on 2021/7/6 9:51
 * TODO:
 */
public class Solution581 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution581 solution581 = new Solution581();
        int[] n1 = new int[]{2, 5, 6, 1, 8, 19, 9, 15, 16, 17};//10
        int[] n2 = new int[]{2, 2, 2, 2, 2};//0
        int[] n3 = new int[]{1, 2, 3, 4, 5, 0};//6
        int[] n4 = new int[]{5, 4, 3, 2, 1};//5
        int[] n5 = new int[]{2, 3, 1, 4, 5, 6};//3
        int[] n6 = new int[]{2, 6, 4, 8, 28, 9, 15, 26, 37};//7
        System.out.println(solution581.findUnsortedSubarray(n6));
    }
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        //min标志转折点中最小的数,max反之
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //标志转折点中的开始和结束
        //start时最开始转折点的第一位，只可以变动一次
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            //转折点中赋值start和end
            if (nums[i] > nums[i + 1]) {
                //start只能赋值一次
                if (start == -1) {
                    start = i;
                }
                end = i + 1;
                //求转折点中最小和最大的数
                min = Math.min(nums[i + 1], min);
                max = Math.max(nums[i], max);
            }
        }
        //从前往后找，找到比min大的位置结束
        for (int i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
            }
        }
        //从后往前找，找到比max小的位置结束
        for (int i = nums.length - 1; i > end; i--) {
            if (nums[i] < max) {
                end = i;
            }
        }
        //如果是升序，[1,2,3,4,5]
        if (start == -1) {
            return 0;
        }
        return end - start + 1;
    }
}
