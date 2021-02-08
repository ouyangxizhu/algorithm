package bytedance;

import jdk.nashorn.internal.ir.ReturnNode;
import util.TreeNode;

public class NC102 {
    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return commonAncestor(root, o1, o2).val;
    }

    private TreeNode commonAncestor(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, o1, o2);
        TreeNode right = commonAncestor(root.right, o1, o2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
