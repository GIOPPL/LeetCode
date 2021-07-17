import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/11 15:43
 * TODO:通过删除字母匹配到字典里最长单词
 */
public class Solution524 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution524 s=new Solution524();
        List<String> list1=new ArrayList<>();
        list1.add("ale");
        list1.add("apple");
        list1.add("monkey");
        list1.add("plea");
        String s1="abpcplea";
        String ss = s.findLongestWord(s1, list1);
        System.out.println(ss);
    }
    public String findLongestWord(String s, List<String> dictionary) {
        //先将s转化成数组
        char[] t1=s.toCharArray();
        //记录最长字典序最小的字符串
        String maxString="";
        //循环遍历字典里的内容
        for (String value : dictionary) {
            //字典里的内容转成数组
            char[] t2 = value.toCharArray();
            //t1是否包含t2
            if (isContain(t1, t2) ) {
                //如果包含的情况下，判断t2长度是否大于maxString
                if(maxString.length()<t2.length){
                    //如果大于则赋值
                    maxString = value;
                }else if(maxString.length()==t2.length){
                    //如果相等的情况下，判断字典序哪一个小
                    if(!isT1LessThanT2(maxString.toCharArray(),t2)){
                        maxString=value;
                    }
                }
            }
        }
        return maxString;
    }

    //t1和t2哪一个字典序最小
    private boolean isT1LessThanT2(char[] t1, char[] t2){
        //比较，如果相等则往后移动，不相等则返回字典序较小的那一个
        for (int i = 0; i < t1.length; i++) {
            char c1=t1[i];
            char c2=t2[i];
            if(c1>c2){
                return false;
            }else if(c1<c2){
                return true;
            }
        }
        return false;
    }
    //是否t1是否包含t2，双指针
    private boolean isContain(char[] t1,char[] t2){
        //如果t1长度小于t2，不用比了
        if(t1.length<t2.length){
            return false;
        }
        int i=0;
        int j=0;
        while (i<t1.length&&j<t2.length){
            //不管如何i都要++
            char c1=t1[i++];
            char c2=t2[j];
            //如果相等t2的指针往后移动
            if(c1==c2){
                j++;
            }
        }
        //如果t2的指针到了最后面，那么说明包含
        return j == t2.length;
    }
}
