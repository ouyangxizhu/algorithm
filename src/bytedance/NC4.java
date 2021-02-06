package bytedance;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NC4 {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> se = new HashSet<ListNode>();//定义一个集合
        while (head != null) {//如果头节点不为空，就遍历链表
            if (se.contains(head)) {//判断当前节点是否出现过，如果出现过就返回true
                return true;
            }
            se.add(head);//如果没有出现过就插入
            head = head.next;//head等于下一个节点
        }
        return false;
    }
}
