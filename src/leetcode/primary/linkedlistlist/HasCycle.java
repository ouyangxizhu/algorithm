package primary.linkedlistlist;
/**
 * 给定一个链表，判断链表中是否有环。

进阶：
你能否不使用额外空间解决此题？
 * @author ouyangxizhu
 *
 */
public class HasCycle {
	 public static boolean cCycle(ListNode head) {
	        if(head==null||head.next==null)return false;
	        ListNode fast=head,slow=head;
	        while(fast.next!=null&&fast.next.next!=null){
	        	if(fast==slow){
	                return true;
	            }
	            fast=fast.next.next;
	            slow=slow.next;  
	        }
	        return false;
	    }
	 public static void main(String[] args) {
		int [] arr = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
		
		ListNode head = new ListNode(arr[0]);
		ListNode node = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode listNode = new ListNode(arr[i]);
			node.next = listNode;
			node = listNode;
		}
		System.out.println(cCycle(head));
	}
}
