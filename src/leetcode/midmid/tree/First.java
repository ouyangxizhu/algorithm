package midmid.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * �������������
����һ���������������������� ������

ʾ��:

����: [1,null,2,3]
   1
    \
     2
    /
   3

���: [1,3,2]
����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 * @author ouyangxizhu
 *
 */
public class First {
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root) {
		findn(root);
		return list;
    }
	
	public  void findn(TreeNode root) {
		
		if (root!=null) {
			findn(root.left);
			list.add(root.val);
			findn(root.right);
		}
	}
	

}
