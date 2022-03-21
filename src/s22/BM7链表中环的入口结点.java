package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/5 19:25
 * TODO:
 */
public class BM7链表中环的入口结点 {
    public static void main(String[] args) {
        BM7链表中环的入口结点 b=new BM7链表中环的入口结点();
        ListNode l1=ListNode.init(new int[]{1,2,3,4,5,6,7,8},7);
        ListNode l2=ListNode.init(new int[]{3,2,0,-4},2);
        ListNode listNode = b.EntryNodeOfLoop(l1);
        System.out.println(listNode.val);
    }
    public ListNode EntryNodeOfLoop(ListNode h) {
        ListNode a=h;
        ListNode b=h;
        while (a!=null&&b!=null){
            a=a.next;
            if(b.next!=null){
                b=b.next.next;
            }else {
                return null;
            }
            if(a==b){
                break;
            }
        }
        if(a==null||b==null)
            return null;
        a=h;
        while (a!=b){
            a=a.next;
            b=b.next;
        }
        return a;
    }
}
