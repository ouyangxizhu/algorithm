package bytedance;

import util.ListNode;

public class NC25 {
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode preResult = pre;
        while (head != null) {
            if (head.val != pre.val) {
                pre.next = head;
                pre = pre.next;
            }
            head = head.next;
        }
        pre.next = null;
        return preResult.next;
    }

}
