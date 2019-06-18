package high.linkedlist;

import java.util.PriorityQueue;

/**
 * 合并K个元素的有序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 * @author ouyangxizhu
 *
 */
public class First {
	/**
	 * 采用最小堆的思想，将K个链表的头节点放入优先队列中，遍历时返回队首元素，并把该队首元素的下一节点放入优先队列中，直至优先队列为空。

注意：该题有坑，K个链表中，可能有空链表！！
--------------------- 
作者：whd_Alive 
来源：CSDN 
原文：https://blog.csdn.net/whdAlive/article/details/80467493 
版权声明：本文为博主原创文章，转载请附上博文链接！
	 */
	//思路是 优先队列(小顶堆) 遍历

    //遇到的坑!!!K个节点，每个节点都有可能是空！！！也就是说虽然lists数有长度，但是可能很多个元素都是null
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        if(queue.isEmpty()){
            return null;
        }
        ListNode temp = new ListNode(queue.peek().val);
        ListNode head = temp;
        while(!queue.isEmpty()){
            ListNode p = queue.poll();
            temp.next = p;
            temp = temp.next;
            if(p.next!=null){
                queue.offer(p.next);
            }
        }
        return head.next;
    }


}
