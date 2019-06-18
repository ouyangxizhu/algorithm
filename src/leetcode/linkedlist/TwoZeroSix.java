package linkedlist;

public class TwoZeroSix {

	public ListNode reverseList(ListNode head) {
         if(head==null||head.next==null)return head;
         ListNode newhead=reverseList(head.next);
         head.next.next=head;
         head.next=null;
         return newhead;
    }
	public ListNode reverseList1(ListNode head) {
		ListNode next = new ListNode();
        while (head!=null) {
        	
		}
   }
}
