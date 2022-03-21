package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/5 20:02
 * TODO:
 */
public class BM8链表中倒数最后k个结点 {
    public static void main(String[] args) {
        BM8链表中倒数最后k个结点 b=new BM8链表中倒数最后k个结点();
        ListNode l=ListNode.init(new int[]{1,2,3,4,5,6,7,8});
        ListNode listNode = b.FindKthToTail(l, 0);
        ListNode.seeAllElement(listNode);
    }
    public ListNode FindKthToTail (ListNode h, int k) {
        if (h==null||k<=0)
            return null;
        ListNode a=h,b=h;
        for (int i = 0; i < k; i++) {
            a=a.next;
            if (a==null){
                if (i==k-1){
                    return h;
                }
                return null;
            }
        }
        while (a!=null){
            a=a.next;
            b=b.next;
        }
        return b;
    }
}
