package test2;

public class BM19 {

    public static void main(String[] args) {
        BM19 b=new BM19();
        int element = b.findPeakElement(new int[]{2, 4, 1, 2, 7, 8});
        System.out.println(element);
    }
    public int findPeakElement (int[] nums) {
        //[2,4,10,9,7,8,4]
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int mid=(l+r)/2;
            if (nums[mid]>nums[mid+1]){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }
}
