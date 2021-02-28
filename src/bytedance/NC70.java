package bytedance;

import util.ListNode;
import util.ListNodeUtil;

public class NC70 {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     * 选择排序
     */
    public ListNode sortInList1 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        while (head != null) {
            ListNode smallPre = getSmallPre(head);
            if (smallPre == null) {
                pre.next = head;
                head = head.next;
            } else {
                ListNode small = smallPre.next;
                smallPre.next = small.next;
                pre.next = small;
            }
            pre = pre.next;
        }
        return newHead.next;
    }

    private ListNode getSmallPre(ListNode head) {
        ListNode pre = null;
        int num = head.val;
        while (head.next != null) {
            if (head.next.val < num) {
                pre = head;
                num = head.next.val;
            }
            head = head.next;
        }
        return pre;
    }
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     * 归并排序
     */
    public ListNode sortInList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(next);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(-1);
        ListNode resultPre  = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                newHead.next = left;
                left = left.next;
            } else {
                newHead.next = right;
                right = right.next;
            }
            newHead = newHead.next;
        }
        newHead.next = left == null ? right : left;
        return resultPre.next;
//        if (left == null) {
//            return right;
//        }
//        if (right == null) {
//            return left;
//        }
//        ListNode head;
//        if (left.val < right.val) {
//            head = left;
//            head.next = merge(left.next, right);
//        } else {
//            head = right;
//            head.next = merge(left, right.next);
//        }
//        return head;
    }

    public static void main(String[] args) {
//        int[] a = {1, 4, 6, 5};
        int[] a = {-426572,-406609,724427,-157789,-132713,720732,-39078,-348926,-693458,559374,114739,-748249,428207,-767407,401563,646432,-682870,483610,-608888,94840,749542,359115,131739,935294,347325,80573,-869091,-757897,-860166,-227942,-484068,-170790,-362441,-860466,819197,817675,886101,463504,-100482,496406,-860791};
        ListNode node = new ListNode(a[0]);
        ListNode head = node;
        for (int i = 1; i < a.length; i++) {
            ListNode node1 = new ListNode(a[i]);
            node.next = node1;
            node = node.next;
        }
        ListNodeUtil.printListnode(new NC70().sortInList(head));

    }
}
