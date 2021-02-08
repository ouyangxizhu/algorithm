package bytedance;

import util.ListNode;

import java.util.Stack;

public class NC40 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<ListNode> stack1 = new Stack<>(); //存第一个链表的节点
        Stack<ListNode> stack2 = new Stack<>(); //存第二个链表的节点
        Stack<ListNode> stack3 = new Stack<>(); //存相加后链表的节点
        ListNode tail = new ListNode(0);        //初始化重构后的链表
        ListNode result = tail;                 //定义解为重构链表的头节点
        if (head1 == null || head2 == null) {
            if (head1 == null) {
                return head2;
            } else {
                return head1;
            }
        }
        while (head1 != null) {
            stack1.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.add(head2);
            head2 = head2.next;
        }
        int val1 = 0;   //存第一个栈取出的值
        int val2 = 0;   //存第二个栈取出的值
        int sum = 0;   //存val1,val2，next的和
        int next = 0;   //定义进位值并初始化
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty() && !stack2.empty()) {
                val1 = stack1.pop().val;
                val2 = stack2.pop().val;
                sum = val1 + val2 + next;
                int val = sum % 10;
                stack3.push(new ListNode(val));
                next = sum / 10;
            }
            if (!stack1.empty() && stack2.empty()) {
                val1 = stack1.pop().val;
                sum = val1 + next;
                int val = sum % 10;
                stack3.push(new ListNode(val));
                next = sum / 10;
            }
            if (stack1.empty() && !stack2.empty()) {
                val2 = stack2.pop().val;
                sum = val2 + next;
                int val = sum % 10;
                stack3.push(new ListNode(val));
                next = sum / 10;
            }
        }
        while (!stack3.empty()) {
            ListNode node = new ListNode(stack3.pop().val);
            tail.next = node;
            tail = tail.next;
        }
        return result.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 计算结果存储的 dummy 结点
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        // 进位默认为 0
        int carry = 0;
        // 进入循环，以p和q两个链表指针都走到头为结束
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // 进位参与运算
            int sum = carry + x + y;
            // 计算进位
            carry = sum / 10;
            // 构造新的结点存储计算后的位数数值
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        // 处理数字最高位末尾进位情况
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
