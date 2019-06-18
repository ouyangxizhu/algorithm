package high.linkedlist;

import java.util.PriorityQueue;

/**
 * �ϲ�K��Ԫ�ص���������
�ϲ� k �������������غϲ������������������������㷨�ĸ��Ӷȡ�

ʾ��:

����:
[
  1->4->5,
  1->3->4,
  2->6
]
���: 1->1->2->3->4->4->5->6
 * @author ouyangxizhu
 *
 */
public class First {
	/**
	 * ������С�ѵ�˼�룬��K�������ͷ�ڵ�������ȶ����У�����ʱ���ض���Ԫ�أ����Ѹö���Ԫ�ص���һ�ڵ�������ȶ����У�ֱ�����ȶ���Ϊ�ա�

ע�⣺�����пӣ�K�������У������п�������
--------------------- 
���ߣ�whd_Alive 
��Դ��CSDN 
ԭ�ģ�https://blog.csdn.net/whdAlive/article/details/80467493 
��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
	 */
	//˼·�� ���ȶ���(С����) ����

    //�����Ŀ�!!!K���ڵ㣬ÿ���ڵ㶼�п����ǿգ�����Ҳ����˵��Ȼlists���г��ȣ����ǿ��ܺܶ��Ԫ�ض���null
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
