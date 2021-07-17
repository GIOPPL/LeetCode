/**
 * Created by GIOPPL
 * on 2021/6/3 22:12
  TODO:题目
    给定一个int数组，求i->j中间的能存储的水最大值
    输入：[1,8,6,2,5,4,8,3,7]输出：49

  TODO:启动：
     Solution11 solution11=new Solution11();
     int maxArea = solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
     System.out.println(maxArea);
 */
public class Solution11 {
    //超时，O(n²)
    public int maxArea2(int[] height) {
        int max=0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int res=j-i;
                int h=Math.min(height[i],height[j]);
                if((h*res)>max){
                    max=h*res;
                }
            }
        }
        return max;
    }
    //95%，O(n)，双指针
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while (i<j){
            if (height[i]<height[j]){
                max=Math.max(max,(j-i)*height[i]);
                i++;
            }else {
                max=Math.max(max,(j-i)*height[j]);
                j--;
            }
        }
        return max;
    }
}
