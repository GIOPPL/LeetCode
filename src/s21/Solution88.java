package s21;

/**
 * Created by GIOPPL
 * on 2021/7/9 8:38
 * TODO:
 */
public class Solution88 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution88 s=new Solution88();
        int[] n1=new int[]{3,4,7,0,0,0,0};
        int[] n2=new int[]{2,5,6,8};
        s.merge(n1,3,n2,4);
        for(int x:n1){
            System.out.print(x+"\t");
        }
        System.out.println();
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //定义两个指针i指向n1有效末尾,j指向n2末尾
        int i=m-1;
        int j=n-1;
        //k指向n1真实末尾
        int k=m+n-1;
        while (i>=0&&j>=0){
            //比较末尾的大小，大的那个送入n1的真实末尾
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i];
                i--;
            }else {
                nums1[k--]=nums2[j];
                j--;
            }
        }
        //如果出现未比完的情况，那么需要将n2的复制到n1中
        if(j>=0){
            System.arraycopy(nums2,0,nums1,0,j+1);
        }
    }
}
