package bytedance;

import util.ListNode;

import java.util.ArrayList;

public class NC51 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.size() - 1);
    }

    private ListNode mergeList(ArrayList<ListNode> lists, int left, int right) {
        if (left >= right) {
            return lists.get(left);
        }
        int mid = left + ((right - left) >> 1);
        ListNode node1 = mergeList(lists, left, mid);
        ListNode node2 = mergeList(lists, mid + 1, right);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
