import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2021/6/8 9:45
 * TODO:
 */
public class Solution19 {
    public static void main(String args[]) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        int[] a={1,2,3,4,5};
        ListNode head=ListNode.init2(a,0);
        Solution19 solution19=new Solution19();
        ListNode listNode = solution19.removeNthFromEnd(head, 0);
        ListNode.seeAllElement(listNode);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||n<0){
            return null;
        }
        ListNode p=head,q;
        while(p!=null&&n>-1){
            p=p.next;
            n--;
        }
        if(p==null&&n==0){
            return head.next;
        }else if(p==null&&n>0){
            return null;
        }
        q=head;
        while(p!=null){
            p=p.next;
            q=q.next;
        }
        if(q.next==null){
            return head;
        }
        q.next=q.next.next;
        return head;
    }
}
