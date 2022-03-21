package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/2 15:58
 * TODO:
 */
public class BM2链表内指定区间反转 {
    public static void main(String[] args) {
        ListNode l1=ListNode.init(new int[]{1,2,3,4,5,6,7,8});
        ListNode l2=ListNode.init(new int[]{1,2,3});
        BM2链表内指定区间反转 s=new BM2链表内指定区间反转();
        ListNode listNode = s.reverseBetween(l1, 4, 5);
        ListNode.seeAllElement(listNode);
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head==null||head.next==null||m>=n){
            return head;
        }
        ListNode h=new ListNode();
        h.next=head;

        ListNode pre=h;
        for (int i = 0; i < m - 1; i++) {
            pre=pre.next;
        }
        ListNode p=pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode t=p.next;
            p.next=t.next;
            t.next=pre.next;
            pre.next=t;
        }
        return h.next;
    }
}
