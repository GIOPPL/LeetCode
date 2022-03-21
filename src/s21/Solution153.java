package s21;

/**
 * Created by GIOPPL
 * on 2021/7/15 8:24
 * TODO:
 */
public class Solution153 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution153 s = new Solution153();
        int[] n1 = new int[]{5, 6, 7, 8, 1, 2, 3, 4, 5};
        int[] n2 = new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5};
        int[] n3 = new int[]{4,5,6,7,0,1,2};
        int[] n4 = new int[]{1,0};
        int min = s.findMin(n2);
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        if(nums.length==1||nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        return epoch(nums, 0, nums.length - 1);
    }

    public int epoch(int[] nums, int i, int j) {
        if(nums[i]<nums[j]){
            return nums[i];
        }
        int mid = (i + j) / 2;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if (mid >= 1) {
            left = nums[mid - 1];
        }
        if (mid < nums.length - 1) {
            right = nums[mid + 1];
        }
        if (nums[mid] < left && nums[mid] < right) {
            return nums[mid];
        } else if (nums[mid] < nums[i] && nums[mid] < nums[j]) {
            //说明mid是在第二个数组里面
            return epoch(nums, i, mid - 1);
        } else {
            //说明在第一个数组里面
            return epoch(nums, mid + 1, j);
        }
    }
}
