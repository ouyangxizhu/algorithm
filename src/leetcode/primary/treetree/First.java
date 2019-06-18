package primary.treetree;
/**
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 * @author ouyangxizhu
 *二叉树的最大深度是距根节点路径最长的某一树叶节点的深度。 
二叉树的深度等于二叉树的高度，也就等于根节点的高度。根节点的高度为左右子树的高度较大者+1。 
由此思想可用递归求解，其实也就是后序遍历二叉树的算法。
 */
public class First {
	public int maxDepth(TreeNode root) {
        if (root == null) {
			return 0; 
		}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left>right)?left+1:right+1;
    }
}
