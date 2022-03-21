package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/2 21:39
 * TODO:
 */
public class BM4合并两个排序的链表 {
    public static void main(String[] args) {
        BM4合并两个排序的链表 b = new BM4合并两个排序的链表();
        ListNode l1 = ListNode.init(new int[]{1, 3, 5});
        ListNode l2 = ListNode.init(new int[]{1});
        ListNode merge = b.Merge(l1, l2);
        ListNode.seeAllElement(merge);
    }

    public ListNode Merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode h = new ListNode(-1);
        ListNode p1, p2, t,head=h;
        p1 = l1;
        p2 = l2;
        while (p1!=null&&p2!=null){
            if(p1.val<p2.val){
                t=p1;
                p1=p1.next;
                t.next=null;
            }else {
                t=p2;
                p2=p2.next;
            }
            h.next=t;
            h=h.next;
        }
        if(p1==null){
            h.next=p2;
        }
        if (p2==null){
            h.next=p1;
        }
        return head.next;
    }
}
