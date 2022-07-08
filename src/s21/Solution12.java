package s21;

import java.util.HashMap;

/**
 * Created by GIOPPL
 * on 2021/6/4 9:31
 * TODO:数字转罗马字符
    启动：
     s21.Solution12 solution12 = new s21.Solution12();
     com.test.String s = solution12.intToRoman(10);
     System.out.println(s);
 */
public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder str=new StringBuilder();
        while (num>0){
            if((num/1000>0)){
                str.append("M");
                num=num-1000;
            }else if (num/900>0){
                str.append("CM");
                num=num-900;
            }else if (num/500>0){
                str.append("D");
                num=num-500;
            }else if (num/400>0){
                str.append("CD");
                num=num-400;
            }else if (num/100>0){
                str.append("C");
                num=num-100;
            }else if (num/90>0){
                str.append("XC");
                num=num-90;
            }else if (num/50>0){
                str.append("L");
                num=num-50;
            }else if (num/40>0){
                str.append("XL");
                num=num-40;
            }else if (num/10>0){
                str.append("X");
                num=num-10;
            }else if (num/9>0){
                str.append("IX");
                num=num-9;
            }else if (num/5>0){
                str.append("V");
                num=num-5;
            }else if (num/4>0){
                str.append("IV");
                num=num-4;
            }else if (num>=1){
                str.append("I");
                num=num-1;
            }
        }
        return str.toString();
    }
}
