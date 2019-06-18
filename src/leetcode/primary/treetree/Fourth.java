package primary.treetree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��

����:
����������: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
�������α��������

[
  [3],
  [9,20],
  [15,7]
]
 * @author ouyangxizhu
 *
 */
public class Fourth {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) {
			return res;
		}
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
			int count = q.size();
			List<Integer> list = new ArrayList<Integer>();
			while (count>0) {
				TreeNode temp = q.poll();
				list.add(temp.val);
				if (temp.left!=null) {
					q.add(temp.left);
				}
				if (temp.right!=null) {
					q.add(temp.right);
				}
				count--;
				
			}
			res.add(list);
			
		}
        return res;
    }
	
}
