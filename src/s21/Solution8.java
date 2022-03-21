package s21;

/**
 * Created by GIOPPL
 * on 2021/6/2 22:01
 * TODO:给定一个字符串，转成数字，
        1。判断是否有空格，删除
        2.判断正负号
        3.判断数字
    启动：
     s21.Solution8 solution8=new s21.Solution8();
     int i = solution8.myAtoi("9223372036854775808");
     System.out.println(i);
 */
public class Solution8 {

    public int myAtoi(String s) {
        if (s.isEmpty())
            return 0;
        long re=0;
        boolean isPositiveValue=true;
        int i=0;
        while (i<s.length()&&(s.charAt(i)==' ')){
            i++;
        }
        if(i<s.length()){
            char cc=s.charAt(i++);
            if(cc=='-'){
                isPositiveValue=false;
            }else if(cc>='0'&&cc<='9'){
                i--;
            }else{
                if(cc!='+'){
                    return 0;
                }
            }
        }

        while (i<s.length()&&(s.charAt(i)=='0')){
            i++;
        }

        for (;i<s.length();i++){
            char c=s.charAt(i);
            if(!(c>='0'&&c<='9')){
                break;
            }else {
                re=re*10+c-'0';
            }
            if(re>=Integer.MAX_VALUE){
                break;
            }
        }
        if(isPositiveValue){
            if(re>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }else {
            re=-re;
            if (re<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) re;
    }
}
