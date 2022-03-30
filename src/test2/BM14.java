package test2;

import meta.ListNode;

public class BM14 {
    public static void main(String[] args) {
        BM14 b=new BM14();
//        ListNode l=ListNode.init(new int[]{1,2,3,4,5,6});
        ListNode l=ListNode.init(new int[]{1,2});
        ListNode l2 = b.oddEvenList(l);
        ListNode.seeAllElement(l2);
    }
    public ListNode oddEvenList (ListNode h) {
        if (h==null){
            return h;
        }
        //偶数
        ListNode h2=new ListNode(-1);
        ListNode p2=h2;
        ListNode p1=h;
        while (p1.next!=null){
            ListNode t=p1.next;
            if (t.next!=null){
                p1.next=t.next;
                p1=t.next;
            }else {
                p1=p1.next;
                break;
            }
//            t.next=p2.next;
//            p2.next=t;


            p2.next=t;
            t.next=null;
            p2=p2.next;
        }
        p1.next=h2.next;
        return h;
    }
}
