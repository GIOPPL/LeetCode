package test2;

import meta.ListNode;

public class BM15 {
    public static void main(String[] args) {
        BM15 b=new BM15();
        ListNode l=ListNode.init(new int[]{1,1,2,2,2,2,3,4,4});
        ListNode l2 = b.deleteDuplicates(l);
        ListNode.seeAllElement(l2);
    }
    public ListNode deleteDuplicates (ListNode h) {
        if (h==null){
            return null;
        }
        ListNode p=h;
        while (p.next!=null){
            ListNode q=p.next;
            if (p.val==q.val){
                p.next=q.next;
            }else{
                p=p.next;
            }
        }
        return h;
    }


}
