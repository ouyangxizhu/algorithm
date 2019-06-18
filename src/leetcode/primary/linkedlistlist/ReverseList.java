package primary.linkedlistlist;

public class ReverseList {
	/**  head.next = 这个表达式没有赋值功能 意识表示指向哪
	 *  
	    迭代：

	newhead为新链的头， 
	1、每次从原链head里取出链头,命名为now(待插入元素)， 
	2、更新原链 
	3、将now，插入到newhead首部
	 * @author ouyangxizhu
	 *
	 */
	 public ListNode reverseList(ListNode head) {
	        ListNode newhead = null;
	        ListNode now;
	        while(head!=null){
	            now = head;
	            head = head.next;
	            now.next = newhead;
	            newhead = now;
	        }
	        return newhead;
	  }
	 /**
	  * 递归
	  *     1）如果head为空，或者只有head这一个节点，return head即可；

    2）先遍历head->next为首的链表，得到一个头结点newHead；

    3）把head赋值给head->next->next， head->next为空；

    4）返回newHead。

	  * @param head
	  * @return
	  */
	 public ListNode reverseList1(ListNode head) {
		 if(head==null||head.next==null)return head;//处理最小输入的情况，即空链表和单节点链表
         ListNode newhead=reverseList(head.next);//将调用后的结果存储，这个结果就是最终结果。之后利用递归，调用刚才存好的输入
         head.next.next=head;//上面一步的调用已经完成以second为首的链表的反转，所以现在second变成了反转完成后的尾节点 ，把这个尾节点的next指向一开始输入的前驱，即head，完成整个链表反转
         head.next=null;  //最开始的头节点要变成尾节点，即在后面补null使链表终结
         return newhead;

	  }
}
