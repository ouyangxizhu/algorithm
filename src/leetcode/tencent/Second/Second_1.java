package Tencent.Second;

public class Second_1 {
	 public ListNode reverseList(ListNode head) {
	        ListNode newhead=null;
	        ListNode now;
	        while(head!=null){
	            now=head;         //取头
	            head=head.next;   //更新原链头
	            now.next=newhead; //插入新链
	            newhead=now;      //更新新链头
	        }
	        return newhead;
	    }


}
