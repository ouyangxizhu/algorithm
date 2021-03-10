package bytedance;

import util.TreeNode;

public class NC9 {
    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
