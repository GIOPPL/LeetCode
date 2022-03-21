package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/5 20:23
 * TODO:
 */
public class BM9删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        BM9删除链表的倒数第n个节点 b=new BM9删除链表的倒数第n个节点();
        ListNode l=ListNode.init(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode listNode = b.removeNthFromEnd(l, 9);
        ListNode.seeAllElement(listNode);
    }
    public ListNode removeNthFromEnd (ListNode h, int k) {
        if(k==0)
            return h;
        ListNode a=h,b=h;
        for (int i = 0; i < k+1; i++) {
            if(i==k&&a==null)
                return h.next;
            a=a.next;
        }
        while (a!=null){
            a=a.next;
            b=b.next;
        }

        b.next=b.next.next;
        return h;
    }
}
