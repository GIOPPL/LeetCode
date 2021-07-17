/**
 * Created by GIOPPL
 * on 2021/7/3 16:36
 * TODO:[中等] [贪心]（跳跃游戏二）给定一个数组nums，n[i]为最大能跳跃的距离，求能不能从0开始跳到最后
 */
public class Solution55 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution55 solution55 = new Solution55();
        int[] a1 = new int[]{2, 3, 1, 1, 4};//true
        int[] a2 = new int[]{3, 2, 4, 1, 0, 0, 0, 4};//false
        int[] a3 = new int[]{3, 2, 4, 1, 0, 0, 4};//true
        int[] a4 = new int[]{3, 2, 1, 0, 4};//false
        int[] a5 = new int[]{0, 1};//false
        int[] a6 = new int[]{1, 1, 1, 0};//true
        int[] a7 = new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};//true
        int[][] a = new int[][]{a1, a2, a3, a4, a5, a6, a7};
        int[] b = new int[]{1, 0, 1, 0, 0, 1, 1};
//        System.out.println(solution55.canJump(a7));
        solution55.testAllElement(a, b, solution55);
    }
    //贪心算法
    public boolean canJump(int[] nums){
        //设置最大能跳的位置
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            //如果运行到的位置大于最大能跳的位置，返回false
            if(i>max)
                return false;
            //最大的位置为max和该点的值加上该点索引得到最大值
            max=Math.max(max,nums[i]+i);
        }
        return true;
    }
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int currValue = nums[0];
        if (currValue >= nums.length - 1) {
            return true;
        }
        boolean isHaveZero = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                isHaveZero = true;
                break;
            }
        }
        if (!isHaveZero) {
            return true;
        }
        int i = nums.length - 1;
        if (nums[nums.length - 1] == 0) {
            i = nums.length - 2;
        }
        while (i >= 0) {
            int x = nums[i];
            if (x == 0) {
                //算出总共有多少个0连着
                int zeroNum = 0;
                int j = i;
                while (j >= 0 && nums[j] == 0) {
                    j--;
                    zeroNum++;
                }
                //i在下一个非0位置
                i = i - zeroNum;
                j = i;
                while (j >= 0 && nums[j] <= (i - j + zeroNum)) {
                    j--;
                }
                if (j < 0) {
                    return false;
                }
            } else {
                i--;
            }
        }
        return true;
    }
    private void testAllElement(int[][] a, int[] b, Solution55 solution55) {
        for (int[] ints : a) {
            System.out.print(solution55.canJump(ints) + "\t");
        }
        System.out.println();
        for (int j : b) {
            if (j == 0) {
                System.out.print("false\t");
            } else {
                System.out.print("true\t");
            }
        }
        System.out.println();
    }
}
