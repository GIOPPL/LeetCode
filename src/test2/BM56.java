package test2;
import java.util.*;
public class BM56 {
    public static void main(String[] args) {
        BM56 b=new BM56();
        ArrayList<ArrayList<Integer>> arrayLists = b.permuteUnique(new int[]{1, 1, 2});
        System.out.println(arrayLists);
    }
    ArrayList<ArrayList<Integer>> re=new  ArrayList<ArrayList<Integer>>();
    LinkedList<Integer> list=new LinkedList<Integer>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        boolean[] visit=new boolean[num.length];
        Arrays.sort(num);
        fun(num,visit);
        return re;
    }



    private void fun(int[] num,boolean[] v){
        if(list.size()==num.length){
            re.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<num.length;i++){
            if(v[i]){
                continue;
            }
            if(i>0&&num[i-1]==num[i]&&!v[i-1]){
                continue;
            }
            v[i]=true;
            list.add(num[i]);
            fun(num,v);
            v[i]=false;
            list.removeLast();
        }
    }
}
