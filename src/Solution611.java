import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GIOPPL
 * on 2021/7/7 7:59
 * TODO:
 */
public class Solution611 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution611 s=new Solution611();
        int[] n1=new int[]{2,2,3,4};//3
        int[] n2=new int[]{2,2,3,3,4,4,5,5,6,6};
        int i = s.triangleNumber(n2);
        System.out.println(i);
    }
    public int triangleNumber(int[] nums) {
        //首先排序
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        //固定最大边
        for(int i = len-1; i>=2; i--){
            //建立双指针
            int l = 0; int r = i-1;
            while(l<r){
                //这里只需要判断一次了，因为固定了最大边，所以最大边加上内层双指针指向的任意一条边都大于另一条
                if(nums[l]+nums[r]>nums[i]){
                    //为什么这里是r-l 愚蠢的我想了半天
                    //因为我们此刻的最小边是l指针指向的数，此时都满足了上面的条件
                    //那么接着l+1,l+2...一直到r-1下标的肯定也满足这个条件，大于nums[i]
                    //归根结底还是因为这是一个排序树组
                    res+=r-l;
                    //当满足条件，说明和已经够大，则移动右指针，缩小两指针之和
                    //这是双指针问题中经典的一步，类似的题目：leetCode11
                    r--;
                }
                //当不满足，说明和不够大，则增大左指针指向的元素
                else{
                    l++;
                }
            }
        }
        return res;
    }
}
