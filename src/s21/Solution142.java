package s21;

import meta.ListNode;

/**
 * Created by GIOPPL
 * on 2021/7/9 20:17
 * TODO:环形链表2
 */
public class Solution142 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution142 s = new Solution142();
        ListNode head = ListNode.init(new int[]{1, 2});
        ListNode position = s.detectCycle(head);
        System.out.println(position.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        do {
            //slow每次走一步
            slow = slow.next;
            //quick每次走两步
            quick = quick.next.next;
            //一直到相遇的时候或者等于空的时候结束
        } while (quick != null && quick.next != null && quick.next.next != null && quick != slow);
        //如果无环，直接返回
        if (quick == null || quick.next == null || quick.next.next == null) {
            return null;
        }
        //将quick放到最前面
        quick = head;
        //这时，每次走一步
        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }
        //返回相遇节点
        return quick;
    }
}
