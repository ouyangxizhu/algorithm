package bytedance;

import util.ListNode;

public class NC133 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;

    }
}
