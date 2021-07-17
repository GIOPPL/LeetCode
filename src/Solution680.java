/**
 * Created by GIOPPL
 * on 2021/7/11 15:12
 * TODO:
 */
public class Solution680 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution680 s=new Solution680();
        String s1="aba";
        String s2="abca";
        String s3="abccbaab";
        boolean b = s.validPalindrome(s2);
        System.out.println(b);
    }
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        //这一步很重要，从13%->打败95%的程序
        char[] list=s.toCharArray();
        while (i<j){
            //和原本一样，但是如果不相等的话，那么需要额外处理
            if (list[i]==list[j]){
                i++;
                j--;
            }else {
                //判断不出来到底是i++还是j--，所以两个都试一下
                return isPalindrome(list,i+1,j)||isPalindrome(list,i,j-1);
            }
        }
        return true;
    }
    //最简单的验证回文
    public boolean isPalindrome(char[] list,int i,int j){
        while (i<j){
            if(list[i++]!=list[j--])
                return false;
        }
        return true;
    }
}
