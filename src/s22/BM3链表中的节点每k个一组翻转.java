package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/2 21:12
 * TODO:
 */
public class BM3链表中的节点每k个一组翻转 {
    public static void main(String[] args) {
        BM3链表中的节点每k个一组翻转 b = new BM3链表中的节点每k个一组翻转();
        ListNode l1 = ListNode.init(new int[]{1, 2});
        ListNode listNode = b.reverseKGroup(l1, 3);
        ListNode.seeAllElement(listNode);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null||k==1) {
            return head;
        }
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode p=head;
        int count=0;
        while (p!=null){
            p=p.next;
            count++;
        }
        count=count/k;
        ListNode pre = h;
        p = pre.next;
        int i = 1;
        while (p != null && p.next != null) {
            if(count==0){
                return h.next;
            }
            ListNode t = p.next;
            p.next = t.next;
            t.next = pre.next;
            pre.next = t;
            i++;
            if (i == k) {
                count--;
                i = 1;
                pre = p;
                p = p.next;
            }
        }
        return h.next;
    }
}
