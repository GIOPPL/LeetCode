package test2;

import java.util.ArrayList;
import java.util.List;

public class BM21 {
    public static void main(String[] args) {
        BM21 b=new BM21();
        System.out.println(b.minNumberInRotateArray(new int[]{2,2,2,1,2}));
    }
    public int minNumberInRotateArray(int [] arr) {
        List<Integer> list=new ArrayList();
        int[] objects = list.stream().mapToInt(Integer::valueOf).toArray();
        int l=0,r=arr.length-1;
        while (l<=r){
            int mid=(l+r)>>1;

            if (arr[mid]>arr[r]){
                l=mid+1;
            }else if (arr[mid]<arr[r]){
                r=mid;
            }else {
                r--;
            }
        }

        return arr[l];

    }
}
