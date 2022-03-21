package s21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/6/6 18:40
 * TODO:给定一个数组nums，求nums[a]+nums[b]+nums[c]最接近target
    启动:
     int[] a=new int[]{-1,0,1,1,55};
     s21.Solution16 solution16=new s21.Solution16();
     int i = solution16.threeSumClosest(a, 3);
     for (int j = 0; j < a.length; j++) {
     System.out.print(a[j]+"\t");
     }
     System.out.println();
     System.out.println(i);

 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int score=Integer.MAX_VALUE;
        if(target>0&&nums[nums.length-1]<=0){
            return nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        }else if(target<0 && nums[0]>=0){
            return nums[0]+nums[1]+nums[2];
        }
        for (int k = 0; k < nums.length; ) {
            int i=k+1,j= nums.length-1;
            while (i<j){
                if ((nums[k]+nums[i]+nums[j])<target){
                    if((target-(nums[k]+nums[i]+nums[j]))<min){
                        min=target-(nums[k]+nums[i]+nums[j]);
                        score=nums[k]+nums[i]+nums[j];
                    }
                    while (i<j&&nums[i]==nums[i+1]){
                        i++;
                    }
                    i++;
                }else if((nums[k]+nums[i]+nums[j])>target){
                    if(((nums[k]+nums[i]+nums[j])-target)<min){
                        min=(nums[k]+nums[i]+nums[j])-target;
                        score=nums[k]+nums[i]+nums[j];
                    }
                    while (i<j&&nums[j]==nums[j-1]){
                        j--;
                    }
                    j--;
                }else {
                    return target;
                }
            }

            while (k+1< nums.length-1&&nums[k]==nums[k+1]){
                k++;
            }
            k++;
        }
        return score;
    }
}
