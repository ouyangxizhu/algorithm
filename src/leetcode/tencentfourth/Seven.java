package tencentfourth;
/**
 * 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]



 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
 * @author ouyangxizhu
 *
 */
public class Seven {
	/**
	 * 两个节点分别在左右子树，公共祖先是根节点；
		两个节点都在左子树；
		两个节点都在右子树；
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)return null;  
        // 要么在左子树，要么在右子树，要么就是根节点
        while(root != null){  
            if(p.val>root.val&&q.val>root.val)  
                root=root.right;  
            else if(p.val<root.val&&q.val<root.val)  
                root=root.left;  
            else return root;  
        }
        return root;
        
    }

}
