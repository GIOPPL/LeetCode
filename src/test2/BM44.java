package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BM44 {
    public boolean isValid (String x) {
        Stack<Character> s=new Stack();
        for(int i=0;i<x.length();i++){
            char a=x.charAt(i);
            switch(a){
                case '(':s.push('(');break;
                case '[':s.push('[');break;
                case '{':s.push('{');break;
                case ')':
                    if(!fun('(',s)){
                        return false;
                    }
                    break;
                case ']':
                    if(!fun('[',s)){
                        return false;
                    }
                    break;
                case '}':
                    if(!fun('{',s)){
                        return false;
                    }
                    break;
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
    private boolean fun(char a,Stack<Character> s){
        List<Integer> list=new ArrayList();
        Collections.sort(list,(o1, o2)-> o2-o1);
        if(s.isEmpty()){
            return false;
        }
        char b=s.pop();
        return a==b;
    }
}
