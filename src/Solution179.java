import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/3 21:55
 * TODO:求最大数
    解析：
        1.排序，排完之后逐一取出
        2.排序的内部原理就是比较a+b和b+a的大小
 */
public class Solution179 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution179 solution179 = new Solution179();
        int[] a1 = new int[]{9, 5, 51, 567, 5353, 5671};
        int[] a2 = new int[]{3, 30, 34, 5, 9};
        int[] a3 = new int[]{10, 2};
        int[] a4 = new int[]{1};
        int[] a5 = new int[]{0, 0};
        System.out.println(solution179.largestNumber(a3));
    }
    public String largestNumber(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        //list表示需nums转换成String[]类型
        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }
        //排序，比较String的a+b和b+a的大小
        Arrays.sort(list, (a,b)->(b+a).compareTo(a+b));
        //如果list的第一位为0，说明后面的都是0，直接返回0，防止[0,0,0,0]出现
        if(list[0].equals("0")){
            return "0";
        }
        //连起来
        for (String num : list) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
