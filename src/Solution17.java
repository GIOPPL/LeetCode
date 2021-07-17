import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/6/7 8:26
 * TODO:手机键盘，2为abc 3为def，然后排列组合
 * 输入23->ad	ae	af	bd	be	bf	cd	ce	cf
 *
 */
public class Solution17 {
    public static void main(String args[]) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns\n"));
    }

    private static void start(){
        Solution17 solution17=new Solution17();
        List<String> list = solution17.letterCombinations("222");
        for (String s:list) {
            System.out.print(s+"\t");
        }
        System.out.println();
    }
    char[][] maps={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l',},{'m','n','o',},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    List<String> a=new ArrayList();
    Queue<String> q1 =new LinkedList<>();
    Queue<String> q2=new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.isEmpty()||digits.length()>4){
            return a;
        }
        int n=digits.charAt(0) - '2';
        for (int i = 0; i < maps[n].length; i++) {
            q1.offer(maps[n][i]+"");
        }
        for (int position = 1; position < digits.length(); position++) {
            int c=digits.charAt(position)-'2';
            while (!q1.isEmpty()){
                String y=q1.poll();
                for (int j = 0; j < maps[c].length; j++) {
                    char x=maps[c][j];
                    q2.offer(y+x);
                }
            }
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        while (!q1.isEmpty()){
            a.add(q1.poll());
        }
        return a;
    }


}
