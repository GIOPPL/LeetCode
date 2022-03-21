package s21;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/6/8 21:56
 * TODO:
 */
public class Solution22 {
    public static void main(String args[]) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        int[] a={1,2,3,4,5};
        Solution22 solution22=new Solution22();
        List<String> list = solution22.generateParenthesis(5);
        System.out.println(list.toString());
    }
    public List<String> generateParenthesis(int n) {
        List<String> re=new ArrayList<>();
        if (n<=0)
            return re;
        char[] a=new char[2*n];
        a[0]='(';
        a[2*n-1]=')';
//        for (int i = 1; i < a.length - 3; i++) {
//            a[i]='(';
//            for (int j = i+1; j < a.length - 2; j++) {
//                a[j]=
//            }
//        }
        addElement(a,1,n-1);
        for (int i = 0; i <2*n; i++) {

        }
        return re;
    }

    private void addElement(char[] a,int position,int n){
        if (n==0){
            return;
        }
        a[position]='(';
        addElement(a,position+1,n-1);
    }
}
