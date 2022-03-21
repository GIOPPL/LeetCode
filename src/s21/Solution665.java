package s21;

/**
 * Created by GIOPPL
 * on 2021/7/2 21:13
 * TODO:[中等][贪心]给定一个数组，数组里面最多改动一个数字，使其变成非递减的数组
    解析：
        1.找到pre和next
        2.找出三个数所有的条件，逐一判断
 */
public class Solution665 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution665 solution665 = new Solution665();
        //ture
        int[] nums1 = new int[]{2, 3, 6, 4, 5};
        //ture
        int[] nums2 = new int[]{2, 3, 1, 4, 5};
        //false
        int[] nums3 = new int[]{2, 3, 6, 7, 4, 5};
        //ture
        int[] nums4 = new int[]{4, 2, 3};
        //false
        int[] nums5 = new int[]{4, 2, 1};
        //true
        int[] nums6 = new int[]{1, 2, 7, 2, 5, 9};
        //true
        int[] nums7 = new int[]{4, 1, 2};
        //true
        int[] nums8 = new int[]{1,4, 1, 2};
        System.out.println(solution665.checkPossibility(nums8));
    }

    public boolean checkPossibility(int[] nums) {
        //如果数组长度小于等于2，那么肯定可以
        if (nums.length <= 2) {
            return true;
        }
        //标志位，true表面修改没用过，false表面修改已经用过了
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            //i前面那个数
            int pre = nums[i - 1];
            //i后面那个数
            int next = Integer.MAX_VALUE;
            if (i + 1 < nums.length) {
                next = nums[i + 1];
            }
            //如果pre和next都正常，只有中间不正确的情况【1，6，2】
            if (!(pre <= nums[i] && nums[i] <= next) && pre <= next) {
                //设置不能修改了
                if (!flag) {
                    return false;
                }
                flag = false;
                //如果中间值小于前面的值，那么修改为前面的值【2，1，3】
                if (nums[i] < pre) {
                    nums[i] = pre;
                }
                //如果中间值大于后面值，那么修改为后面的值【1，6，2】
                if (nums[i] > next) {
                    nums[i] = next;
                }

            }
            //如果前数小于i数，i数大于后数【3，6，2】
            if (pre <= nums[i] && nums[i] > next) {
                if (!flag) {
                    return false;
                }
                flag = false;
                nums[i + 1] = nums[i];
            }
            //如果前数大于i数，后数大于i数【4，1，2】
            if (pre > nums[i] && nums[i] <= next) {
                if (!flag) {
                    return false;
                }
                flag = false;
                nums[i - 1] = nums[i];
            }
            //如果三个数递减排序【3，2，1】，直接返回false
            if (pre > nums[i] && nums[i] > next) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPossibility2(int[] nums) {
        int n = 0;
        if (nums.length <= 2) {
            return true;
        }
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                n++;
            }
            if (max < nums[i]) {
                max = nums[i];
                int next = Integer.MAX_VALUE;
                if (i + 1 < nums.length) {
                    next = nums[i + 1];
                }
                if (nums[i] > next) {
                    maxIndex = i;
                }
            }
        }
        if (n <= 1) {
            return true;
        }
        n = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[i] < max) {
                n++;
            }
            if (i != maxIndex && max < nums[i]) {
                max = nums[i];
            }
        }
        return n < 1;
    }
}
