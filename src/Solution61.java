import meta.ListNode;

import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/11 20:59
 * TODO:链表旋转
 */
public class Solution61 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution61 s = new Solution61();
        ListNode h1 = ListNode.init(new int[]{1, 2, 3, 4, 5});
        ListNode h2 = ListNode.init(new int[]{1, 2});
        ListNode h3 = ListNode.init(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode h4 = ListNode.init(new int[]{0, 1});
        ListNode nn = s.rotateRight(h3, 3);
        ListNode.seeAllElement(nn);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //初始化head的长度
        int length = 0;
        //p是游标
        ListNode p = head;
        //计算链表的长度
        while (p.next != null) {
            length++;
            p = p.next;
        }
        length++;
        //对k取余，意思是不需要重复计算
        k = k % length;
        //如果为0，正常情况下是要走一圈，这边一次都不用走
        if (k == 0) {
            return head;
        }
        //p将首尾链接起来形成一个环
        p.next = head;
        //初始化
        p = head;
        //x是count数，计算距离
        int x = 0;
        //一直将p移动到正确答案的前一个节点
        while (x < length - k - 1) {
            p = p.next;
            x++;
        }
        //q就是我妈需要返回的数
        ListNode q = p.next;
        //在前面断开链表
        p.next = null;
        return q;
    }
}
