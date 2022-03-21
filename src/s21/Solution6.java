package s21;

/**
 * Created by GIOPPL
 * on 2021/6/1 13:53
 TODO:将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     P   A   H   N
     A P L S I I G
     Y   I   R
     之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

 启动：TODO
     s21.Solution6 solution6=new s21.Solution6();
     String s = solution6.convert("PAYPALISHIRING", 3);
     print(s);

 */
public class Solution6 {
    ///第一种方法
    public String convert2(String s, int numRows) {
        int columNum=s.length();
        char[][] meta=new char[numRows][columNum];

        int i=0;
        int j=0;
        //0为向下走，1为向上走
        int position=0;
        while (i<columNum){
            j=0;
            while (j<numRows&&j<columNum){
                if(position<s.length()){
                    meta[j][i]=s.charAt(position++);
                }
                j++;
            }
            i++;
            j=j-2;
            while (j>0){
                if(position<s.length()){
                    meta[j][i]=s.charAt(position++);
                }
                j--;
                i++;
            }
        }
        for( i=0;i<numRows&&i<columNum;i++){
            for( j=0;j<columNum;j++){
                System.out.print(meta[i][j]+"\t");
            }
            System.out.print("\n");
        }
        StringBuilder re=new StringBuilder();
        for( i=0;i<numRows;i++){
            for(j=0;j< columNum;j++){
                char a=meta[i][j];
                if(a!='\u0000'){
                    re.append(a);
                }
            }
        }
        return re.toString();
    }
    ///第二种方法
    public String convert(String s ,int numRows){
        StringBuilder builder=new StringBuilder(s);

        int i=numRows;
        while (i<builder.length()){//PAYP*ALISHIRING
            builder.insert(i,'-');
            i=i+3;
            if(i<builder.length()){
                builder.insert(i,'-');
            }
            i=i+numRows+1;
        }
        print(builder.toString());
        s=builder.toString();

        StringBuilder re=new StringBuilder();

        ///第一步
        for(i=0;i<builder.length();i=i+numRows){
            char c=s.charAt(i);
            if(c!='-')
                re.append(c);
        }
        print("\n");
        for(i=0;i<s.length();i++){

        }
        print(re.toString());


        ///最后一步
        for(i=0;i<builder.length();i=i+numRows){
            char c=s.charAt(i+numRows-1);
            if(c!='-')
                re.append(c);
        }

        return re.toString();
    }
    static void print(Object s){
        System.out.print(s);
    }
}
