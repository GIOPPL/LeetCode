import java.util.HashMap;
import java.util.Map;

/**
 * Created by GIOPPL
 * on 2021/7/11 9:04
 * TODO:
 */
public class Solution76不会 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution76不会 s=new Solution76不会();
        String s1="EDADOBECODEBANC";String t1="ABC";
        String s2="ADOBECODEBANC";String t2="ABC";
        String s3="aaa";String t3="aa";
        String ss = s.minWindow(s3, t3);
        System.out.println(ss);
    }
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        Map<Character,Integer> map=new HashMap<>();
        String result = null;
        int i=-1;
        int j=0;
        for (int k = 0; k < t.length(); k++) {
            char c=t.charAt(k);
            if(map.get(c)==null){
                map.put(c,1);
            }else {
                int v=map.get(c);
                map.put(c,v+1);
            }
        }
        while (j<s.length()){
            char c=s.charAt(j);
            if(map.containsKey(c)){
                int v=map.get(c);
                //map里面这个值没有遇到过
                if(v<=1){
                    map.put(c,map.get(c)-1);
                    int temp=i+1;
                    //包含所有的的值
                    while(isContainAllElement(map)){
                        //包含这个值
                        if(map.get(s.charAt(temp))!=null){
                            //得到这个值value
                            int tempValue=map.get(s.charAt(temp));
                            //如果这个不用这个值，那么这段字符不会全部包括t
                            if(tempValue>1){
                                i=temp;
                                if(result==null){
                                    result=s.substring(i,j+1);
                                }else {
                                    String r=s.substring(i,j+1);
                                    if(r.length()<result.length()){
                                        result=r;
                                    }
                                }
                                map.put(s.charAt(temp),0);
                                break;
                            }else {
                                map.put(s.charAt(temp),tempValue-1);
                                temp++;
                            }
                        }
                        temp++;
                    }
                }else {
                    map.put(c,v+1);
                }
            }
            j++;
        }
        return result==null?"":result;
    }
    private boolean isContainAllElement(Map<Character,Integer> map){
        for (Integer x: map.values()){
            if (x>0){
                return false;
            }
        }
        return true;
    }
}
