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
    public static ListNode init(int[] list) {
        return init2(list,0);
    }
    public static ListNode init2(int[] list, int position) {
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
