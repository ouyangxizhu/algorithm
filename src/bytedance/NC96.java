package bytedance;

import util.ListNode;

import java.util.Stack;

public class NC96 {
    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            stack.push(slow);
        }
        slow = slow.next;


        while (slow != null) {
            if (stack.pop().val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
