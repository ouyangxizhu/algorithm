package bytedance;

import util.ListNode;
import util.ListNodeUtil;

public class NC21 {
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode startPre = newHead;
        ListNode tail = head;
        int num = n - m;
        while (--m > 0) {
            startPre = startPre.next;
            tail = tail.next;
        }
        while (num-- > 0) {
            tail = tail.next;
        }
        reverse(startPre, tail.next);
        return newHead.next;
    }

    private void reverse(ListNode startPre, ListNode tail) {
        ListNode start = startPre;
        ListNode pre = startPre;
        ListNode head = startPre.next;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        ListNode next = start.next;
        start.next = pre;
        next.next = head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode node1 = new NC21().reverseBetween(node, 2, 3);
        ListNodeUtil.printListnode(node1);
    }
}
