package s22;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2022/3/6 12:45
 * TODO:
 */
public class BM10两个链表的第一个公共结点 {
    public static void main(String[] args) {
        BM10两个链表的第一个公共结点 b=new BM10两个链表的第一个公共结点();
        ListNode l1=ListNode.init(new int[]{1,});
        ListNode l2=ListNode.init(new int[]{3,4,5});
        ListNode l3=ListNode.init(new int[]{6,7});
        l1=ListNode.titleAdd(l1,l3);
        l2=ListNode.titleAdd(l2,l3);
        ListNode listNode = b.FindFirstCommonNode(l1, l2);
        ListNode.seeAllElement(listNode);
    }

    public ListNode FindFirstCommonNode(ListNode h1, ListNode h2) {
        if (h1==null||h2==null){
            return null;
        }
        ListNode a=h1,b=h2;
        while (a.next!=null&&b.next!=null){
            a=a.next;
            b=b.next;
            if(a==b){
                return a;
            }
        }
        int f;
        if(b.next==null){
            a=h1;
            f=0;
        }else {
            b=a;
            a=h2;
            f=1;
        }
        while (a.next!=null){
            if (a==b){
                return a;
            }
            a=a.next;
            b=b.next;
            if (b==null&&f==0){
                b=h2;
            }else if(b==null&&f==1){
                b=h1;
            }

        }
        return null;
    }
}
