package s21;

/**
 * Created by GIOPPL
 * on 2021/5/31 14:20
 * TODO:给你一个字符串 s，找到 s 中最长的回文子串。
    启动：
     s21.Solution5 solution5=new s21.Solution5();
     String s = solution5.longestPalindrome("babad");
     print(s);
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        String re="";
        int max=0;
        for(int i=0;i<s.length();i++){
            String m1=one(s,i);
            String m2=two(s,i);
            if(max<Math.max(m1.length(),m2.length())){
                if(m1.length()<m2.length()){
                    re=m2;
                    max=m2.length();
                }else {
                    re=m1;
                    max=m1.length();
                }
            }
        }
        return re;
    }
    String one(String s,int start){
        int i=start-1;
        int j=start+1;
        while (i>=0&&j<=s.length()-1&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    String two(String s,int start){
        int i=start;
        int j=start+1;
        while (i>=0&&j<=s.length()-1&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

}
