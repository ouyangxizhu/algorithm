package Tencent.Second;

public class Second_1 {
	 public ListNode reverseList(ListNode head) {
	        ListNode newhead=null;
	        ListNode now;
	        while(head!=null){
	            now=head;         //ȡͷ
	            head=head.next;   //����ԭ��ͷ
	            now.next=newhead; //��������
	            newhead=now;      //��������ͷ
	        }
	        return newhead;
	    }


}
