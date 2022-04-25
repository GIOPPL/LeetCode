package test2;

import meta.ListNode;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BM16 {
    public static void main(String[] args) {
        BM16 b=new BM16();
        ListNode l=ListNode.init(new int[]{1,2,3,3,4});
        ListNode l2 = b.deleteDuplicates(l);
        ListNode.seeAllElement(l2);
    }
    public ListNode deleteDuplicates (ListNode head) {
        ListNode h=new ListNode(-1);
        h.next=head;
        ListNode p=h,q;
        int t=0;
        while (p.next!=null){
            q=p.next;
            while (q.next!=null&&q.val==q.next.val){
                q=q.next;
                t=1;
            }
            if (t==0){
                p.next=q;
                p=p.next;
            }else {
                p.next=q.next;
            }
            t=0;
        }
        return h.next;
    }
}
