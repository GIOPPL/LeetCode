/**
 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 示例 1：

 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2
 示例 2：

 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 示例 3：

 输入：nums1 = [0,0], nums2 = [0,0]
 输出：0.00000
 示例 4：

 输入：nums1 = [], nums2 = [1]
 输出：1.00000
 示例 5：

 输入：nums1 = [2], nums2 = []
 输出：2.00000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * TODO:大概意思就是给两个顺序数组，然后找到这两个数组的中位数
 * 启动方法：
 int[] a={5};
 int[] b={1,2,3,4};
 double re = solution.findMedianSortedArrays(a,b);
 print(re);
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int x=0;
        int j=nums1.length!=0?nums1.length-1:-1;
        int y=nums2.length!=0?nums2.length-1:-1;
        if(j==-1){
            return getMid(nums2,0,nums2.length-1);
        }
        if(y==-1){
            return getMid(nums1,0,nums1.length-1);
        }
        while (i<=j&&x<=y&&!(i==j&&x==y)){
            if(nums1[i]<nums2[x]){
                i++;
            }else if(nums1[i]>nums2[x]){
                x++;
            }else {
                i++;
            }
            if(nums1[j]> nums2[y]){
                j--;
            }else if(nums1[j]< nums2[y]){
                y--;
            }else{
                y--;
            }
        }
        if(x==y&&i==j){
            return (nums2[x]+nums1[i])/2.0f;
        }
        if(x==y){
            return nums2[x];
        }
        if (i==j){
            return nums1[i];
        }
        if(i<=j){
            return getMid(nums1,i,j);
        }else {
            return getMid(nums2,x,y);
        }
    }

    double getMid(int[] num, int start, int end){
        if((end-start+1)%2==0){
            return ((num[(end+start)/2])+num[(end+start)/2+1])/2.0f;
        }else {
            return num[(end+start)/2];
        }
    }
}
