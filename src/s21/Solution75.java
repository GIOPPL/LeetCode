package s21;

/**
 * Created by GIOPPL
 * on 2021/7/11 21:32
 * TODO:颜色分类
 */
public class Solution75 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution75 s = new Solution75();
        int[] n0 = new int[]{0,1,0};
        int[] n1 = new int[]{2, 1, 1, 2, 0, 0, 2, 1, 1, 0};
        int[] n2 = new int[]{2, 0, 1};
        int[] n3 = new int[]{1, 0, 2};
        int[] n4 = new int[]{2, 1};
        int[] n5 = new int[]{2, 0};
        int[] n6 = new int[]{2, 0,1};
        int[] n7 = new int[]{1,0};
        int[][] n = new int[][]{n0,n2, n1, n3, n4, n5,n6,n7};

        for (int i = 0; i < n.length; i++) {
            int[] a = n[i];
            s.sortColors(a);
            System.out.print("n" + (i) + ":\t");
            for (int j : a) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        //先分类出2的，挪到最后面去
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            //找到i指向2的数
            while (i < j && nums[i] != 2)
                i++;
            //找到j指向不为2的数
            while (i < j && nums[j] == 2)
                j--;
            //交换
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        //i重新回到起点开始
        i = 0;
        //j一直要向指向一个不为2的数，剩下[0,j]之间都是1和0
        while (i<j&&nums[j]==2){
            j--;
        }
        //分类1和0
        while (i < j) {
            //i指向一个为1的数
            while (i < j && nums[i] != 1)
                i++;
            //j指向一个不为1的数
            while (i < j && nums[j] == 1)
                j--;
            //交换
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }


}
