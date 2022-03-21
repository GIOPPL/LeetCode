package s22;

import meta.ListNode;

import java.util.ArrayList;

/**
 * Created by GIOPPL
 * on 2022/3/5 16:31
 * TODO:
 */
public class BM6判断链表中是否有环 {
    public static void main(String[] args) {
        BM6判断链表中是否有环 b=new BM6判断链表中是否有环();
        ListNode l=ListNode.init(new int[]{3,2,0,-4},-1);
        boolean b1 = b.hasCycle(l);
        System.out.println(b1);
    }

    public boolean hasCycle(ListNode head) {
        ListNode l1=head;
        ListNode l2=head;
        while (l1!=null&&l2!=null){
            l1=l1.next;
            if (l2.next!=null){
                l2=l2.next.next;
            }else {
                return false;
            }
            if (l1==l2){
                return true;
            }
        }
        return false;
    }
}
