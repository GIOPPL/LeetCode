/**
 * Created by GIOPPL
 * on 2021/6/25 23:53
 * TODO:给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *  如果数组中不存在目标值 target，返回[-1, -1]。
 *  例如nums = [5,7,7,8,8,10], target = 8 返回[3,4]
 */
public class Solution34 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        int[] nums=new int[]{};
        Solution34 solution34=new Solution34();
        int[] x=solution34.searchRange(nums,3);
        System.out.println(x[0]+","+x[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        //先二分查找，
        int position=epoch(nums,0,nums.length-1,target);
        //没找到就直接返回
        if(position==-1){
            return new int[]{-1,-1};
        }else{
            //如果找到了那么就先向前找
            int i=position;
            while(i>=0&&nums[i]==target){
                i--;
            }
            //再向后找
            int j=position;
            while(j< nums.length&&nums[j]==target){
                j++;
            }
            return new int[]{i+1,j-1};
        }
    }

    //二分查找具体实现
    public int epoch(int[] nums,int left,int right,int target){
        if(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                return epoch(nums,left,mid-1,target);
            }else if(nums[mid]<target){
                return epoch(nums,mid+1,right,target);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
