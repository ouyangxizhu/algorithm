package bytedance;

import util.ListNode;

public class NC24 {
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
        ListNode resultPre = pre;
        pre.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode tmp = cur.next;
                while (tmp != null && tmp.val == cur.val) {
                    tmp = tmp.next;
                }
                pre.next = tmp;
                cur = tmp;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }
        return resultPre.next;
    }
}
