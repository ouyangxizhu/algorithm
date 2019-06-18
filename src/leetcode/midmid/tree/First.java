package midmid.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历二叉树
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
