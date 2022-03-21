package s21;

import meta.ListNode;

public class Solution2 {
    int[] list1={5};
    int[] list2={5};
    public Solution2(){
        ListNode node1 = init(list1, 0);
        ListNode node2 = init(list2, 0);
        ListNode node3=addTwoNumbers(node1,node2);
        seeNode(node3);
    }
    void seeNode(ListNode node){
        while (node!=null){
            System.out.print(node.val+"\t");
            node=node.next;
        }
    }

    private ListNode init(int[] list,int position) {
        if (list.length>position){
            ListNode listNode=new ListNode(list[position]);
            listNode.next=init(list,position+1);
            return listNode;
        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode tail=head;
        int temp=0;
        while(l1!=null&&l2!=null){
            ListNode l3=new ListNode();
            int a=l1.val+l2.val;
            if(temp!=0){
                a++;
                temp=0;
            }
            if (a>=10){
                a=a%10;
                temp=1;
            }
            l3.val=a;
            l1=l1.next;
            l2=l2.next;
            tail.next=l3;
            tail=tail.next;
        }
        if(l1!=null){
            tail.next=l1;
            tail.next.val=l1.val+temp;
            while (l1!=null&&l1.val>9){
                if(l1.next!=null){
                    l1.next.val++;
                }else{
                    l1.next=new ListNode(1,null);
                }
                l1.val=0;
                l1=l1.next;
            }
        }else if(l2!=null){
            tail.next=l2;
            tail.next.val=l2.val+temp;
            while (l2!=null&&l2.val>9){
                if(l2.next!=null){
                    l2.next.val++;
                }else{
                    l2.next=new ListNode(1,null);
                }
                l2.val=0;
                l2=l2.next;
            }
        }else if(l1==null&&l2==null&&temp==1){
            tail.next=new ListNode(1,null);
        }
        return head.next;
    }
}
