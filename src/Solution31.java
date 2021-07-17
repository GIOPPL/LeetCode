import java.util.Arrays;
import java.util.Collections;

/**
 * Created by GIOPPL
 * on 2021/6/27 19:22
 * TODO:
 */
public class Solution31 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution31 solution31=new Solution31();
        int[] nums=new int[]{1,2,3,6,3,5,2};
        solution31.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }
    public void nextPermutation(int[] nums) {
        if (nums.length==0){
            return;
        }
        //得到第一个升序序列(i-2,i-1)
        int i= nums.length-1;
        while (i-1>=0&&nums[i-1]>=nums[i]){
            i--;
        }
        //i=0证明升序排列，根据题意，返回逆排序
        if(i==0){
            reverse(nums);
            return;
        }
        i--;
        //找到从后往前排的第一个比大的值
        int j= nums.length-1;
        while (nums[i]>=nums[j]){
            j--;
        }
        //交换i,j的值
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
        //最后把i后面所有的值从小到大排好
        Arrays.sort(nums,i+1,nums.length);
    }
    //逆排序
    private void reverse(int[] nums){
        int i=0,j= nums.length-1;
        while (i<j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }
}
