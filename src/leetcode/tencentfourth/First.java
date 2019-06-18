package tencentfourth;
/**
 * 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 * @author ouyangxizhu
 *
 */
public class First {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode midNext = mid.next;
		mid.next = null;// 将链表断开
		return margeSort(sortList(head), sortList(midNext));
	}

	private ListNode margeSort(ListNode sortList1, ListNode sortList2) {
		// 定义头结点
		ListNode head = new ListNode(0);
		// 临时节点
		ListNode temp = head;
		ListNode n1 = sortList1;
		ListNode n2 = sortList2;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				temp.next = n1;
				n1 = n1.next;
			} else {
				temp.next = n2;
				n2 = n2.next;
			}
			temp = temp.next;
		}
		temp.next = n1 == null ? n2 : n1;
		// 去掉没用的头结点
		return head.next;
	}

	private ListNode getMid(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		// 利用快慢指针去找到 链表的中间节点
		ListNode fase = head;
		ListNode slow = head;
		while (fase.next != null && fase.next.next != null) {
			slow = slow.next;
			fase = fase.next.next;
		}
		return slow;

	}

}
