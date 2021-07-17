/**
 * Created by GIOPPL
 * on 2021/7/17 21:26
 * TODO:
 */
public class Solution540 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution540 s = new Solution540();
        int[] n1 = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7};
        int[] n2 = new int[]{1,1,2,3,3};
        int a = s.singleNonDuplicate(n2);
        System.out.println(a);
    }

    public int singleNonDuplicate(int[] nums) {
        return epoch(nums, 0, nums.length - 1);
    }

    public int epoch(int[] nums, int i, int j) {
        //设置左边为最大值，右边为最小值
        //
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int mid = (i + j) / 2;
        //防止数组左越界
        if (mid >= 1) {
            l = nums[mid - 1];
        }
        //防止数组右越界
        if (mid < nums.length - 1) {
            r = nums[mid + 1];
        }
        //终止条件，如果和左边右边都不相等
        if (nums[mid] != l && nums[mid] != r) {
            return nums[mid];
        }
        //如果mid是偶数，那么需要和左边对比
        if (mid % 2 == 0) {
            int left = nums[mid - 1];
            //                              【0  1  2 3  4 5  6 7  8  9  10  11  12】
            //如果和左边相等那么这个数肯定是在左边【1，1，2，2，3，4】4【5，5，6， 6， 7 ，7】
            if (nums[mid] == left) {
                return epoch(nums, i, mid - 1);
            } else {
                return epoch(nums, mid + 1, j);
            }
        } else {
            //如果是奇数，那么要和右边的相比较
            int right = nums[mid + 1];
            //如果相等，那么这个数肯定是在左边
            if (nums[mid] == right) {
                return epoch(nums, i, mid - 1);
            } else {
                //如果不相等，那么这个数肯定是在右边
                return epoch(nums, mid + 1, j);

            }
        }
    }
}
