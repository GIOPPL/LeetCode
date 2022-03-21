package s21;

import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/6/30 21:53
 * TODO:划分字母区间。字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
       返回一个表示每个字符串片段的长度的列表。
    示例：
         输入：S = "ababcbacadefegdehijhklij"
         输出：[9,7,8]
         解释：
         划分结果为 "ababcbaca", "defegde", "hijhklij"。
         每个字母最多出现在一个片段中。
         像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
    解题思路：贪心算法
        1.先建立最后出现位置表(关键),位置表的建立主要是从后往前搜索相同的值，填入数组中
        2.根据位置表来切块

 */
public class Solution763 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }
    private static void start(){
        Solution763 solution763=new Solution763();
        String s1="abc";
        String s2="ababcbacadefegdehijhklij";
        String s3="abcca";
        String s4="abcdefcde";
        String s5="caedbdedda";
        System.out.println(solution763.partitionLabels(s2));
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        //x数组是每一个字母出现在表中最后一次的位置
        int[] x=new int[s.length()];
        //map是为了记住字符的位置，如果遇到重复的字符，可以直接在map里取
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            //如果map里面有这个字符，可以直接取
            if (map.containsKey(c)){
                x[i]=map.get(c);
            }else{
                //如果没有这个字符，只能从后往前找了
                int j;
                for (j = s.length()-1; j >i&&s.charAt(j)!=c; j--);
                //如果数组中只有一个这个字符，就不放到map中了
                if(i!=j){
                    map.put(c,j);
                }
                //在x的的位置填该元素最后一次出现在表中的位置
                x[i]=j;
            }
        }
        //上面是为了建立一个位置表
        //下面是为了算出每个间隔有多少字符
        int i=0;
        while (i<x.length){
            //取出最后一次出现的位置
            int end=x[i];
            //如果只有一次的话，那么在list中加一个1就好了
            if(end==i){
                //说明只有整个数组中只有一个
                i++;
                list.add(1);
            }else{
                //如果多次出现，那么需要找中间最大元素的位置
                for (int j = i+1; j < end; j++) {
                    end=Math.max(end,x[j]);
                }
                //加入list
                list.add(end-i+1);
                //i的值要更新成最大end元素下一个的值
                i=end+1;
            }
        }
        return list;
    }

}
