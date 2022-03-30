package test2;

import meta.ListNode;

import java.util.Stack;

public class BM11 {

    public static void main(String[] args) {
        BM11 b=new BM11();
        ListNode l1=ListNode.init(new int[]{9,3,7});
        ListNode l2=ListNode.init(new int[]{6,3});
        ListNode l3 = b.addInList(l1, l2);
        ListNode.seeAllElement(l3);
    }
    public ListNode addInList (ListNode h1, ListNode h2) {
        if (h1==null){
            return h2;
        }
        if (h2==null){
            return h1;
        }
        Stack<ListNode> s1=new Stack<>();
        Stack<ListNode> s2=new Stack<>();
        ListNode p1=h1,p2=h2;
        while (p1!=null||p2!=null){
            if (p1!=null){
                s1.push(p1);
                p1=p1.next;
            }
            if(p2!=null){
                s2.push(p2);
                p2=p2.next;
            }
        }
        ListNode h3=new ListNode(-1);
        h3.next=null;
        int t=0;
        while (!s1.isEmpty()&&!s2.isEmpty()){
            int a=s1.pop().val;
            ListNode b=s2.pop();
            b.val=a+b.val+t;
            t=0;
            if (b.val>=10){
               t=1;
               b.val=b.val-10;
            }
            b.next=h3.next;
            h3.next=b;
        }
        while (!s1.isEmpty()||!s2.isEmpty()){
            ListNode b;
            if (!s1.isEmpty()){
                b=s1.pop();
            }else{
                b=s2.pop();
            }
            b.val=b.val+t;
            t=0;
            if (b.val>=10){
                t=1;
                b.val=b.val-10;
            }
            b.next=h3.next;
            h3.next=b;
        }
        if (t==1){
            ListNode b=new ListNode(1);
            b.next=h3.next;
            h3.next=b;
        }
        return h3.next;
    }

}
