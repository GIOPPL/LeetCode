package s21;

/**
 * 215. 数组中的第K个最大元素
 */
public class Solution215 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution215 s = new Solution215();
        int[] n1 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] n2 = new int[]{3, 2, 1, 5, 6, 4};
        int[] n3 = new int[]{1};
        int a = s.findKthLargest(n3, 1);
        System.out.println(a);
    }

    public int findKthLargest(int[] nums, int k) {
        if (k <= 0 || k > nums.length)
            return -1;
        return sort(nums, 0, nums.length - 1, k);
    }

    private int sort(int[] nums, int l, int r, int k) {
        //快速排序基本
        int x = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && nums[j] > x) j--;
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < x) i++;
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = x;
        //排完序以后查看当前位置在哪里
        int n = nums.length - i;
        if (n > k) {
            //如果位置在右边
            return sort(nums, i + 1, r, k);
        } else if (n < k) {
            //如果位置在左边
            return sort(nums, l, i - 1, k);
        } else {
            //当前位置就是我们需要的
            return nums[i];
        }
    }
}
