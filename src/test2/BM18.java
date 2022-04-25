package test2;

public class BM18 {

    /**
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     *
     * 给定 target = 3，返回 false。
     *
     * 用该二维数组的性质：
     *
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 改变个说法，即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     * 每次将 m 和目标值 target 比较：
     *
     * 当 m < target，由于 m 已经是该行最大的元素，想要更大只有从列考虑，取值右移一位
     * 当 m > target，由于 m 已经是该列最小的元素，想要更小只有从行考虑，取值上移一位
     * 当 m = target，找到该值，返回 true
     */
    public static void main(String[] args) {
        BM18 b=new BM18();
        int[][] a=new int[][]{
                {1,2,3,9},
                {2,4,9,12},
                {4,7,10,13},
                {8,9,11,15}};
        int i = b.fun1(a, 9, 0, a.length-1);
        System.out.println(i);
    }
    public boolean Find(int target, int [][] array) {
        return false;
    }
    private int fun1(int[][] a,int x,int bottom,int top){
        int mid=(top+bottom)/2;
        if (top<bottom){
            return top;
        }
        if (a[mid][0]==x){
            return mid;
        }else if(a[mid][0]>x){
            return fun1(a,x,bottom,mid-1);
        }else{
            return fun1(a,x,mid+1,top);
        }

    }
}
