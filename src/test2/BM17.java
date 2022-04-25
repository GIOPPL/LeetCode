package test2;

public class BM17 {
    public static void main(String[] args) {
        BM17 b=new BM17();
        int search = b.search(new int[]{-1, 0, 3, 4, 6, 10, 13, 14}, 11);
        System.out.println(search);
    }
    public int search (int[] nums, int target) {
        if (nums==null){
            return -1;
        }
        return fun(nums,target,0,nums.length-1);
    }

    private int fun(int[] nums,int t,int l,int r){
        int mid=(l+r)/2;
        if (l>r){
            return -1;
        }
        if (nums[mid]==t){
            return mid;
        }else if (nums[mid]>t){
            return fun(nums,t,l,mid-1);
        }else {
            return fun(nums,t,mid+1,r);
        }
    }
}
