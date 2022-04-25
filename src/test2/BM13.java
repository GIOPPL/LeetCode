package test2;

import meta.ListNode;

import java.util.Stack;

public class BM13 {
    public static void main(String[] args) {
        BM13 b=new BM13();
        ListNode l=ListNode.init(new int[]{1,4,2,3,2,4,1});
        boolean pail = b.isPail(l);
        System.out.println(pail);
    }
    public boolean isPail (ListNode h) {
        if (h==null){
            return false;
        }
        Stack<Integer> s=new Stack<>();
        ListNode p=h;
        while (p!=null){
            s.push(p.val);
            p=p.next;
        }
        p=h;
        while (!s.isEmpty()){
            int a=s.pop();
            int b=p.val;
            if (a!=b){
                return false;
            }
            p=p.next;
        }
        return true;
    }
}
