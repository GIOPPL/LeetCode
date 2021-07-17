import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/6/5 18:34
 * TODO:给定一个数组nums，求a+b+c=0,返回[nums[a],nums[b],nums[c],],不允许重复
    启动：
     int[] a=new int[]{-2,0,0,2,2};
     Solution15 solution15=new Solution15();
     solution15.quickSort(a,0,a.length-1);
     for (int i = 0; i < a.length; i++) {
     System.out.print(a[i]+"\t");
     }
     System.out.println("\n");
     List<List<Integer>> lists = solution15.threeSum(a);
     for (int i = 0; i < lists.size(); i++) {
     System.out.println(lists.get(i).toString());
     }

 */
public class Solution15 {
    //超时,暴力解法
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && i != k && j != k && (nums[i] + nums[j] + nums[k]) == 0) {
                        int[] a = new int[]{nums[i], nums[j], nums[k]};
                        byte min = 0, mid = 1, max = 2;
                        if (a[min] > a[mid]) {
                            swap(a, min, mid);
                        }
                        if (a[min] > a[max]) {
                            swap(a, min, max);
                        }
                        if (a[mid] > a[max]) {
                            swap(a, mid, max);
                        }
                        boolean isExist = false;
                        for (List<Integer> list : lists) {
                            if (list.get(0) == a[min] && list.get(1) == a[mid] && list.get(2) == a[max]) {
                                isExist = true;
                                break;
                            }
                        }
                        if (isExist) {
                            continue;
                        }
                        List<Integer> l = new ArrayList<>();
                        l.add(a[0]);
                        l.add(a[1]);
                        l.add(a[2]);
                        lists.add(l);
                    }
                }
            }
        }
        return lists;
    }

    void swap(int[] x, int i, int j) {
        int swap = x[i];
        x[i] = x[j];
        x[j] = swap;
    }

    //正规解法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        if(nums[nums.length-1]<0||nums[0]>0){
            return lists;
        }
        for (int k = 0; k< nums.length&&nums[k]<=0; ) {
            int i=k+1,j= nums.length-1;
            while (i<j){
                if(nums[i]+nums[j]+nums[k]<0){
                    while (i<j&&nums[i]==nums[i+1]){
                        i++;
                    }
                    i++;
                }else if (nums[i]+nums[j]+nums[k]>0){
                    while (i<j&&nums[j]==nums[j-1]){
                        j--;
                    }
                    j--;
                }else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[k]);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    lists.add(l);
                    while (i<j&&nums[i]==nums[i+1]){
                        i++;
                    }
                    i++;
                    while (i<j&&nums[j]==nums[j-1]){
                        j--;
                    }
                    j--;
                }
            }
            while (k+1< nums.length-1&&nums[k]==nums[k+1]){
                k++;
            }
            k++;
        }
        return lists;
    }

    public void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


}
