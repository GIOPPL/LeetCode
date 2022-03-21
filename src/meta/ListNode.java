package meta;

/**
 * Created by GIOPPL
 * on 2021/6/8 9:48
 * TODO:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 环形链表
     * @param list 数组
     * @param cyclic 最后一个节点连接第几个节点
     * @return 链表
     */
    public static ListNode init(int[] list,int cyclic){
        ListNode l=init(list);
        if (cyclic==-1){
            return l;
        }
        ListNode p=l;
        ListNode q=l;
        for (int i = 0; i < cyclic-1; i++) {
            p=p.next;
        }
        while (q.next!=null){
            q=q.next;
        }
        q.next=p;
        return l;
    }

    /**
     * l1尾部添加l2
     */
    public static ListNode titleAdd(ListNode l1,ListNode l2){
        ListNode p=l1;
        while (p.next!=null){
            p=p.next;
        }
        p.next=l2;
        return l1;
    }

    public static ListNode init(int[] list) {
        return init2(list,0);
    }
    private static ListNode init2(int[] list, int position) {
        if (list.length>position){
            ListNode listNode=new ListNode(list[position]);
            listNode.next= init2(list,position+1);
            return listNode;
        }
        return null;
    }
    public static void seeAllElement(ListNode node){
        while (node!=null){
            System.out.print(node.val+"\t");
            node=node.next;
        }
        System.out.println();
    }

}
