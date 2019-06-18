package primary.treetree;

import static org.hamcrest.CoreMatchers.nullValue;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * @author ouyangxizhu
 *思路:采用二分法来创建平衡二叉树，根结点刚好为数组中间的节点，根节点的左子树的根是数组左边部分的中间节点，
 *根节点的右子树是数据右边部分的中间节点；代码执行结果和示例给出结果不同，但满足平衡二叉树。
 */
public class Five {
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
        
    }
    public TreeNode sortedArrayToBST(int [] nums,int left,int right){
        if (left<=right) {
        	int mid = (left+right)/2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = sortedArrayToBST(nums,left,mid-1);
			root.right = sortedArrayToBST(nums,mid+1,right);
			return root;
		}else {
			return null;
		}
    }
}
