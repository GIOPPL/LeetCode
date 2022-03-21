package s21;

/**
 * Created by GIOPPL
 * on 2021/6/4 10:45
 * TODO:未成功
    TODO:启动：
     s21.Solution10 solution10=new s21.Solution10();
     boolean isMatch = solution10.isMatch("aab", "c*a*b");
     System.out.println(isMatch);
 */
public class Solution10 {
    public boolean isMatch(String string, String pppp) {
        if (string.charAt(0) == '-' || string.charAt(0) == '*')
            return false;
        if (pppp.charAt(0) == '-' || pppp.charAt(0) == '*')
            return false;
        int position = 0;
        int i=0;
        while (i<pppp.length()){
            char re = string.charAt(i);
            char fo = 0;
            if (isWord(re)) {
                if(re==string.charAt(position)){
                    position++;
                    fo=re;
                }else {
                    //不相等的时候经过两步判断
                    //1.下一个位置是不是*如果是的话，那么直接跳过
                    if(string.charAt(position+1)=='*'){
                        continue;
                    }else if(fo==string.charAt(position)){
                        //2.如果和前面一样的话，那么就可以跳过了
                        position++;
                        fo=0;
                    }else {
                        return false;
                    }
                }
            }else if(re=='*'){
                continue;
            }else {
                position++;
            }
        }
        return true;
    }

    boolean isWord(char c) {
        return c >= 'a' && c <= 'z';
    }
}
