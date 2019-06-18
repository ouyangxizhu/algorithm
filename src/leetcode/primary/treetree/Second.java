package primary.treetree;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

����һ��������������������������

�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
�ڵ��������ֻ�������ڵ�ǰ�ڵ������
�������������������������Ҳ�Ƕ�����������
ʾ�� 1:

����:
    2
   / \
  1   3
���: true
ʾ�� 2:

����:
    5
   / \
  1   4
     / \
    3   6
���: false
����: ����Ϊ: [5,1,4,null,null,3,6]��
     ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��
 * @author ouyangxizhu
 *
 */
public class Second {
	 public boolean isValidBST(TreeNode root) {
	     if (root == null) {
			return true;
		}
	     List<Integer> list = new ArrayList<Integer>();
	     search(root,list);
	     for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i)>=list.get(i+1)) {
				return false;
			}
		}
	     return true;
	 }
	 public static void search(TreeNode root, List<Integer> list){
		 if (root==null) {
			return;
		}
		 search(root.left, list);
		 list.add(root.val);
		 search(root.right, list);
	 }
}
