import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2021/6/24 9:46
 * TODO:给你一个链表数组，每个链表都已经按升序排列。
 *  请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution23 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start(){
        int[][] l= new int[][]{{2,3,5,7},{1,3,5},{},{}};
        ListNode[] list=new ListNode[l.length];
        for (int i = 0; i < l.length; i++) {
            ListNode node = ListNode.init2(l[i], 0);
            list[i]=node;
//            meta.ListNode.seeAllElement(node);
        }
        Solution23 solution23=new Solution23();
        ListNode re = solution23.mergeKLists(list);
        ListNode.seeAllElement(re);
    }

    /**
     * 有list.length个头指针，定义一个空的链表头re，每次比较一列，取一列中的最小值，将这个最小的节点放入re中
     * 只要所有的链表头都为空了那么所有比较都结束了
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] heads=new ListNode[lists.length];
        for (int i = 0; i < heads.length; i++) {
            ListNode head=new ListNode();
            head.next=lists[i];
            heads[i]=head;
        }
        //下面我们开始从heads[min]来计算
        //是否所有的头节点都是空，如果不是那就继续循环
        ListNode re=new ListNode();
        //返回链表的最后节点指针
        ListNode p=re;
        re.next=null;
        while (true){
            int minKey=-1;
            int minVal=Integer.MAX_VALUE;
            for (int i = 0; i < heads.length; i++) {
                //遍历一排，找到最小的节点
                if (heads[i]!=null&&heads[i].next!=null&&minVal>heads[i].next.val){
                    minKey=i;
                    minVal=heads[i].next.val;
                }
            }
            //在-1的时候说明所有链表都已经没节点了
            if (minKey==-1){
                return re.next;
            }else {
                ListNode node=new ListNode();
                node.val=heads[minKey].next.val;
                node.next=null;
                p.next=node;
                p=p.next;
                heads[minKey].next=heads[minKey].next.next;
            }
        }
    }

    private ListNode merge(ListNode lists1, ListNode lists2){
        ListNode head1=new ListNode();
        head1.next=lists1;
        ListNode head2=new ListNode();
        head2.next=lists2;
        ListNode p1=head1;
        while (p1.next!=null&&head2.next!=null){
            if(p1.next.val>head2.next.val){
                ListNode t=head2.next;
                head2.next=t.next;
                t.next=p1.next;
                p1.next=t;
                p1=p1.next;
            }else {
                p1=p1.next;
            }
        }
        if(p1.next==null){
            p1.next=head2.next;
        }
        return head1.next;
    }
}
