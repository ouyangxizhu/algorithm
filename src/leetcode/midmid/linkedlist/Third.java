package midmid.linkedlist;
/**
 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣

 

���磬�������������

A:          a1 �� a2
                   �K
                     c1 �� c2 �� c3
                   �J            
B:     b1 �� b2 �� b3
�ڽڵ� c1 ��ʼ�ཻ��

 

ע�⣺

�����������û�н��㣬���� null.
�ڷ��ؽ���������������뱣��ԭ�еĽṹ��
�ɼٶ���������ṹ��û��ѭ����
���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档
 

��л:
�ر��л @stellari ��Ӵ����Ⲣ�������в���������
 * @author ouyangxizhu
 *
 */
public class Third {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1=headA;
        ListNode cur2=headB;
        while(cur1!=cur2){////���û���ཻ����ôcurA==null,curB==nullʱ��ȣ�����null
            cur1=(cur1==null)?headB:cur1 .next;
            cur2=(cur2==null)?headA:cur2.next;
        }
        return cur1;
    }
}
