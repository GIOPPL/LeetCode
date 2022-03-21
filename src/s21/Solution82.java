package s21;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2021/7/13 14:34
 * TODO:82. 删除排序链表中的重复元素 II
 */
public class Solution82 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution82 s = new Solution82();
        ListNode h1 = ListNode.init(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode h2 = ListNode.init(new int[]{1,1,1,2,3});
        ListNode h3 = ListNode.init(new int[]{1,1,1});
        ListNode h4 = ListNode.init(new int[]{1,2,2,3,3,3,4,4,5,5});
        ListNode n = s.deleteDuplicates(h4);
        ListNode.seeAllElement(n);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //给head设置一个头节点,主要使为了防止第一个节点就开始有重复的情况了
        ListNode root = new ListNode();
        root.next = head;
        ListNode p = root;
        while (p != null) {
            //q设置为p的后续节点
            ListNode q = p.next;
            if (q != null) {
                //t设置为q的后续节点
                ListNode t = q.next;
                //查找值相同的几点
                if (t != null && q.val == t.val) {
                    while (t!=null&&t.val == q.val) {
                        t = t.next;
                    }
                    //查到最后一个不同的则用p.next指向t
                    p.next = t;
                }else {
                    //如果没有重复节点则p为p的后续
                    p = p.next;
                }
            }else {
                break;
            }
        }
        //返回head
        return root.next;
    }
}
