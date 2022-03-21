package s21;

/**
 * Created by GIOPPL
 * on 2021/7/8 19:30
 * TODO:两数之和2-输入有序数组
 */
public class Solution167 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution167 s = new Solution167();
        int[] n1 = new int[]{2,7,14,15};
        int[] n2 = new int[]{2,3,4};
        int[] n3 = new int[]{-1,0};
        int[] sum = s.twoSum(n2, 6);
        System.out.println("["+sum[0]+","+sum[1]+"]");
    }
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            int x=numbers[i]+numbers[j]-target;
            if(x>0){
                j--;
            }else if(x<0){
                i++;
            }else {
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        if(numbers==null||numbers.length==0){
            return new int[]{};
        }
        for (int i = 0; i < numbers.length; i++) {
            int x=sort(numbers,i+1, numbers.length-1,target-numbers[i]);
            if(x!=-1){
                return new int[]{i+1,x+1};
            }
        }
        return new int[]{};
    }
    public int sort(int[] num,int left,int right,int target){
        if(left<=right){
            int mid=(left+right)/2;
            if(num[mid]==target){
                return mid;
            }else if(num[mid]>target){
                return sort(num,left,mid-1,target);
            }else {
                return sort(num,mid+1,right,target);
            }
        }
        return -1;
    }
}
