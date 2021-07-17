import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/5 19:06
 * TODO:删除K位数字
 */
public class Solution402 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution402 solution402=new Solution402();
        String s1="1124913239";//1113239  3 ;11129 5;
        String s2="1432219";//1219 3
        String s3="10";//0 1
        String s4="10200";//0 2
        String s5="123456";//12 4
        System.out.println(solution402.removeKdigits(s4,2));
    }
    public String removeKdigits(String num, int k) {
        //如果K的值大于等于数组长度，直接返回0
        if(k>=num.length()){
            return "0";
        }
        //list装的是num[i]，以后操作都用list，主要是为了删除方便
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            list.add(num.charAt(i));
        }
        //计数，一个一个删，贪心算法
        for (int i = 0; i < k; i++) {
            //要删除的位置为j相关
            int j=0;
            //前一个数，设置为0主要是'0'>0
            int pre=0;
            //循环遍历，找到需要删掉的值
            while (j<list.size()&&pre<=list.get(j)){
                pre=list.get(j);
                j++;
            }
            //删除j-1
            list.remove(j-1);
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        //去除开头的0
        while (i<list.size()&&list.get(i)=='0'){
            i++;
        }
        for (int j = i; j < list.size(); j++) {
            sb.append(list.get(j));
        }
        if(sb.toString().equals(""))
            return "0";
        return sb.toString();
    }
}
